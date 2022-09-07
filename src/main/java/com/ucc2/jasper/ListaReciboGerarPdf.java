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

import com.model.recibo.Recibo;



public class ListaReciboGerarPdf {

	
	
	public  byte[] GerarPdfListaRecibo(List<Recibo> recibos){
	
		byte[] output = null;
		
		try {
//		String BodyDescritivoSubReport_jrxml = "C:\\Jasper\\Fatura\\BodyDescritivoSubReport.jrxml";
//		String BodyDescritivoSubReport_jasper = "C:\\Jasper\\Fatura\\BodyDescritivoSubReport.jasper";	
//		
//		String MeiosPagamentoSubReport_jrxml = "C:\\Jasper\\Recibo\\MeiosPagamento.jrxml";
//		String MeiosPagamentoSubReport_jasper = "C:\\Jasper\\Recibo\\MeiosPagamento.jasper";	
		
		String MeiosPagamentoSubReport_jrxml = "C:\\Jasper\\Recibo\\MeiosPagamentoSubReport.jrxml";
		String MeiosPagamentoSubReport_jasper = "C:\\Jasper\\Recibo\\MeiosPagamentoSubReport.jasper";
		
		String ReciboSubReport_jrxml = "C:\\Jasper\\Recibo\\ReciboContainerSubReport.jrxml";
		String ReciboSubReport_jasper = "C:\\Jasper\\Recibo\\ReciboContainerSubReport.jasper";			
		String reciboReport_jrxml = "C:\\Jasper\\Recibo\\Recibo.jrxml";
		String reciboReport_jasper = "C:\\Jasper\\Recibo\\Recibo.jasper";		
		String reciboReport_jrprint = "C:\\Jasper\\Recibo\\Recibo.jrprint";			
		String caminhoReport_pdf = "C:\\Jasper\\Recibo\\pdf\\";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = formatter.format(new Date());
		Random rand =  new Random();
		String dataRand = dateNow+rand.nextInt(1000);
		
		caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand+".pdf";

			// compile sub report BodyDetalhado
//			JasperCompileManager.compileReportToFile(BodyDetalhadoSubReport_jrxml, BodyDescritivoSubReport_jasper);
//
//		JasperReport subreport3 = (JasperReport)JRLoader.loadObjectFromFile(BodyDetalhadoSubReport_jasper);

		// compile sub report MeiosPagamento
		JasperCompileManager.compileReportToFile(MeiosPagamentoSubReport_jrxml, MeiosPagamentoSubReport_jasper);
		JasperReport subreport2 = (JasperReport)JRLoader.loadObjectFromFile(MeiosPagamentoSubReport_jasper);
		
		// compile sub report bodyResumo
		JasperCompileManager.compileReportToFile(ReciboSubReport_jrxml, ReciboSubReport_jasper);

		//
		JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(ReciboSubReport_jasper);

		//Preparing parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReciboContainerSubReport", subreport);
		parameters.put("MeiosPagamentoSubReport", subreport2);
//		parameters.put("bodyDetalhadoSubReport", subreport3);
					
		// compile master report
		JasperCompileManager.compileReportToFile(reciboReport_jrxml, reciboReport_jasper);

		// fill the report
		JasperFillManager.fillReportToFile(reciboReport_jasper, parameters, new JRBeanCollectionDataSource(recibos));

		// export to pdf
		JasperExportManager.exportReportToPdfFile(reciboReport_jrprint, caminhoReport_pdf);

		JasperPrint jasperPrint = JasperFillManager.fillReport(reciboReport_jasper, parameters, new JRBeanCollectionDataSource(recibos));
		output = JasperExportManager.exportReportToPdf(jasperPrint); 

		
	} catch (Exception e) {//JRException
		e.printStackTrace();
		System.out.println("erro session: "+recibos.get(0).getNumeroCliente());

	}
		
		return output;
	}
}
