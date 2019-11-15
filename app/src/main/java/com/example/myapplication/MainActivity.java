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

public class MainActivity extends AppCompatActivity {
    Button btn;
    int c = 0;
    int create = 0;

//    private String exe_path = "data/data/com.example.myapplication/hello";
//    private File exe_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create++;

//
//        try {
//            copyBigDataToSD(exe_path);
//            exe_file = new File(exe_path);
//            exe_file.setExecutable(true, true);
//            execCmd(exe_path);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hellotv = (TextView)findViewById(R.id.textView);
                Toast.makeText(MainActivity.this,"修改成功", Toast.LENGTH_SHORT).show();
                hellotv.setText("4o567");

                c++;
                hellotv.setText("create:"+create+",click:"+c+"\n"+JniLib.callToCpp());

            }
        });
    }


    private void execCmd(String cmd) throws IOException {
        System.out.println("### zht start");
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while (null != (line = br.readLine())) {
//            Log.e("########", line);
            System.out.println("### " + line);
        }
        System.out.println("### zht end");
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void copyBigDataToSD(String strOutFileName) throws IOException
    {
        InputStream myInput;
        OutputStream myOutput = new FileOutputStream(strOutFileName);
        myInput = this.getAssets().open("hello");
        byte[] buffer = new byte[1024];
        int length = myInput.read(buffer);
        while(length > 0)
        {
            myOutput.write(buffer, 0, length);
            length = myInput.read(buffer);
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
    }


}
