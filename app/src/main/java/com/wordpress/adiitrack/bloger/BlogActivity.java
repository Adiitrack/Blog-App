package com.wordpress.adiitrack.bloger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class BlogActivity extends AppCompatActivity {
    EditText name,email,blog;
    Button button;
    String url="http://searchkero.com/Ablog/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        blog=findViewById(R.id.blog);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //requet to server
                StringRequest stringRequest=new StringRequest(1, url,
                        //response listner
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //to get back to main page
                                finish();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<>();
                        map.put("namekey",name.getText().toString());
                        map.put("emailkey",email.getText().toString());
                        map.put("blogkey",blog.getText().toString());
                        //return objec to stringReq.
                        return map;

                    }
                };

                RequestQueue rq = Volley.newRequestQueue(BlogActivity.this);
                rq.add(stringRequest);
            }
        });
    }
}
