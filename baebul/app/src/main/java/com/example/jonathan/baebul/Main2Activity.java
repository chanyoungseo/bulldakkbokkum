package com.example.jonathan.baebul;

import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button0 = (Button) findViewById(R.id.button2);
        Intent pi = getIntent();
        /*
        If intent is coming, get string value 'name' and 'age'.
        If name is empty, Toast message "Please insert name" and finish.
        If age is empty, Toast message "Please insert age" and finish.
        else Toast message "Student info: 'name', 'age'".
         */
        if(pi!=null)
        {
            String name = pi.getStringExtra("ln");

            String age = pi.getStringExtra("la");
            if(name.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Please insert name", Toast.LENGTH_LONG).show();
                finish();
            }
            else if(age.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Please insert age", Toast.LENGTH_LONG).show();
                finish();
            }
            else
                Toast.makeText(getApplicationContext(), "Student info: "+name+", " +age, Toast.LENGTH_LONG).show();
        }
        /*
        If button clicked, return to main.
         */
        button0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }

        });
    }
}
