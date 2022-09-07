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

import com.model.devolucao.Devolucao;
import com.oferta.Oferta;
public class ListaOfertaGerarPdf {

	
	
	
	public  byte[] GerarPdfListaOferta(List<Oferta> faturaRecibo){
		
		byte[] output = null;
		
		try {

	

		String FaturaReciboSubReport_jrxml = "C:\\Jasper\\Oferta\\OfertaContainerSubReport.jrxml";
		String FaturaReciboSubReport_jasper = "C:\\Jasper\\Oferta\\OfertaContainerSubReport.jasper";			
		String FaturaReciboReport_jrxml = "C:\\Jasper\\Oferta\\Oferta.jrxml";
		String FaturaReciboReport_jasper = "C:\\Jasper\\Oferta\\Oferta.jasper";		
		String FaturaReciboReport_jrprint = "C:\\Jasper\\Oferta\\Oferta.jrprint";			
		String caminhoReport_pdf = "C:\\Jasper\\Oferta\\pdf\\";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "oferta_"+dataRand+".pdf";


	
		
		// compile sub report bodyResumo
		JasperCompileManager.compileReportToFile(FaturaReciboSubReport_jrxml, FaturaReciboSubReport_jasper);

		//
		JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(FaturaReciboSubReport_jasper);

		//Preparing parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("OfertaContainerSubReport", subreport);
					
		// compile master report
		JasperCompileManager.compileReportToFile(FaturaReciboReport_jrxml, FaturaReciboReport_jasper);

		// fill the report
		JasperFillManager.fillReportToFile(FaturaReciboReport_jasper, parameters, new JRBeanCollectionDataSource(faturaRecibo));

		// export to pdf
		JasperExportManager.exportReportToPdfFile(FaturaReciboReport_jrprint, caminhoReport_pdf);

		JasperPrint jasperPrint = JasperFillManager.fillReport(FaturaReciboReport_jasper, parameters, new JRBeanCollectionDataSource(faturaRecibo));
		output = JasperExportManager.exportReportToPdf(jasperPrint); 

		
	} catch (Exception e) {//JRException
		e.printStackTrace();
		System.out.println("erro session: "+faturaRecibo.get(0).getNumeroCliente());

	}
		
		return output;
	}
	
}
