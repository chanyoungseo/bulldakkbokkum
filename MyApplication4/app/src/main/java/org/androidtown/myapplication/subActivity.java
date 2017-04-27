package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jonathan on 2017-04-18.
 */

public class subActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        Intent intent2 = getIntent();
        Bundle bundle2=intent2.getExtras();
        String  x = bundle2.getString("name");
        textView1.setText("성명    : "+x);
        textView2.setText("성별    : "+bundle2.getString("gender"));
        textView3.setText("수신여부:"+bundle2.getString("susin"));

        button = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
