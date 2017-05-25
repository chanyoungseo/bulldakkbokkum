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
    static final String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    private MediaPlayer mediaPlayer;
    Context context;
    private int playbackPosition = 0;
    LinearLayout layout, layout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        layout = (LinearLayout)findViewById(R.id.audio1);
        layout2 = (LinearLayout)findViewById(R.id.audio2);
        String tag =(String)layout.getTag();
        int id_audio = getResources().getIdentifier(tag,"raw",getPackageName());
        /*layout.setOnClickListener(new View.OnClickListener() {
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
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    public void play(View v)
    {
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
    private void playAudio(String url) throws Exception {
        killMediaPlayer();

        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    protected void onDestroy(){
        super.onDestroy();
        killMediaPlayer();
    }

    private void killMediaPlayer(){
        if(mediaPlayer!=null){
            try{mediaPlayer.release();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

