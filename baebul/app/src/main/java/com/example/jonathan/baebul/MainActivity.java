package com.example.jonathan.baebul;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText1);
        age = (EditText)findViewById(R.id.editText2);
        Button button1 = (Button) findViewById(R.id.button1);

        /*
        When button clicked, send information of name and age to Main2Activity.java.
         */
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent (getApplicationContext(), Main2Activity.class);
                String ln=name.getText().toString();
                name.setText("");
                String la=age.getText().toString();
                age.setText("");
                intent.putExtra("ln", ln);
                intent.putExtra("la", la);
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 1);
            }

        });


    }
}
