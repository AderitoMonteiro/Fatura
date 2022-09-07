package com.ucc2.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.model.faturarecibo.FaturaRecibo;

public class ListaReportFaturaPdf {
	
	public byte[]  faturadesconto(List<FaturaRecibo> faturaCredito){
		byte[] output = null;
		
		String ReportFaturaSubReport_jrxml = "C:\\Jasper\\FaturaRecibo\\ReportFaturaContainerSubReport.jrxml";
		String ReportFaturaSubReport_jasper = "C:\\Jasper\\FaturaRecibo\\ReportFaturaContainerSubReport.jasper";
		String ReportFaturaContainerSubReport = "C:\\Jasper\\FaturaRecibo\\ReportFaturaContainerSubReport.jrprint";	
		String caminhoReport_pdf = "C:\\Jasper\\FaturaRecibo\\pdf\\";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand1 = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand1+".pdf";
		
		JasperReport subreport;
		JasperPrint jasperPrint; 
		Map<String, Object> parameters;
		
	try {

			JasperCompileManager.compileReportToFile(ReportFaturaSubReport_jrxml, ReportFaturaSubReport_jasper);
			subreport = (JasperReport)JRLoader.loadObjectFromFile(ReportFaturaSubReport_jasper);
			parameters= new HashMap<String, Object>();
			parameters.put("FaturaReciboContainerSubReport", subreport);
			JasperFillManager.fillReportToFile(ReportFaturaSubReport_jasper, parameters, new JRBeanCollectionDataSource(faturaCredito));
			JasperExportManager.exportReportToPdfFile(ReportFaturaContainerSubReport, caminhoReport_pdf);
			jasperPrint = JasperFillManager.fillReport(ReportFaturaSubReport_jasper, parameters, new JRBeanCollectionDataSource(faturaCredito));
			JasperExportManager.exportReportToPdf(jasperPrint);  
		
		 } catch (Exception e) {//JRException
			e.printStackTrace();
			System.out.println("erro session: "+faturaCredito.get(0).getNumeroCliente());

		}
	
	return output;
	}

}
