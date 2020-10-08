package com.gamboa;

import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class API {
    public JSONObject getAPI() throws IOException{
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("https://ali-express1.p.rapidapi.com/categories")
                .get()
                .addHeader("x-rapidapi-host", "ali-express1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "d3bf289c47msh0e5ac4719ec1dc4p11e2d4jsnb5f36e06d523")
                .build();

        okhttp3.Response response = client.newCall(request).execute();

        return new JSONObject(response.body().string());
    }

    public ArrayList<Integer> getIds() throws IOException {
        JSONObject obj = getAPI();
        JSONArray cats = obj.getJSONArray("categories");
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 20; i++){ //i < cat.length()
            JSONObject cat = cats.getJSONObject(i);
            int id = Integer.parseInt(cat.getString("id"));
            ids.add(id);
        }return ids;
    }

    public int[] idArray() throws IOException {
        ArrayList<Integer> ids = getIds();
        Iterator<Integer> it = ids.stream().iterator();
        int[] idArr = new int[20];
        int c = 0;

        while (it.hasNext()){
            Integer i = it.next();
            idArr[c] = i;
            c++;
        }return idArr;
    }

    public void printIDs() throws IOException {
        ArrayList<Integer> ids = getIds();
        Iterator<Integer> it = ids.stream().iterator();

        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
    }
}


/*
https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java
I used org.json, but com.oracle.json seems like a good option too.

https://stleary.github.io/JSON-java/index.html
https://docs.oracle.com/javame/8.0/api/json/api/com/oracle/json/JsonObject.html
*/
