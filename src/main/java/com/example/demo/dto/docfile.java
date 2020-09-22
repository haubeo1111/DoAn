package com.example.demo.dto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class docfile {
	public static List<String> ar=new ArrayList<>();
	public String readFile() {
		  String aa="";
		 try {
		     //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
		     File f = new File("F:\\data1.txt");
		     FileReader fr = new FileReader(f);
		     //Bước 2: Đọc dữ liệu
		     BufferedReader br = new BufferedReader(fr);
		    
		     String line;
		     while ((line = br.readLine()) != null){
		       ar.add(line);
		    	// aa=aa+line;
		     }
		     //Bước 3: Đóng luồng
		     fr.close();
		     br.close();
		    } catch (Exception ex) {
		      System.out.println("Loi doc file: "+ex);
		  }
		 return aa;
	}
	public static void main(String [] args) {
		
		docfile a=new docfile();
		a.readFile();
		String q="\"á châu\"=>\"\",";
		System.out.println("hoan thanh"+ar.size()+"  "+ar.get(0)+"  "+ar.get(10)+"  "+ar.get(20));
		for(int i=0;i<ar.size();i++) {
			if(q.equals(ar.get(i))) {
				System.out.println("okooo");
			}
		}
	}
}
