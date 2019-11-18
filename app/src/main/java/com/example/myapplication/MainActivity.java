package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// https://www.cnblogs.com/andrewwang/p/11024891.html
public class MainActivity extends AppCompatActivity {
    String TAG="Main_Debug:";
    TextView textview1;
    int c = 0;
    int create = 0;

    CopyElfs ce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1=(TextView)findViewById(R.id.textView1);
        create++;

        ce = new CopyElfs(getBaseContext());
        ce.copyAll2Data();

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview1.setText("4o567");
            }
        });

    }

    public void bt2_click(View view){
        c = c+1;
        textview1.setText("create:"+create+",click:"+c+"\n"+JniLib.callToCpp());
    }

    public void bt3_click(View view){
        c = c+1;
//        textview1.setText("click:"+c+"\n"+callElf("hello"));

        textview1.setText("click:"+c+"\n"+callElf("md5 testString"));
//        textview1.setText("click:"+c+"\n"+ YunxingLib.runYunxingFromJNI());
    }

    public String callElf(String cmd){
        Process p;
        String tmpText;
        String execResult = "";

        try {
            p = Runtime.getRuntime().exec(ce.getExecutableFilePath() + "/"+cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((tmpText = br.readLine()) != null) {
                execResult += tmpText+"\n";
            }
        }catch (IOException e){
            Log.i(TAG,e.toString());
        }
        return execResult;
    }



}
