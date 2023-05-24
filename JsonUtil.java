package com.lgcns.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {

	public String classToJsonString() {

		JsonClass jsonClass = new JsonClass();
		//jsonCalss에 입력
		Gson gson = new Gson();
		String json = gson.toJson(jsonClass);
		return json;
		
	}
	
	public String classToJsonString(JsonClass jsonClass) {

		Gson gson = new Gson();
		String json = gson.toJson(jsonClass);
		return json;
	}
	
	public JsonClass JsonFileToClass(String file) throws FileNotFoundException {
		FileReader fileReader = new FileReader(file);
		Gson gson = new Gson();
		JsonClass jsonClass = gson.fromJson(fileReader, JsonClass.class);
		return jsonClass;
	}
	
	public JsonClass JsonStringToClass(String message) throws FileNotFoundException {
		Gson gson = new Gson();
		JsonClass jsonClass = gson.fromJson(message, JsonClass.class);
		return jsonClass;
	}
	
	public String JsonStringToString(String message) throws FileNotFoundException {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message);
		JsonObject rootob = element.getAsJsonObject().get("response").getAsJsonObject();
		JsonObject body = rootob.getAsJsonObject().get("body").getAsJsonObject();
		JsonObject items = body.getAsJsonObject().get("items").getAsJsonObject();
		return items.getAsString();
	}
	
	public List<JsonClass> JsonStringToClassList(String message) throws FileNotFoundException {
		
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message);
		JsonArray item = element.getAsJsonObject().get("item").getAsJsonArray();
		List<JsonClass> list = gson.fromJson(item.toString(), List.class);
		return list;
	}
	
	
	
	
	

}
