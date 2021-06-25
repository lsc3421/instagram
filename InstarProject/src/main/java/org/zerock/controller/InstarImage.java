package org.zerock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InstarImage { 
	public static void main(String[] args) { 
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "studydb";
		String userName = "Local instance MySql80";
		String password = "ko1256516"; 
		Connection con = null;
		try{ 
			Class.forName(driverName);
		con = DriverManager.getConnection(url+dbName,userName,password);
		Statement st = con.createStatement(); 
		File imgfile = new File("d:\\images.jpg");
		FileInputStream fin = new FileInputStream(imgfile); 
		PreparedStatement pre = con.prepareStatement("insert into instarImage (ID, FILENAME, FILE) VALUES (?, ?, ?)");
		pre.setInt(1,5); pre.setString(2,"Durga");
		pre.setBinaryStream(3,fin,(int)imgfile.length());
		//Stream형의 파일 업로드
		pre.executeUpdate();
		System.out.println("Inserting Successfully!"); 
		pre.close(); con.close();
		}
		catch (Exception e){ System.out.println(e.getMessage()); } 
		}
	}
		

