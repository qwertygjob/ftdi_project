package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.ftdi.j2xx.D2xxManager;


public class MainActivity extends Activity {

    Button checkButton;
    TextView statusField;
    TextView info;
    D2xxManager ftd2xx;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkButton = findViewById(R.id.chk_bttn);
        statusField = findViewById(R.id.textView2);
        info = findViewById(R.id.textView);
    }

        public void onClick(View view) {

                try {

                    int devCount = 0;
                    devCount = ftd2xx.createDeviceInfoList(this);

                    if (devCount > 0) {
                        D2xxManager.FtDeviceInfoListNode[]
                                deviceList = new D2xxManager.FtDeviceInfoListNode[devCount];
                        ftd2xx.getDeviceInfoList(devCount, deviceList);
                        statusField.setText("Number of devices:" + Integer.toString(devCount));
                    }
                    else {
                        statusField.setText("Number of devices:" + Integer.toString(devCount));

                        info.setText("No device");
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }

        }}





