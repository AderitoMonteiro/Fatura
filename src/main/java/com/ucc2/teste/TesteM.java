package com.ucc2.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ucc2.auxiliar.FormateData;

public class TesteM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String str ="Z030";// FormateData.getVal(2800.00);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	c.setTime(new Date()); // Now use today date.
	c.add(Calendar.DATE, 5); // Adding 5 days
	String output = sdf.format(c.getTime());
	System.out.println(output);
	}

	public static String  getDateLimitPagamento(String payment_terms){
		String addDays="30";
		if(payment_terms.startsWith("ZP")){
			addDays="30";
		}
		if(payment_terms.startsWith("Z0")){
			try{
				addDays=payment_terms.substring(2, payment_terms.length());
			}catch(Exception e){
				addDays="30";
			}
		}
		if(payment_terms.startsWith("Z1") || payment_terms.startsWith("Z2") || payment_terms.startsWith("Z3") ){
			addDays="30";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, Integer.parseInt(addDays)); // Adding  days
		String output = sdf.format(c.getTime());
		
		return output;
		
	}
	

	
}
