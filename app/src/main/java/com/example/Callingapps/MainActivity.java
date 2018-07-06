package com.example.Callingapps;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button b10 = (Button) findViewById(R.id.b10);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent();
        switch (v.getId()) {

            case R.id.b1:

                i.setAction(Intent.ACTION_DIAL);
                startActivity(i);
                break;

            case R.id.b2:
                i.setData(Uri.parse("https://www.google.com"));
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
                break;

            case R.id.b3:
                i.setData(Uri.parse("geo:18.921984, 72.834654"));
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
                break;

            case R.id.b4:
                i.setData(ContactsContract.Contacts.CONTENT_URI);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
                break;

            case R.id.b5:
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
                break;

            case R.id.b6:

                i.setAction("android.intent.action.MUSIC_PLAYER");
                startActivity(i);
                break;

            case R.id.b7:
                i.setData(Uri.parse("sms:"));
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
                break;

            case R.id.b8:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                String[] to = {"paragahire86@gmail.com"};
                String[] cc = {""};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                emailIntent.putExtra(Intent.EXTRA_CC, cc);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Testing!!!!");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Cool!!!");
                emailIntent.setType("message/rfc822");

                startActivity(Intent.createChooser(emailIntent, "Email"));
                break;



            case R.id.b9:
                i.setClassName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
                startActivity(i);
                break;

            case R.id.b10:
                ArrayList<HashMap<String,Object>> item =new ArrayList<HashMap<String,Object>>();
                PackageManager m;
                m = getPackageManager();
                List<PackageInfo> pack = m.getInstalledPackages(0);
                for (PackageInfo pi : pack) {
                    if( pi.packageName.toString().toLowerCase().contains("calcul")){
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        map.put("appName", pi.applicationInfo.loadLabel(m));
                        map.put("packageName", pi.packageName);
                        item.add(map);
                    }
                }

                if(item.size()>=1){
                    String packageName = (String) item.get(0).get("packageName");
                    i = m.getLaunchIntentForPackage(packageName);
                    if (i != null)
                        startActivity(i);
                }
                else{

                }


                startActivity(i);
                break;


        }

    }
}
