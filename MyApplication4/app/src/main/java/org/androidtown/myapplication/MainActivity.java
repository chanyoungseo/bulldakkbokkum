package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    CheckBox checkBox1;
    CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton4);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox2=(CheckBox)findViewById(R.id.checkBox4);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),subActivity.class);
                Bundle bundle = new Bundle();
                if(radioButton1.isChecked()) {
                    bundle.putString("gender", "여");
                }
                else if(radioButton2.isChecked()) {
                    bundle.putString("gender", "남");
                }
                else
                    bundle.putString("gender","");
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioGroup.clearCheck();
                String dump= "";
                if(checkBox1.isChecked()) {
                    checkBox1.setChecked(false);
                    dump += " " + checkBox1.getText();
                }
                if(checkBox2.isChecked()) {
                    checkBox2.setChecked(false);
                    dump += " " + checkBox2.getText();
                }
                bundle.putString("susin",dump);
                bundle.putString("name",editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                editText.setText("");
            }
        });
    }
}
