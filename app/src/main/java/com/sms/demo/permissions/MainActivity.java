package com.sms.demo.permissions;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Test";
    private static final String TAG1 = "TEST";
    Button btn ;
    ListView listView;
    PackageManager pm;
    List<ApplicationInfo> packages;
    CheckPermissions checkPermissions;
    ArrayList<String> GrantednormalPermissions;
    ArrayList<String> DangeriousPermissionGranted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_views();
        init_variables();
        init_functions();
        init_listener();
    }

    private void init_listener() {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(TAG, "Installed package :" + packages.get(position).packageName);
                String PackageName = packages.get(position).packageName;


                 GrantednormalPermissions = checkPermissions.checkNormalPermissions(PackageName,pm);
                  DangeriousPermissionGranted = checkPermissions.checkDangeriousPermissions(PackageName,pm);

                Intent intent = new Intent(MainActivity.this,Opetions.class);
                intent.putExtra("packageName",PackageName);
                intent.putStringArrayListExtra("normalPermissions",GrantednormalPermissions);
                intent.putStringArrayListExtra("dangeriousPermissions",DangeriousPermissionGranted);
                startActivity(intent);

//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
//                        Uri.parse("package:"+packages.get(position).packageName));
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getApplicationContext().startActivity(intent);


            }
        });
    }

    private void init_functions() {
        pm = getPackageManager();
        packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        Log.d("TEST", Integer.toString(pm.checkPermission("android.permission.READ_EXTERNAL_STORAGE","com.example.moon.music_player")));


//        for (ApplicationInfo packageInfo : packages) {
//            GrantednormalPermissions = checkPermissions.checkNormalPermissions(packageInfo.packageName,pm);
//
//            Log.d(TAG,packageInfo.packageName + " = " + Integer.toString(GrantednormalPermissions.size()));
//        }
//
//        for (ApplicationInfo packageInfo : packages) {
//            DangeriousPermissionGranted = checkPermissions.checkDangeriousPermissions(packageInfo.packageName,pm);
//
//            Log.d(TAG1,packageInfo.packageName + " = " + Integer.toString(DangeriousPermissionGranted.size()));
//        }

        listView.setAdapter(new adapter(packages,getApplicationContext()));

    }

    private void init_variables() {

        checkPermissions = new CheckPermissions();
        GrantednormalPermissions = new ArrayList<>();
        DangeriousPermissionGranted = new ArrayList<>();

    }

    private void init_views() {
        listView = (ListView)findViewById(R.id.list);
    }

}
