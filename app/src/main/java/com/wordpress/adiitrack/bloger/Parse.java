package com.wordpress.adiitrack.bloger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parse {
    public static String keyname="name";
    public static String keyemail="email";
    public static String keyblog="blog";
    public static String keydate="datetime";
    public static String keyarray="data";

    public static String[] name;
    public static String[] email;
    public static String[] blog;
    public static String[] datetime;

    public Parse(String response) {
        //to remove curly braces
        try {
            JSONObject jo=new JSONObject(response);
            JSONArray ja=jo.getJSONArray(keyarray);
            name=new String[ja.length()];
            email=new String[ja.length()];
            blog=new String[ja.length()];
            datetime=new String[ja.length()];

            for(int i=0;i<ja.length();i++){
                JSONObject job=ja.getJSONObject(i);
                name[i]=job.getString(keyname);
                email[i]=job.getString(keyemail);
                blog[i]=job.getString(keyblog);
                datetime[i]=job.getString(keydate);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
