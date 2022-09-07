package com.ucc2.auxiliar;

public class Validator {

		public static int ValidateFatura(String numFatura, String TypeHeader){
			System.out.println("numFatura  ********************************************* "+numFatura);
			String primeiroDigito="";
			if(TypeHeader.equals("2") || TypeHeader.equals("3") || TypeHeader.equals("4")){
				return 1;
			}
			if(numFatura != null && numFatura != "" && TypeHeader.equals("1")){
				primeiroDigito=numFatura.substring(0, 1);
				if(numFatura.length() == 9 && primeiroDigito.equals("3")){
					return 1;
				}else{
					return 0;
				}
			}
			

			
			return 0;
			
		}

}
