package com.shirley.demo.day21;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class JsonReader {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        //JSONObject json = readJsonFromUrl("https://randomuser.me/api/?format=json&seed=abc&results=5&nat=us&inc=name,location,email,picture,id,registered,login,dob,phone,cell,gender,nat&noinfo");
//        System.out.println(json.toString());
//        System.out.println(json.get("results"));
        JSONObject json2 = readJsonFromUrl("https://www.themealdb.com/api/json/v1/1/categories.php/");
        ObjectMapper mapper = new ObjectMapper();
        //UserFromJson userFromJson = mapper.readValue(json.toString(), UserFromJson.class);
        MealsFromJson mealsFromJson = mapper.readValue(json2.toString(), MealsFromJson.class);
        //userFromJson.getUsers().forEach(System.out::println);
        mealsFromJson.getCategories().forEach(System.out::println);
    }
}
