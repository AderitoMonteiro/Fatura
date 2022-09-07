package com.ucc2.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import com.model.faturacredito.FaturaCredito;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;



public class ListaFaturaCreditoGerarPdf {

	

	public  byte[] GerarPdfListaFaturaCredito(List<FaturaCredito> faturaCredito){
		
		byte[] output = null;
		
		try {

			

		String FaturaCreditoSubReport_jrxml = "C:\\Jasper\\FaturaCredito\\FaturaCreditoContainerSubReport.jrxml";
		String FaturaCreditoSubReport_jasper = "C:\\Jasper\\FaturaCredito\\FaturaCreditoContainerSubReport.jasper";			
		String FaturaCreditoReport_jrxml = "C:\\Jasper\\FaturaCredito\\FaturaCredito.jrxml";
		String FaturaCreditoReport_jasper = "C:\\Jasper\\FaturaCredito\\FaturaCredito.jasper";		
		String FaturaCreditoReport_jrprint = "C:\\Jasper\\FaturaCredito\\FaturaCredito.jrprint";			
		String caminhoReport_pdf = "C:\\Jasper\\FaturaCredito\\pdf\\";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "faturacredito_"+dataRand+".pdf";

		// compile sub report bodyResumo
		JasperCompileManager.compileReportToFile(FaturaCreditoSubReport_jrxml, FaturaCreditoSubReport_jasper);

		//
		JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(FaturaCreditoSubReport_jasper);

		//Preparing parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FaturaCreditoContainerSubReport", subreport);
					
		// compile master report
		JasperCompileManager.compileReportToFile(FaturaCreditoReport_jrxml, FaturaCreditoReport_jasper);

		// fill the report
		JasperFillManager.fillReportToFile(FaturaCreditoReport_jasper, parameters, new JRBeanCollectionDataSource(faturaCredito));

		// export to pdf
		JasperExportManager.exportReportToPdfFile(FaturaCreditoReport_jrprint, caminhoReport_pdf);

		JasperPrint jasperPrint = JasperFillManager.fillReport(FaturaCreditoReport_jasper, parameters, new JRBeanCollectionDataSource(faturaCredito));
		output = JasperExportManager.exportReportToPdf(jasperPrint); 

		
	} catch (Exception e) {//JRException
		e.printStackTrace();
		System.out.println("erro session: "+faturaCredito.get(0).getNumeroCliente());

	}
		
		return output;
	}
}
