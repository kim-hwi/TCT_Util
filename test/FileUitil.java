package com.lgcns.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FileUitil {
	

	public void PrintTxtFile(String fileName) {
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line =bufferedReader.readLine()) != null){
				System.out.println(line);
				
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void copyTxtFile(String inputFile, String outputFile) {
		String line = null;
		try {
			FileReader fileReader = new FileReader(inputFile);
			FileWriter fileWriter = new FileWriter(outputFile);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			while((line =bufferedReader.readLine()) != null){
				bufferedWriter.write(line);
			}
			bufferedReader.close();
			bufferedWriter.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void copyLIMTxtFile(String inputFile, String outputFile,String lim) {
		String line = null;
		try {
			

			ArrayList<Integer> arr = new ArrayList<>();
			
			FileReader fileReader = new FileReader(inputFile);
			FileWriter fileWriter = new FileWriter(outputFile);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			while((line =bufferedReader.readLine()) != null){
				String targert = line.substring(9, 12);
				int total = 0;
				if(Integer.parseInt(targert)>Integer.parseInt(lim)) {
					line+="#Y";
				}
				else {
					line+="#N";
				}
				if(arr.size()>=3) {
					arr.remove(0);
					arr.add(Integer.parseInt(targert));
				}
				else {
					arr.add(Integer.parseInt(targert));
				}
				for(int i = 0 ; i < arr.size() ; i++) {
					total+=arr.get(i);
				}
				total = total/arr.size();
			
				if(total<100) {
					line+="#0"+Integer.toString(total);
				}
				else{
					line+="#"+Integer.toString(total);
				}
				System.out.println(line);
				bufferedWriter.write(line);
			}
			bufferedReader.close();
			bufferedWriter.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void printBinaryFile(String inputFile) {
		final int BUFFER_SIZE=4096;
		int readline;
		try {
			InputStream inputStream = new FileInputStream(inputFile);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while((readline = inputStream.read(buffer)) != -1) {
				System.out.println(readline);
			}
			inputStream.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	public void copyBinaryFile(String inputFile, String outputFile) {
		final int BUFFER_SIZE=4096;
		int readline;
		try {
			InputStream inputStream = new FileInputStream(inputFile);
			OutputStream outputStream = new FileOutputStream(outputFile);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while((readline = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer,0,readline);
			}
			inputStream.close();
			outputStream.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void fileSerch(String path) {
		File dir = new File(path);
		File[] fList = dir.listFiles();
		
		for(File file : fList) {
			if(file.isDirectory()) {
				System.out.println("dir : "+file.getName());
			}
			else {
				System.out.println(file.getName());
			}
		}
	}
	
	public void fileSerchAll(String path) {
		File dir = new File(path);
		File[] fList = dir.listFiles();
		
		for(File file : fList) {
			if(file.isDirectory()) {
				System.out.println("dir : "+file.getName());
				fileSerchAll(file.getPath());
			}
			else {
				System.out.println(file.getName());
			}
		}
	}
	
	

}
