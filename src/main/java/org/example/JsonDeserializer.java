package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDeserializer {
//    public static void main(String[] args) throws IOException, JSONException, ParseException {
//        try {
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(new FileReader("C:\\Users\\Rajdeep\\Desktop\\New1.json"));
//            JSONObject objJsonObject = new JSONObject(obj.toString());
//            System.out.println(objJsonObject);
//            JSONArray Liste = objJsonObject.getJSONArray("ListeCar");
//            String listeCar = Liste.getJSONObject(0).getString("id");
//            for (int i = 0; i < Liste.length(); i++) {
//                String id = Liste.getJSONObject(i).getString("id");
//                System.out.println(id);
//                String size = Liste.getJSONObject(i).getString("size");
//                System.out.println(size);
//                String Orientation = Liste.getJSONObject(i).getString("Orientation");
//                System.out.println(Orientation);
//                String Position = Liste.getJSONObject(i).getJSONObject("Position").toString();
//                System.out.println(Position);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("C:\\Users\\Rajdeep\\Desktop\\New1.json"));
            JSONArray json = new JSONArray(tokener);
            Stream<Object> stream = json.toList().stream().flatMap(JsonDeserializer::flatten);
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static Stream<Object> flatten(Object o) {
        if (o instanceof JSONArray) {
            JSONArray array = (JSONArray) o;
            return array.toList().stream().flatMap(JsonDeserializer::flatten);
        } else if (o instanceof JSONObject) {
            JSONObject object = (JSONObject) o;
            return object.toMap().values().stream().flatMap(JsonDeserializer::flatten);
        } else {
            return Stream.of(o);
        }
    }
}
