//package Spring;
//
//
//import com.google.common.collect.ImmutableMap;
//import constants.DefaultScripts;
//import org.easymock.EasyMock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import ru.sbrf.ascc.audit.service.AuditHelperService;
//import ru.sbrf.ascc.audit.service.BagAuditService;
//import ru.sbrf.ascc.bag.BagAccStatus;
//import ru.sbrf.ascc.bag.BagAccStatusHistoryEntry;
//import ru.sbrf.ascc.bag.BagAccStatusHistoryEntryRSExtractor;
//import ru.sbrf.ascc.bag.BagDAO;
//import ru.sbrf.ascc.bag.BagManager;
//import ru.sbrf.ascc.bag.BagNumbersRepository;
//import ru.sbrf.ascc.bag.BagSplitService;
//import ru.sbrf.ascc.bag.BagStatus;
//import ru.sbrf.ascc.bag.BagStatusHistoryEntry;
//import ru.sbrf.ascc.bag.BagStatusHistoryEntryRSExtractor;
//import ru.sbrf.ascc.bag.PersonGroupService;
//import ru.sbrf.ascc.bag.exchange.ExchangeBagManager;
//import ru.sbrf.ascc.bag.mis.ReceivedInventoryDataService;
//import ru.sbrf.ascc.bag.recalc.BagRecalcResultConverter;
//import ru.sbrf.ascc.bag.recalc.RecalcBagManager;
//import ru.sbrf.ascc.bag.recalc.dao.RecalcBagDAO;
//import ru.sbrf.ascc.bag.recalc.dto.BagRecalcFactDTO;
//import ru.sbrf.ascc.bag.recalc.service.BagRecalcService;
//import ru.sbrf.ascc.cardindex.service.CardIndexService;
//import ru.sbrf.ascc.clients.core.AccountProperties;
//import ru.sbrf.ascc.clients.core.Agreement;
//import ru.sbrf.ascc.clients.core.AgreementBankDetails;
//import ru.sbrf.ascc.clients.core.ClientAgreementsService;
//import ru.sbrf.ascc.clients.core.StorageRoom;
//import ru.sbrf.ascc.clients.dto.AccountPropertiesDTO;
//import ru.sbrf.ascc.common.service.operday.OperdayService;
//import ru.sbrf.ascc.doc.core.DocumentManager;
//import ru.sbrf.ascc.kladovka.service.ShiftService;
//import ru.sbrf.ascc.references.account.BankDetails;
//import ru.sbrf.ascc.references.client.AgreementOperation;
//import ru.sbrf.ascc.references.client.ClientServiceScheduleType;
//import ru.sbrf.ascc.references.inkassationobject.InkassationObjectService;
//import ru.sbrf.ascc.references.inkassationobjects.entity.InkassationObject;
//import ru.sbrf.ascc.references.inkassationobjects.entity.InkassationObjectShort;
//import ru.sbrf.ascc.references.inkassationobjects.entity.InkassationObjectType;
//import ru.sbrf.ascc.references.spc.SpcCashCenterService;
//import ru.sbrf.ascc.request.RequestByBagOutStatusService;
//import ru.sbrf.ascc.request.RequestService;
//import ru.sbrf.asccgroupcore.config.service.ConfigService;
//import ru.sbrf.auth.service.SessionDataService;
//import ru.sbrf.gamma.storage.dto.Employee;
//import ru.sbrf.gamma.storage.ejb.facade.accept.exchange.AcceptReceivedExchangeBagDTO;
//import ru.sbt.ascc.utils.accounting.OperDay;
//import ru.sbt.ascc.utils.spring.ServiceClientFactory;
//import ru.sbt.userservice.service.UserService;
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//
//@ContextConfiguration(classes = MPRFIDExchangeServiceTest.Config.class)
//public class MPRFIDExchangeServiceTest extends AbstractTestNGSpringContextTests {
//
//    private static final long USER_ID = 78;
//    private static final String CC_CODE = "16010";
//    private static final String SHIFT_CODE = "16010";
//
//    @Autowired
//    private ExchangeBagManager exchangeBagManager;
//
//    @Autowired
//    private InkassationObjectService inkassationObjectService;
//
//    @Autowired
//    private ClientAgreementsService clientAgreementsService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private BagNumbersRepository bagNumbersRepository;
//
//    @Autowired
//    private ShiftService shiftService;
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    /**
//     * До теста: инкассатор сдал сумку через маис, бухгалтерские документы сформированы
//     * Тест: касса принимает сумку через клиент "Приём наличности по размену" -> "принять сумку",
//     * бухгалтерские документы не долны быть изменены
//     */
//    @Test
//    public void testRFIDacceptReceivedExchangeBag() {
//
//        final String ROUTE_NUMBER = "003-1";
//        final String ROUTE_DATE = "31.05.2019";
//        final long COLLECTOR_ID = 78;
//        final String BAG_NUMBERS_STRING = "1212454, 20011000, 20011001032, 20011001033, 20011001034, " +
//                                  "200110010343, 200110010344, 200110010346, 200110010347";
//        final long BAG_ID = 5872432;
//        final String CLIENT_CODE = "9016117688679110100232";
//        final String OPER_DAY = "31.05.2019";
//
//        new ServiceClientFactory().setApplicationContext(applicationContext);
//
//        final InkassationObject inkassationObject = new InkassationObject(CLIENT_CODE,
//                InkassationObjectType.INKASS_CLIENT, "Тестовый КИ свой"
//        );
//        inkassationObject.setOrgFullName("orgFullName");
//        inkassationObject.setOrgInn("INN");
//        EasyMock.expect(inkassationObjectService.loadByINK(CLIENT_CODE)).andReturn(inkassationObject).anyTimes();
//
//        final InkassationObjectShort inkassationObjectShort = new InkassationObjectShort(
//                1,
//                CLIENT_CODE,
//                InkassationObjectType.INKASS_CLIENT,
//                "Тестовый КИ свой",
//                "Адресс"
//        );
//        EasyMock.expect(inkassationObjectService.loadByINKShort(CLIENT_CODE)).andReturn(inkassationObjectShort).anyTimes();
//
//        final Agreement agreement = new Agreement(65312, "90/01", "1690161230714846649", new Date(),
//                null, CLIENT_CODE, 6, AgreementOperation.EXCHANGE_OPERATION, "125957", 0,
//                "Акционерное общество \"Газпромнефть-Урал\"", ClientServiceScheduleType.BY_REQUEST, "gosbCode"
//        );
//        agreement.setAgreementBankDetails(Collections.singletonList(new AgreementBankDetails(
//                new BankDetails("046577674", "40702810216020100344"),
//                new AccountProperties(new AccountPropertiesDTO())
//        )));
//
//        EasyMock.expect(clientAgreementsService.getActiveAgreement(
//                CLIENT_CODE,
//                AgreementOperation.EXCHANGE_OPERATION,
//                OperDay.parse(OPER_DAY).toDate()
//        )).andReturn(agreement).anyTimes();
//
//        final StorageRoom storageRoom = new StorageRoom(1);
//        storageRoom.setCashCenterCode(SHIFT_CODE);
//        EasyMock.expect(shiftService.loadStorageRoom(SHIFT_CODE)).andReturn(storageRoom);
//
//        EasyMock.expect(userService.findByID(COLLECTOR_ID)).andReturn(new Employee()).anyTimes();
//
//        final List<String> bagNumbersList = new ArrayList<>();
//        bagNumbersList.add("1212454");
//        bagNumbersList.add("20011000");
//        bagNumbersList.add("20011001032");
//        bagNumbersList.add("20011001033");
//        bagNumbersList.add("20011001034");
//        bagNumbersList.add("200110010343");
//        bagNumbersList.add("200110010344");
//        bagNumbersList.add("200110010346");
//        bagNumbersList.add("200110010347");
//
//        EasyMock.expect(bagNumbersRepository.findNumbersByInventoryId(BAG_ID)).andReturn(bagNumbersList).anyTimes();
//
//        EasyMock.replay(
//                inkassationObjectService,
//                clientAgreementsService,
//                userService,
//                shiftService,
//                bagNumbersRepository
//        );
//
//        final AcceptReceivedExchangeBagDTO acceptReceivedExchangeBagDTO = new AcceptReceivedExchangeBagDTO();
//        acceptReceivedExchangeBagDTO.setRoute(ROUTE_NUMBER);
//        acceptReceivedExchangeBagDTO.setRouteDate(ROUTE_DATE);
//        acceptReceivedExchangeBagDTO.setRecalcFactDTO(new BagRecalcFactDTO());
//        acceptReceivedExchangeBagDTO.setCollectorId(COLLECTOR_ID);
//        acceptReceivedExchangeBagDTO.setReceivedBagId(BAG_ID);
//        acceptReceivedExchangeBagDTO.setBagNumber(BAG_NUMBERS_STRING);
//        exchangeBagManager.acceptReceivedExchangeBag(
//                acceptReceivedExchangeBagDTO,
//                USER_ID,
//                CC_CODE,
//                OperDay.parse(OPER_DAY),
//                SHIFT_CODE,
//                true
//        );
//
//        final NamedParameterJdbcTemplate jdbcTemplate = new  NamedParameterJdbcTemplate(dataSource);
//
//        final LinkedList<BagAccStatusHistoryEntry> bagAccStatusHistoryList = jdbcTemplate.query(
//                "SELECT * FROM STG_BAG_ACC_STATUS_HISTORY WHERE BAG_ID = :bag_id",
//                ImmutableMap.of("bag_id", BAG_ID),
//                new BagAccStatusHistoryEntryRSExtractor()
//        );
//
//        // количество и история статусов бухгалтерских документов не изменилась
//        Assert.assertEquals(bagAccStatusHistoryList.size(), 3);
//        final BagAccStatusHistoryEntry statusHistoryEntry_0 = bagAccStatusHistoryList.get(0);
//        Assert.assertEquals(statusHistoryEntry_0.getAccStatus(), BagAccStatus.RECEIVED);
//        Assert.assertEquals(statusHistoryEntry_0.getID(), 41802);
//
//        final BagAccStatusHistoryEntry statusHistoryEntry_1 = bagAccStatusHistoryList.get(1);
//        Assert.assertEquals(statusHistoryEntry_1.getAccStatus(), BagAccStatus.ARRIVED);
//        Assert.assertEquals(statusHistoryEntry_1.getID(), 43102);
//
//        final BagAccStatusHistoryEntry statusHistoryEntry_2 = bagAccStatusHistoryList.get(2);
//        Assert.assertEquals(statusHistoryEntry_2.getAccStatus(), BagAccStatus.DOC_CREATED);
//        Assert.assertEquals(statusHistoryEntry_2.getID(), 43103);
//
//
//        // проверяем статус сумки , сумка должна быть принята BagStatus.ACCEPTED
//        final LinkedList<BagStatusHistoryEntry> bagStatusHistoryList = jdbcTemplate.query(
//                "SELECT * FROM STG_BAG_STATUS_HISTORY WHERE BAG_ID = :bag_id",
//                ImmutableMap.of("bag_id",BAG_ID),
//                new BagStatusHistoryEntryRSExtractor()
//        );
//
//        Assert.assertEquals(bagStatusHistoryList.size(), 3) ;
//        final BagStatusHistoryEntry bagStatusHistoryAccepted = bagStatusHistoryList.get(2);
//        Assert.assertEquals(bagStatusHistoryAccepted.getStatus(), BagStatus.ACCEPTED);
//
//    }
//
//
//    @Configuration
//    @ComponentScan(basePackageClasses = {ExchangeBagManager.class, BagManager.class, BagDAO.class}, lazyInit = true,
//            excludeFilters = {
//                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = PersonGroupService.class),
//                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RecalcBagDAO.class),
//                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RecalcBagManager.class),
//                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BagRecalcService.class),
//            })
//    static class Config {
//
//        @Bean
//        @Primary
//        BagSplitService bagSplitService() {
//            return EasyMock.createNiceMock(BagSplitService.class);
//        }
//
//        @Bean
//        @Primary
//        BagAuditService bagAuditService() { return EasyMock.createNiceMock(BagAuditService.class);}
//
//        @Bean
//        @Primary
//        ConfigService configService() {
//            return EasyMock.createNiceMock(ConfigService.class);
//        }
//
//        @Bean
//        @Primary
//        PersonGroupService personGroupService() {
//            return EasyMock.createNiceMock(PersonGroupService.class);
//        }
//
//        @Bean
//        @Primary
//        CardIndexService cardIndexService() {
//            return EasyMock.createNiceMock(CardIndexService.class);
//        }
//
//        @Bean
//        @Primary
//        OperdayService operdayService() {
//            return EasyMock.createNiceMock(OperdayService.class);
//        }
//
//        @Bean
//        @Primary
//        DocumentManager documentManager() {
//            return EasyMock.createNiceMock(DocumentManager.class);
//        }
//
//        @Bean
//        @Primary
//        ShiftService shiftService() {
//            return EasyMock.createNiceMock(ShiftService.class);
//        }
//
//        @Bean
//        @Primary
//        ClientAgreementsService clientAgreementsService() {
//            return EasyMock.createNiceMock(ClientAgreementsService.class);
//        }
//
//        @Bean
//        @Primary
//        InkassationObjectService inkassationObjectService() {
//            return EasyMock.createNiceMock(InkassationObjectService.class);
//        }
//
//        @Bean
//        @Primary
//        BagRecalcService bagRecalcService() {
//            return EasyMock.createNiceMock(BagRecalcService.class);
//        }
//
//        @Bean
//        @Primary
//        RequestService requestService() {
//            return EasyMock.createNiceMock(RequestService.class);
//        }
//
//        @Bean
//        @Primary
//        SessionDataService sessionDataService() {
//            return EasyMock.createNiceMock(SessionDataService.class);
//        }
//
//        @Bean
//        @Primary
//        BagRecalcResultConverter bagRecalcResultConverter() {
//            return EasyMock.createNiceMock(BagRecalcResultConverter.class);
//        }
//
//        @Bean
//        @Primary
//        RequestByBagOutStatusService requestByBagOutStatusService() {
//            return EasyMock.createNiceMock(RequestByBagOutStatusService.class);
//        }
//
//        @Bean
//        @Primary
//        AuditHelperService auditHelperService() {
//            return EasyMock.createNiceMock(AuditHelperService.class);
//        }
//
//        @Bean
//        @Primary
//        ReceivedInventoryDataService receivedInventoryDataService() {
//            return EasyMock.createNiceMock(ReceivedInventoryDataService.class);
//        }
//
//        @Bean
//        @Primary
//        BagNumbersRepository bagNumbersRepository() {
//            return EasyMock.createNiceMock(BagNumbersRepository.class);
//        }
//
//        @Bean(name = "appDS")
//        @Primary
//        DataSource dataSource() {
//            final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//            return builder.setType(EmbeddedDatabaseType.HSQL)
//                          .addScripts(DefaultScripts.DB_INITIALIZE_SCRIPTS)
//                          .addScripts(DefaultScripts.DB_CONSTANT_DATA_SCRIPTS)
//                          .addScript("Data/MPRFIDExchangeServiceTest.sql")
//                          .build();
//        }
//
//        @Bean
//        @Primary
//        SpcCashCenterService spcCashCenterService() {
//            return EasyMock.createNiceMock(SpcCashCenterService.class);
//        }
//
//        @Bean
//        @Primary
//        UserService userService() {
//            return EasyMock.createNiceMock(UserService.class);
//        }
//    }
//}
