package org.androidtown.myapplication;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    FileReader fileReader;
    // Get sd card path
    String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    final String fileName = "/Lab6.txt";
    File file;
    EditText editText;
    Button button, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Check sd card exist
        if (isExternalStorageWritable())
            Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        editText = (EditText) findViewById(R.id.txtData);

        // When button clicked, write text in EditText at file(edittext의 문자열을 파일에 쓴다)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    file = new File(sdPath, fileName);
                    // if file exist, delete file
                    if(file.exists())
                        file.delete();
                    FileWriter fileWriter = new FileWriter(file,true);
                    fileWriter.write(editText.getText().toString());
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
            }

        });
        // When button2 clicked, Clear EditText
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        // When button3 clicked Read text from stored file and set EditText
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = "";
                file = new File(sdPath+fileName);
                int data;
                try {
                    fileReader = new FileReader(file);
                    while((data = fileReader.read())!=-1)
                        text+=(char)data;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                editText.setText(text);
            }
        });
        // When button4 clicked, finish activity.
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    /*
    * Check sd card method
    * if sd card exist, return true. else false.
     */
    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }
}