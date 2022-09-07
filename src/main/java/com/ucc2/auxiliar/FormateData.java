package com.ucc2.auxiliar;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormateData {
	
	public static String GetDescMes(String data){
		
		String dia="";
		String mes="";
		String ano="";
		//2018-04-01
		ano=data.substring(0, 4);
		mes=data.substring(5, 7);
		dia=data.substring(8, 10);
		
		if(mes.equals("01")){
			mes="Janeiro";
		}if(mes.equals("02")){
			mes="Fevereiro";
		}if(mes.equals("03")){
			mes="Março";
		}if(mes.equals("04")){
			mes="Abril";
		}if(mes.equals("05")){
			mes="Maio";
		}if(mes.equals("06")){
			mes="Junho";
		}if(mes.equals("07")){
			mes="Julho";
		}if(mes.equals("08")){
			mes="Agosto";
		}if(mes.equals("09")){
			mes="Setembro";
		}if(mes.equals("10")){
			mes="Outubro";
		}if(mes.equals("11")){
			mes="Novembro";
		}if(mes.equals("12")){
			mes="Dezembro";
		}
		
		return dia+" de "+mes +" de "+ano;
	}
	
	public static String GetPeriodoFaturacao(String data){
		
		String mes="";
		String ano="";
		//2018-04-01
		ano=data.substring(0, 4);
		mes=data.substring(4, 6);
		
		if(mes.equals("01")){
			mes="Janeiro";
		}if(mes.equals("02")){
			mes="Fevereiro";
		}if(mes.equals("03")){
			mes="Março";
		}if(mes.equals("04")){
			mes="Abril";
		}if(mes.equals("05")){
			mes="Maio";
		}if(mes.equals("06")){
			mes="Junho";
		}if(mes.equals("07")){
			mes="Julho";
		}if(mes.equals("08")){
			mes="Agosto";
		}if(mes.equals("09")){
			mes="Setembro";
		}if(mes.equals("10")){
			mes="Outubro";
		}if(mes.equals("11")){
			mes="Novembro";
		}if(mes.equals("12")){
			mes="Dezembro";
		}
		
		return mes+" de "+ano;
	}
	
	public static String GetPeriodoFaturacao2(String data){
		
		String mes="";
		String ano="";
		//2018-04-01
		ano=data.substring(0, 4);
		mes=data.substring(5, 7);
		
		if(mes.equals("01")){
			mes="Janeiro";
		}if(mes.equals("02")){
			mes="Fevereiro";
		}if(mes.equals("03")){
			mes="Março";
		}if(mes.equals("04")){
			mes="Abril";
		}if(mes.equals("05")){
			mes="Maio";
		}if(mes.equals("06")){
			mes="Junho";
		}if(mes.equals("07")){
			mes="Julho";
		}if(mes.equals("08")){
			mes="Agosto";
		}if(mes.equals("09")){
			mes="Setembro";
		}if(mes.equals("10")){
			mes="Outubro";
		}if(mes.equals("11")){
			mes="Novembro";
		}if(mes.equals("12")){
			mes="Dezembro";
		}
		
		return mes+" de "+ano;
	}
	
	public static String getVal(Double val){
	        String res="";
	        if(val!=null){
	            //DecimalFormat df = new DecimalFormat("0.00");
	            DecimalFormat df = new DecimalFormat("###,##0.00");
	        	//DecimalFormat df = new DecimalFormat("###.##0,00");
	            return df.format(val);
	        }
	        return res;
	}
	
	public static String getVal2(Double val){
        String res="";
        if(val!=null){
            //DecimalFormat df = new DecimalFormat("0.00");
            DecimalFormat df = new DecimalFormat("###,##0");
            return df.format(val);
        }
        return res;
}
	
	public static String getValEuro(Double val){
        String res="";
        if(val!=null){
            //DecimalFormat df = new DecimalFormat("0.00");
            DecimalFormat df = new DecimalFormat("###,##0");
            return df.format(val);
        }
        return res;
    }
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static String DataNow(){
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String dat="";
		try {
			dat = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
						
		return dat;
	}
	
	public static String DataNowFat(){
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String dat="";
		try {
			dat = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
						
		return dat;
	}
	
	public static String receiv(String data){
		
		String res="";
		
		String ano=	data.substring(0, 4);
		String mes=	data.substring(5, 7);
		String dia=	data.substring(8, 10);
		res=dia+"-"+mes+"-"+ano;
		
		
						
		return res;
	}
	
	public static String extensoUP(String extenso){
		
		String res="";
		if(extenso.length()>1){
		String f=extenso.substring(0,1);
		res=f.toUpperCase()+extenso.substring(1, extenso.length());
		}
		
						
		return res;
	}
	
	public static String getExtensao(int extenso){
		String[] args=new String[20];
        args[0]=Integer.toString(extenso);
         Extenso valor_Extenso = new Extenso(new BigDecimal(args[0])); 
         System.out.println("valor_Extenso2 "+valor_Extenso);
         String parc="";
         String val=valor_Extenso.toString();//	
         try{
        	 parc=val.substring(0,1).toUpperCase();
        	   parc=parc + val.substring(1, val.length());
         }catch(Exception e){
        	 parc="";
         }
		return parc;
	}
}
