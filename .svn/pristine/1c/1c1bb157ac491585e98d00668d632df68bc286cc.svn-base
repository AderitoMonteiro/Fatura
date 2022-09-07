package com.ucc2.jasper;

import java.io.FileOutputStream;
import java.io.OutputStream;
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
import com.ucc2.master.Header;
import com.ucc2.master.Header2;


public class testeListaFaturaGerarPdf {

	public static byte[] GerarPdfListaFatura(List<Header2> faturas){
		
		byte[] output = null;
				
		try {
			
			
			
			String Blank_A4_jrxml =        "C:\\AS_HOME\\eclipse\\AS_Workspace\\Fatura\\Blank_A4.jrxml";
			String Blank_A4_jasper =       "C:\\AS_HOME\\eclipse\\AS_Workspace\\Fatura\\Blank_A4.jasper";
			String caminhoReport_pdf =     "C:\\AS_HOME\\eclipse\\AS_Workspace\\Fatura\\";
			String CompanyReport_jrprint = "C:\\AS_HOME\\eclipse\\AS_Workspace\\Fatura\\Blank_A4.jrprint";	

			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateNow = formatter.format(new Date());
			Random rand =  new Random();
			String dataRand = dateNow+rand.nextInt(1000);
			
			caminhoReport_pdf = caminhoReport_pdf + "relatorioCliente_"+dataRand+".pdf";
			

			// compile sub report BodyDetalhado
			JasperCompileManager.compileReportToFile(Blank_A4_jrxml, Blank_A4_jasper);
		
			JasperReport subreport = (JasperReport)JRLoader.loadObjectFromFile(Blank_A4_jasper);
			
			//Preparing parameters
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Blank_A4", subreport);
						
			// compile master report
			JasperCompileManager.compileReportToFile(Blank_A4_jrxml, Blank_A4_jasper);
			System.out.println("mmmm");
			// fill the report
			JasperFillManager.fillReportToFile(Blank_A4_jasper, parameters, new JRBeanCollectionDataSource(faturas));
			System.out.println("mmmm888888");
			// export to pdf
			JasperExportManager.exportReportToPdfFile(CompanyReport_jrprint, caminhoReport_pdf);
			System.out.println("mmmm8888889");

			JasperPrint jasperPrint = JasperFillManager.fillReport(Blank_A4_jasper, parameters, new JRBeanCollectionDataSource(faturas));
			output = JasperExportManager.exportReportToPdf(jasperPrint); 
	
			System.out.println("mmmm10000 "+output.toString());
					
	//		File sourceFile = new File(CompanyReport_jrprint);
//			System.out.println("mmmm100001 "+output.toString());
			//JasperPrint jasperPrint2 = (JasperPrint)JRLoader.loadObject(sourceFile);
			
			OutputStream out;
			try {
				out = new FileOutputStream(caminhoReport_pdf);
				out.write(output);
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (JRException e) {
			System.err.println(e);
		}
		
		
		return output;	
		
	}
	

}
