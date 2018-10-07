package com.sms.demo.permissions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterForSystemApps extends BaseAdapter {
    List<ApplicationInfo> pack;
    LayoutInflater inflater;
    Context context;
    TextView textView;
    ImageView imageView;

    public AdapterForSystemApps(List<ApplicationInfo> pack, Context context) {
        this.pack = pack;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pack.size();
    }

    @Override
    public Object getItem(int position) {
        return pack.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = inflater.inflate(R.layout.adapterforinstalledapps,null);
        textView = (TextView)view.findViewById(R.id.textView);
        imageView = (ImageView)view.findViewById(R.id.iv_image);
         String appName = pack.get(position).packageName;
         char[] name = appName.toCharArray();
         StringBuilder AppNameReal = new StringBuilder();

         for(int i=name.length-1;i>=0;i--){
             if(name[i]=='.'){
                 break;
             }else
             {
                 AppNameReal.append(name[i]);
             }
         }
         String RealName = AppNameReal.reverse().toString();
        textView.setText(RealName);
        return view;
    }
}
