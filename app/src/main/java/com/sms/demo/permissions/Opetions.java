package com.sms.demo.permissions;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Opetions extends AppCompatActivity {

    Button OpenApp,ManageApp;
    String Pack;
    ArrayList<String> NPermissions;
    ArrayList<String> DPermissions;
    TextView AppName;
    TextView NormalP;
    TextView DengeriousP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opetions);

        AppName = (TextView)findViewById(R.id.tv_appname);
        NormalP = (TextView)findViewById(R.id.tv_nomal_permissons);
        DengeriousP = (TextView)findViewById(R.id.tv_dangerios_permissions);
        OpenApp = (Button)findViewById(R.id.button);
        ManageApp = (Button)findViewById(R.id.button2);


        Intent intent = getIntent();
        Pack = intent.getStringExtra("packageName");
        NPermissions = intent.getStringArrayListExtra("normalPermissions");
        DPermissions = intent.getStringArrayListExtra("dangeriousPermissions");

        AppName.setText(Pack);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<NPermissions.size();i++){
            stringBuffer.append(NPermissions.get(i));
            stringBuffer.append("\n");
        }

        NormalP.setText(stringBuffer.toString());


        StringBuffer stringBuffer1 = new StringBuffer();
        for(int j=0;j<DPermissions.size();j++){
            stringBuffer1.append(DPermissions.get(j));
            stringBuffer1.append("\n");
        }

        DengeriousP.setText(stringBuffer1.toString());


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
