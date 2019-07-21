package core.annotations;

@Service(name = "MyLazyService")
public class LazyService {

    @Init
    public void initService() {
        System.out.println("initService");
    }
}
