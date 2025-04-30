package com.lgcns.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;

// DTO 클래스 예시
class JsonClass {
	private String name;
	private int age;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

public class MyServlet extends HttpServlet {

	private final Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getRequestURI(); // 예: /myapi/device
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();

		switch (path) {
			case "/device":
				handleDeviceGet(req, res, out);
				break;
			case "/command":
				handleCommandGet(req, res, out);
				break;
			default:
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				out.write("{\"error\": \"Unknown GET endpoint\"}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getRequestURI(); // 예: /myapi/device
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();

		switch (path) {
			case "/device":
				handleDevicePost(req, res, out);
				break;
			case "/command":
				handleCommandPost(req, res, out);
				break;
			default:
				res.setStatus(HttpServletResponse.SC_NOT_FOUND);
				out.write("{\"error\": \"Unknown POST endpoint\"}");
		}
	}

	// ===== GET 핸들러 =====

	private void handleDeviceGet(HttpServletRequest req, HttpServletResponse res, PrintWriter out) {
		String name = req.getParameter("name");
		int age = parseInt(req.getParameter("age"));

		JsonClass data = new JsonClass();
		data.setName(name);
		data.setAge(age);

		out.write(gson.toJson(data));
	}

	private void handleCommandGet(HttpServletRequest req, HttpServletResponse res, PrintWriter out) {
		out.write("{\"message\": \"This is a dummy command GET response\"}");
	}

	// ===== POST 핸들러 =====

	private void handleDevicePost(HttpServletRequest req, HttpServletResponse res, PrintWriter out) throws IOException {
		JsonClass data = parseJsonBody(req, JsonClass.class);
		out.write(gson.toJson(data));
	}

	private void handleCommandPost(HttpServletRequest req, HttpServletResponse res, PrintWriter out) throws IOException {
		out.write("{\"message\": \"Command POST logic to be implemented\"}");
	}

	// ===== 공통 유틸 =====

	private <T> T parseJsonBody(HttpServletRequest req, Class<T> clazz) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = req.getReader()) {
			String line;
			while ((line = reader.readLine()) != null) sb.append(line);
		}
		return gson.fromJson(sb.toString(), clazz);
	}

	private int parseInt(String s) {
		try {
			return s != null ? Integer.parseInt(s) : 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
