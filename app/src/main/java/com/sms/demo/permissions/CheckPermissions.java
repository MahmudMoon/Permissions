package com.sms.demo.permissions;

import android.content.pm.PackageManager;

import java.util.ArrayList;

public class CheckPermissions {


    String[] normalPermissions = {"android.permission.ACCESS_LOCATION_EXTRA_COMMANDS",
            "android.permission.ACCESS_NETWORK_STATE",
            "android.permission.ACCESS_NOTIFICATION_POLICY",
            "android.permission.ACCESS_WIFI_STATE",
            "android.permission.BLUETOOTH_ADMIN",
            "android.permission.BROADCAST_STICKY",
            "android.permission.CHANGE_NETWORK_STATE",
            "android.permission.CHANGE_WIFI_MULTICAST_STATE",
            "android.permission.CHANGE_WIFI_STATE",
            "android.permission.DISABLE_KEYGUARD",
            "android.permission.EXPAND_STATUS_BAR",
            "android.permission.FOREGROUND_SERVICE",
            "android.permission.GET_PACKAGE_SIZE",
            "android.permission.INSTALL_SHORTCUT",
            "android.permission.INTERNET",
            "android.permission.VIBRATE",
            "android.permission.WRITE_SYNC_SETTINGS",
            "android.permission.WAKE_LOCK",
            "android.permission.USE_FINGERPRINT",
            "android.permission.TRANSMIT_IR",
            "android.permission.SET_WALLPAPER_HINTS",
            "android.permission.SET_WALLPAPER",
            "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS",
            "android.permission.REQUEST_DELETE_PACKAGES",
            "android.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND",
            "android.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND",
            "android.permission.REORDER_TASKS",
            "android.permission.RECEIVE_BOOT_COMPLETED",
            "android.permission.READ_SYNC_STATS",
            "android.permission.READ_SYNC_SETTINGS",
            "android.permission.NFC",
            "android.permission.MODIFY_AUDIO_SETTINGS",
            "android.permission.MANAGE_OWN_CALLS",
            "android.permission.KILL_BACKGROUND_PROCESSES" };


    String[] dangeriousPermissions = {"android.permission.READ_CALENDAR",
            "android.permission.WRITE_CALENDAR",
            "android.permission.READ_CALL_LOG",
            "android.permission.WRITE_CALL_LOG",
            "android.permission.PROCESS_OUTGOING_CALLS",
            "android.permission.CAMERA",
            "android.permission.READ_CONTACTS",
            "android.permission.WRITE_CONTACTS",
            "android.permission.GET_ACCOUNTS",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.RECORD_AUDIO",
            "android.permission.READ_PHONE_STATE",
            "android.permission.READ_PHONE_NUMBERS",
            "android.permission.CALL_PHONE",
            "android.permission.ANSWER_PHONE_CALLS",
            "android.permission.ADD_VOICEMAIL",
            "android.permission.USE_SIP",
            "android.permission.BODY_SENSORS",
            "android.permission.SEND_SMS",
            "android.permission.RECEIVE_SMS",
            "android.permission.READ_SMS",
            "android.permission.RECEIVE_WAP_PUSH",
            "android.permission.RECEIVE_MMS",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    public ArrayList<String> checkNormalPermissions(String PackageName,PackageManager packageManager){
        ArrayList<String> noramlPermissionsGranted
                = new ArrayList<>();
        for(int i=0;i<normalPermissions.length;i++){
            if(packageManager.checkPermission(normalPermissions[i],PackageName)==packageManager.PERMISSION_GRANTED){
                noramlPermissionsGranted.add(normalPermissions[i]);
            }
        }

        return noramlPermissionsGranted;
    }


    public ArrayList<String> checkDangeriousPermissions(String PackageName,PackageManager packageManager){
        ArrayList<String> dangeriousPermissionsGranted = new ArrayList<>();
        for (int j =0;j<dangeriousPermissions.length;j++){
           if(packageManager.checkPermission(dangeriousPermissions[j],PackageName)==0){
               dangeriousPermissionsGranted.add(dangeriousPermissions[j]);
           }
        }
        return dangeriousPermissionsGranted;
    }
}
