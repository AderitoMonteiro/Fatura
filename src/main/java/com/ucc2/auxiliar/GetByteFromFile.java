package com.ucc2.auxiliar;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetByteFromFile {
	
	public static Image generate(byte[] buf){
	
		
		//byte[] buf;
		Image image=null;
		try {
			
			image = ImageIO.read(new ByteArrayInputStream(buf));
			//System.out.println("generate image : "+image);
			//image.
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
		
	}
}
