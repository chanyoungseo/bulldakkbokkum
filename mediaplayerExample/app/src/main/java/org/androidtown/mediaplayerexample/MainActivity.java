package org.androidtown.mediaplayerexample;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    Context context;
    LinearLayout layout, layout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        layout = (LinearLayout)findViewById(R.id.audio1);
        layout2 = (LinearLayout)findViewById(R.id.audio2);
        String tag =(String)layout.getTag();
        // set layout onClickListener
        /*layout.setOnClickListener(new View.OnClickListener() {
            // Play music1 and change layout background color
            @Override
            public void onClick(View v) {
                String tag =(String)layout.getTag();
                layout.setBackgroundColor(Color.GRAY);
                layout2.setBackgroundColor(Color.WHITE);
                if(mediaPlayer!=null)
                {
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer = MediaPlayer.create(context,R.raw.music1);
                mediaPlayer.start();
            }
        });
        // set layout2 onClickListener
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Play music2 and change layout2 background color
                layout2.setBackgroundColor(Color.GRAY);
                layout.setBackgroundColor(Color.WHITE);
                if(mediaPlayer!=null)
                {
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer = MediaPlayer.create(context,R.raw.music2);
                mediaPlayer.start();
            }
        });*/
    }
    // Get onClick to xml
    public void play(View v)
    {
        // get tag and if equal "music1", play music1 and change layout background color
        if(v.getTag().equals("music1"))
        {
            layout.setBackgroundColor(Color.GRAY);
            layout2.setBackgroundColor(Color.WHITE);
            if(mediaPlayer!=null)
            {
                mediaPlayer.release();
                mediaPlayer=null;
            }
            mediaPlayer = MediaPlayer.create(context,R.raw.music1);
            mediaPlayer.start();
        }
        // get tag and if equal "music2", play music2 and change layout2 background color
        else if(v.getTag().equals("music2"))
        {
            layout2.setBackgroundColor(Color.GRAY);
            layout.setBackgroundColor(Color.WHITE);
            if(mediaPlayer!=null)
            {
                mediaPlayer.release();
                mediaPlayer=null;
            }
            mediaPlayer = MediaPlayer.create(context,R.raw.music2);
            mediaPlayer.start();
        }
    }
}

