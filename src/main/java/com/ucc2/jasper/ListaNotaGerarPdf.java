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

import com.model.nota.Nota;


public class ListaNotaGerarPdf {

	
	
	public  byte[] GerarPdfListaNota(List<Nota> notas){
	
		byte[] output = null;
		
		try {

	

		String NotaSubReport_jrxml = "C:\\Jasper\\Nota\\NotaContainerSubReport.jrxml";
		String NotaSubReport_jasper = "C:\\Jasper\\Nota\\NotaContainerSubReport.jasper";			
		String NotaReport_jrxml = "C:\\Jasper\\Nota\\Nota.jrxml";
		String NotaReport_jasper = "C:\\Jasper\\Nota\\Nota.jasper";		
		String NotaReport_jrprint = "C:\\Jasper\\Nota\\Nota.jrprint";			
		String caminhoReport_pdf = "C:\\Jasper\\Nota\\pdf\\";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand+".pdf";


	
		
		// compile sub report bodyResumo
		JasperCompileManager.compileReportToFile(NotaSubReport_jrxml, NotaSubReport_jasper);

		//
		JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(NotaSubReport_jasper);

		//Preparing parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("NotaContainerSubReport", subreport);
					
		// compile master report
		JasperCompileManager.compileReportToFile(NotaReport_jrxml, NotaReport_jasper);

		// fill the report
		JasperFillManager.fillReportToFile(NotaReport_jasper, parameters, new JRBeanCollectionDataSource(notas));

		// export to pdf
		JasperExportManager.exportReportToPdfFile(NotaReport_jrprint, caminhoReport_pdf);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(NotaReport_jasper, parameters, new JRBeanCollectionDataSource(notas));
		output = JasperExportManager.exportReportToPdf(jasperPrint); 

		
	} catch (Exception e) {//JRException
		e.printStackTrace();
		System.out.println("erro session: "+notas.get(0).getNumeroCliente());

	}
		
		return output;
	}
	
	
}
