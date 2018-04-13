package com.BinaryToString;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

public class BinaryToStringConv {
	

    public static void main(String args[]) throws IOException  {
    	
    	

       System.out.println("Platform Encoding : " + System.getProperty("file.encoding"));
       final String OUTPUT_FILE_NAME = "C:\\\\Users\\\\akuma570\\\\Desktop\\\\coding prject\\\\job-11\\aaa.pdf";
           
       FileInputStream fis = new FileInputStream("C:\\Users\\akuma570\\Desktop\\coding prject\\job-11\\QuranAyat.RAR");
       
       
      
       // Using Apache Commons IOUtils to read file into byte array
       byte[] filedata = IOUtils.toByteArray(fis);
           
       System.out.println(filedata.length);
       
       System.out.println(filedata.length);
       
       String s=new String(filedata);
       
       System.out.println(s);
       
       /*for(byte b:filedata) {
    	   System.out.print((char)b +"  ");
       }
      */
    /* byte bb[]=new byte[filedata.length];
     for(int i=0;i<bb.length;i++) {
    	 bb[i]=filedata[i];
     }*/
       
     /*  System.out.println("111111111111111111");
      String byteArray1=Arrays.toString(filedata);*/
      
      /*String ss[]=byteArray1.split(regex)
      for(int i=0;i<bb.length;i++) {
    	  bb[i]=s
      }*/
      
  
      
    
    
       
     
       
   //    write(filedata,OUTPUT_FILE_NAME);
                           
    }
    
    
    
    
    
    
    
    
   static void write(byte[] aInput, String aOutputFileName){
    	 System.out.println("Writing binary file...");
        try {
          OutputStream output = null;
          try {
            output = new BufferedOutputStream(new FileOutputStream(aOutputFileName));
            output.write(aInput);
          }
          finally {
            output.close();
          }
        }
        catch(FileNotFoundException ex){
          System.out.println("File not found.");
        }
        catch(IOException ex){
        	 System.out.println(ex);
        }
      }
    
    
    
    
}
