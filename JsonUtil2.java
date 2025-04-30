import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil2 {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // ======================== 1. Map<String, Object> 방식 ========================

    public static Map<String, Object> readJsonAsMap(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<String, Object>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON as Map", e);
        }
    }

    public static void writeMapToJson(String filePath, Map<String, Object> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write Map to JSON", e);
        }
    }

    // ======================== 2. Generic DTO 방식 ========================

    public static class CommandRequest<T> {
        private String command;
        private T payload;

        public String getCommand() { return command; }
        public void setCommand(String command) { this.command = command; }
        public T getPayload() { return payload; }
        public void setPayload(T payload) { this.payload = payload; }
    }

    public static <T> CommandRequest<T> readGenericCommand(String filePath, Type type) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read generic command JSON", e);
        }
    }

    public static void writeGenericCommand(String filePath, Object data, Type type) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, type, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write generic command JSON", e);
        }
    }

    // ======================== 3. JsonObject 방식 ========================

    public static JsonObject readJsonAsObject(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON as JsonObject", e);
        }
    }

    public static void writeJsonObject(String filePath, JsonObject obj) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write JsonObject to file", e);
        }
    }

    // ======================== 공통 유틸 ========================

    public static <T> T parseJsonFromString(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJsonString(Object obj) {
        return gson.toJson(obj);
    }
}
