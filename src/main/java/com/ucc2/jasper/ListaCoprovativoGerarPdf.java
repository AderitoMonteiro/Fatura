package com.ucc2.jasper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.model.comprovativo.Comprovativo;


public class ListaCoprovativoGerarPdf {

	
	public  byte[] GerarPdfListaConprovativo(ArrayList<Comprovativo> comprovativo){
		
		byte[] output = null;
		
		try {

	

		String ComprovativoContainerSubReport_jrxml = "C:\\Jasper\\Comprovativo\\ComprovativoContainerSubReport.jrxml";
		String ComprovativoContainerSubReport_jasper = "C:\\Jasper\\Comprovativo\\ComprovativoContainerSubReport.jasper";			
		String ComprovativoReport_jrxml = "C:\\Jasper\\Comprovativo\\Comprovativo.jrxml";
		String ComprovativoReport_jasper = "C:\\Jasper\\Comprovativo\\Comprovativo.jasper";		
		String ComprovativoReport_jrprint = "C:\\Jasper\\Comprovativo\\Comprovativo.jrprint";			
		String caminhoReport_pdf = "C:\\Jasper\\Comprovativo\\pdf\\";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand+".pdf";


	
		
		// compile sub report bodyResumo
		JasperCompileManager.compileReportToFile(ComprovativoContainerSubReport_jrxml, ComprovativoContainerSubReport_jasper);

		//
		JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(ComprovativoContainerSubReport_jasper);

		//Preparing parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ComprovativoContainerSubReport", subreport);
					
		// compile master report
		JasperCompileManager.compileReportToFile(ComprovativoReport_jrxml, ComprovativoReport_jasper);

		// fill the report
		JasperFillManager.fillReportToFile(ComprovativoReport_jasper, parameters, new JRBeanCollectionDataSource(comprovativo));

		// export to pdf
		JasperExportManager.exportReportToPdfFile(ComprovativoReport_jrprint, caminhoReport_pdf);

		JasperPrint jasperPrint = JasperFillManager.fillReport(ComprovativoReport_jasper, parameters, new JRBeanCollectionDataSource(comprovativo));
		output = JasperExportManager.exportReportToPdf(jasperPrint); 

		
	} catch (Exception e) {//JRException
		e.printStackTrace();
		System.out.println("erro session: "+comprovativo.get(0).getNumeroCliente());

	}
		
		return output;
		
	}
}
