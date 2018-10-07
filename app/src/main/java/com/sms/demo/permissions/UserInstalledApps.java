package com.sms.demo.permissions;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserInstalledApps extends AppCompatActivity {

    ListView listView;
    PackageManager pm;
    List<ApplicationInfo> packages;
    CheckPermissions checkPermissions;
    ArrayList<String> GrantednormalPermissions;
    ArrayList<String> DangeriousPermissionGranted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_installed_apps);
        init_views();
        init_variables();
        init_functions();
        init_listeners();
    }

    private void init_views() {
        listView = (ListView)findViewById(R.id.list_U);
    }


    private void init_variables() {
        packages = new ArrayList<>();
        checkPermissions = new CheckPermissions();
        GrantednormalPermissions = new ArrayList<>();
        DangeriousPermissionGranted = new ArrayList<>();
    }

    private void init_functions() {
        pm = getPackageManager();
        getUserInstalledApps();

        listView.setAdapter(new AdapterForSystemApps(packages,getApplicationContext()));
    }

    private void init_listeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String PackageName = packages.get(position).packageName;


                GrantednormalPermissions = checkPermissions.checkNormalPermissions(PackageName,pm);
                DangeriousPermissionGranted = checkPermissions.checkDangeriousPermissions(PackageName,pm);

                Intent intent = new Intent(UserInstalledApps.this,Opetions.class);
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



    private void getUserInstalledApps() {
        int flags = PackageManager.GET_META_DATA |
                PackageManager.GET_SHARED_LIBRARY_FILES |
                PackageManager.GET_UNINSTALLED_PACKAGES;

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> applications = pm.getInstalledApplications(flags);
        for (ApplicationInfo appInfo : applications) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1) {
               //System Installed Apps
            } else {
                packages.add(appInfo);
            }
        }
    }
}
