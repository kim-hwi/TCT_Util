package com.lgcns.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JsonUtil jsonUtil = new JsonUtil();
		String path = req.getRequestURI();
		
		PrintWriter p = res.getWriter();
		String json = jsonUtil.classToJsonString(new JsonClass());
		p.write(json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JsonUtil jsonUtil = new JsonUtil();
		String path = req.getRequestURI();
		
		PrintWriter p = res.getWriter();
		String json = jsonUtil.classToJsonString(new JsonClass());
		p.write(json);
		
	}
}
