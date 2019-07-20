package libs.jasperReports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * – $R = locale specific resource
 * – $P = report parameter, Parameters represent named object references that are passed-in to the report engine before the execution of the report.
 * – $V = report variable, some are build-in variables
 * – $F = database record field (column)
 */
public class Main {

    public static void main(String[] args) throws JRException, FileNotFoundException {
        InputStream inputStream = new FileInputStream("JavaCore\\src\\main\\resources\\Blank_A4.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("REPORT_CONTEXT", "Employee Report");
        parameters.put("LAST_NAME", "Employee Report");
        parameters.put("SALARY", "15000.0");
        //parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);

        // создание отчета
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("baeldung");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

        System.out.println("REPORT DONE");

    }
}
