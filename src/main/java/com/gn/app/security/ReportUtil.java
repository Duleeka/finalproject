package com.gn.app.security;

import com.gn.app.dto.BaseReportDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 3/12/2019.
 */
public class ReportUtil {

    private static ReportUtil instance = null;

    private ReportUtil() {
    }

    public static ReportUtil getInstance() {
        if (instance == null) {
            instance = new ReportUtil();
        }
        return instance;
    }

    public void generatePDF(List<? extends BaseReportDTO> dtoList, String reportDir, Map<String, Object> params, String inputFilePath, OutputStream outputStream) {
        try {
            params.put("SUBREPORT_DIR", reportDir);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dtoList);
            InputStream jasperStream = new FileInputStream(reportDir.concat(inputFilePath).concat(".jrxml"));
            JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrDataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generateCSV(List<? extends BaseReportDTO> dtoList, String reportDir, Map<String, Object> params, String inputFilePath, OutputStream outputStream) {
        try {
            params.put("SUBREPORT_DIR", reportDir);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(dtoList);
            InputStream jasperStream = new FileInputStream(reportDir.concat(inputFilePath).concat(".jrxml"));
            JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, jrDataSource);

            ExporterInput input = new SimpleExporterInput(jasperPrint);
            SimpleWriterExporterOutput output = new SimpleWriterExporterOutput(outputStream);

            JRCsvExporter cvsExporter = new JRCsvExporter();
            cvsExporter.setExporterInput(input);
            cvsExporter.setExporterOutput(output);
            cvsExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generatePDF(JRDataSource dataSource, InputStream jasperStream, Map<String, Object> params, OutputStream outputStream) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generateCSV(JRDataSource dataSource, InputStream jsInputStream, Map<String, Object> params, OutputStream outputStream) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(jsInputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            exportCSV(outputStream, jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportCSV(OutputStream outputStream, JasperPrint jasperPrint) throws JRException {
        ExporterInput input = new SimpleExporterInput(jasperPrint);
        SimpleWriterExporterOutput output = new SimpleWriterExporterOutput(outputStream);

        JRCsvExporter cvsExporter = new JRCsvExporter();
        cvsExporter.setExporterInput(input);
        cvsExporter.setExporterOutput(output);
        cvsExporter.exportReport();
    }
}
