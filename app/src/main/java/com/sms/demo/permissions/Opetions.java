package com.sms.demo.permissions;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Opetions extends AppCompatActivity {

    Button OpenApp,ManageApp;
    String Pack;
    ArrayList<String> NPermissions;
    ArrayList<String> DPermissions;
    PackageManager packageManager;
    TextView AppName;
    ArrayList<String> NetWorkRelatedPermissions,SMSRelatedPermissions
            ,CallRelatedPermissions,CameraRelatedPermissions
            ,ContactRelatedPermissions,AccountRelatedPermissions
            ,LocationRelatedPermissions,StorageRelatedPermissions;
    ArrayList<String> Resources;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opetions);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        AppName = (TextView)findViewById(R.id.tv_appname);
        ls = (ListView)findViewById(R.id.list_v);
        OpenApp = (Button)findViewById(R.id.button);
        ManageApp = (Button)findViewById(R.id.button2);
        Resources = new ArrayList<>();
        NetWorkRelatedPermissions = new ArrayList<>();
        SMSRelatedPermissions = new ArrayList<>();
        CallRelatedPermissions = new ArrayList<>();
        CameraRelatedPermissions = new ArrayList<>();
        ContactRelatedPermissions = new ArrayList<>();
        AccountRelatedPermissions = new ArrayList<>();
        LocationRelatedPermissions = new ArrayList<>();
        StorageRelatedPermissions = new ArrayList<>();
        packageManager = getPackageManager();
        Intent intent = getIntent();
        Pack = intent.getStringExtra("packageName");
        NPermissions = intent.getStringArrayListExtra("normalPermissions");
        DPermissions = intent.getStringArrayListExtra("dangeriousPermissions");

        AppName.setText(Pack);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<NPermissions.size();i++){
            String permissions = NPermissions.get(i);
            if(permissions.contains("INTERNET") || permissions.contains("WIFI") || permissions.contains("NETWORK")){
                NetWorkRelatedPermissions.add(permissions);
            }else if(permissions.contains("SMS")){
                SMSRelatedPermissions.add(permissions);
            }else if(permissions.contains("CALL")){
                CallRelatedPermissions.add(permissions);
            }else if(permissions.contains("CAMERA")){
                CameraRelatedPermissions.add(permissions);
            }else if(permissions.contains("CONTACTS")){
                ContactRelatedPermissions.add(permissions);
            }else if(permissions.contains("ACCOUNTS")){
                AccountRelatedPermissions.add(permissions);
            }else if(permissions.contains("LOCATION")){
                LocationRelatedPermissions.add(permissions);
            }else if(permissions.contains("STORAGE")){
                StorageRelatedPermissions.add(permissions);
            }
        }

        for(int j=0;j<DPermissions.size();j++){
            String permissions = DPermissions.get(j);
            if(permissions.contains("INTERNET") || permissions.contains("WIFI") || permissions.contains("NETWORK")){
                NetWorkRelatedPermissions.add(permissions);
            }else if(permissions.contains("SMS")){
                SMSRelatedPermissions.add(permissions);
            }else if(permissions.contains("CALL")){
                CallRelatedPermissions.add(permissions);
            }else if(permissions.contains("CAMERA")){
                CameraRelatedPermissions.add(permissions);
            }else if(permissions.contains("CONTACTS")){
                ContactRelatedPermissions.add(permissions);
            }else if(permissions.contains("ACCOUNTS")){
                AccountRelatedPermissions.add(permissions);
            }else if(permissions.contains("LOCATION")){
                LocationRelatedPermissions.add(permissions);
            }else if(permissions.contains("STORAGE")){
                StorageRelatedPermissions.add(permissions);
            }

        }




        if(NetWorkRelatedPermissions.size()>0){
            Resources.add("INTERNET");
        }
        if(SMSRelatedPermissions.size()>0){
            Resources.add("SMS");
        }
        if(CallRelatedPermissions.size()>0){
            Resources.add("CALL");
        }
        if(CameraRelatedPermissions.size()>0){
            Resources.add("CAMERA");
        }
        if(ContactRelatedPermissions.size()>0){
            Resources.add("CONTACTS");
        }

        if(AccountRelatedPermissions.size()>0){
            Resources.add("ACCOUNTS");
        }
        if(LocationRelatedPermissions.size()>0){
            Resources.add("LOCATION");
        }
        if(StorageRelatedPermissions.size()>0){
            Resources.add("STORAGE");
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, Resources);
        ls.setAdapter(arrayAdapter);



        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(Resources.get(position)=="INTERNET"){

                    for(int x = 0;x<NetWorkRelatedPermissions.size();x++){
                        Log.d("NETWORK",NetWorkRelatedPermissions.get(x)+"/n");
                      //  packageManager.removePermission(NetWorkRelatedPermissions.get(x));

                    }

                }else if(Resources.get(position)=="SMS"){

                    for(int x = 0;x<SMSRelatedPermissions.size();x++){
                        Log.d("NETWORK",SMSRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="CALL"){

                    for(int x = 0;x<CallRelatedPermissions.size();x++){
                        Log.d("NETWORK",CallRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="CAMERA"){

                    for(int x = 0;x<CameraRelatedPermissions.size();x++){
                        Log.d("NETWORK",CameraRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="CONTACTS"){

                    for(int x = 0;x<ContactRelatedPermissions.size();x++){
                        Log.d("NETWORK",ContactRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="ACCOUNTS"){

                    for(int x = 0;x<AccountRelatedPermissions.size();x++){
                        Log.d("NETWORK",AccountRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="LOCATION"){

                    for(int x = 0;x<LocationRelatedPermissions.size();x++){
                        Log.d("NETWORK",LocationRelatedPermissions.get(x)+"/n");
                    }

                }else if(Resources.get(position)=="STORAGE"){

                    for(int x = 0;x<StorageRelatedPermissions.size();x++){
                        Log.d("NETWORK",StorageRelatedPermissions.get(x)+"/n");
                    }

                }

            }
        });




        OpenApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPen the application

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(Pack);
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });
        ManageApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open the Settings Paze from here

                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:"+Pack));
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}
