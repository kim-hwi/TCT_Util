package com.lgcns.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProcessUitl {
	
	public static String getProcess(List<String> cmdList) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		Process process = builder.start();
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return (new String(buffer));
	}

}
