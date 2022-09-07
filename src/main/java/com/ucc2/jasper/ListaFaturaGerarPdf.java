package com.ucc2.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.model.fatura.fatura;


public class ListaFaturaGerarPdf {

	
	
	public ListaFaturaGerarPdf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String GerarPdfListaFatura1(){
		System.out.println("MMerdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return "MMerdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	}
	
	
	public  byte[] GerarPdfListaFatura(List<fatura> faturas){
	System.out.println("INICIO GerarPdfListaFatura");
		byte[] output = null;
//				
		try {
			
			String BodyDescritivoSubReport_jrxml = "C:\\Jasper\\Fatura\\BodyDescritivoSubReport.jrxml";
			String BodyDescritivoSubReport_jasper = "C:\\Jasper\\Fatura\\BodyDescritivoSubReport.jasper";	
			
			String BodyDetalhadoSubReport_jrxml = "C:\\Jasper\\Fatura\\BodyDetalhadoSubReport.jrxml";
			String BodyDetalhadoSubReport_jasper = "C:\\Jasper\\Fatura\\BodyDetalhadoSubReport.jasper";	
			
			
			String PersonSubReport_jrxml = "C:\\Jasper\\Fatura\\bodyResumoSubReport.jrxml";
			String PersonSubReport_jasper = "C:\\Jasper\\Fatura\\bodyResumoSubReport.jasper";			
			String CompanyReport_jrxml = "C:\\Jasper\\Fatura\\fatura.jrxml";
			String CompanyReport_jasper = "C:\\Jasper\\Fatura\\fatura.jasper";		
			String CompanyReport_jrprint = "C:\\Jasper\\Fatura\\faturaReport.jrprint";			
			String caminhoReport_pdf = "C:\\Jasper\\Fatura\\";
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateNow = formatter.format(new Date());
			Random rand =  new Random();
			String dataRand = dateNow+rand.nextInt(1000);
			
			caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand+".pdf";

			// compile sub report BodyDetalhado
			JasperCompileManager.compileReportToFile(BodyDetalhadoSubReport_jrxml, BodyDescritivoSubReport_jasper);
	
			JasperReport subreport3 = (JasperReport)JRLoader.loadObjectFromFile(BodyDetalhadoSubReport_jasper);

			// compile sub report BodyDescritivo
			JasperCompileManager.compileReportToFile(BodyDescritivoSubReport_jrxml, BodyDescritivoSubReport_jasper);
			JasperReport subreport2 = (JasperReport)JRLoader.loadObjectFromFile(BodyDescritivoSubReport_jasper);
			
			// compile sub report bodyResumo
			JasperCompileManager.compileReportToFile(PersonSubReport_jrxml, PersonSubReport_jasper);

			//
			JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(PersonSubReport_jasper);

			//Preparing parameters
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("bodyResumoSubReport", subreport);
			parameters.put("bodyDescritivoSubReport", subreport2);
			parameters.put("bodyDetalhadoSubReport", subreport3);
						
			// compile master report
			JasperCompileManager.compileReportToFile(CompanyReport_jrxml, CompanyReport_jasper);
		//	System.out.println("mmmm");
			// fill the report
			JasperFillManager.fillReportToFile(CompanyReport_jasper, parameters, new JRBeanCollectionDataSource(faturas));
		//	System.out.println("mmmm888888");
			// export to pdf
			JasperExportManager.exportReportToPdfFile(CompanyReport_jrprint, caminhoReport_pdf);
		//	System.out.println("mmmm8888889");

			JasperPrint jasperPrint = JasperFillManager.fillReport(CompanyReport_jasper, parameters, new JRBeanCollectionDataSource(faturas));
			output = JasperExportManager.exportReportToPdf(jasperPrint); 
		//	System.out.println("FIM GerarPdfListaFatura");
			
		} catch (Exception e) {//JRException
			e.printStackTrace();
			System.out.println("erro session: "+faturas.get(0).getNumCliente());
			//System.err.println(e);
		}
//		
//		finally{
//			System.err.println("###  finally");
//		}
//		
		return output;	

	}
	

}
