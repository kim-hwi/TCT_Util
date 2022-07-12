package com.lgcns.test;

import java.io.File;
import java.util.Scanner;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner scanner = new Scanner(System.in);
		String lim = "";
		lim = scanner.nextLine();
//		File file = new File("./INPUT/MONITORING.TXT");
		FileUitil fileUitil = new FileUitil();
		fileUitil.copyLIMTxtFile("./INPUT/MONITORING.TXT", "./OUTPUT/REPORT.TXT",lim);
//		printList(file);
		
	}
	
	public static void printList(File file) {//재귀함수
        File[] fList = file.listFiles();
        for (File f : fList) {
            System.out.println(f.getAbsolutePath());
            if(f.listFiles() != null)
                printList(f);
        }
    }
	
}