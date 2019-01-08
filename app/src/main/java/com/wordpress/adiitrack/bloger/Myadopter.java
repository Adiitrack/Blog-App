package com.wordpress.adiitrack.bloger;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Myadopter extends ArrayAdapter<String> {
    Context context;
    String name[];
    String email[];
    String blog[];
    String datetime[];

    //constructor
    public Myadopter(Context context,int layout,String[] name,String[] email,String[] blog, String[] datetime)
    {
        super(context, layout,name);
        this.context=context;
        this.name=name;
        this.email=email;
        this.blog=blog;
        this.datetime=datetime;

    }

    //to determine size
    @Override
    public int getCount(){
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        convertView=LayoutInflater.from(context).inflate(R.layout.adop,parent,false);
        TextView nameid,emailid,blogid,datetimeid;
        nameid=convertView.findViewById(R.id.name);
        emailid=convertView.findViewById(R.id.email);
        blogid=convertView.findViewById(R.id.blog);
        datetimeid=convertView.findViewById(R.id.datetime);
        nameid.setText(name[position]);
        emailid.setText(email[position]);
        blogid.setText(blog[position]);
        datetimeid.setText(datetime[position]);
        return convertView;
    }
}
