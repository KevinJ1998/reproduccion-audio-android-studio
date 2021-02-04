package com.example.reproduciraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button b5;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b5=(Button) findViewById(R.id.button5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        if(id==R.id.action_sttings){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public void destroy(){
        if(mp!=null){
            mp.release();
        }
    }
    public void init(View view){
        destroy();
        mp = MediaPlayer.create(this,R.raw.cancion);
        mp.start();
        String op = b5.getText().toString();
        if(op.equals("no reproducir en forma circular")){
            mp.setLooping(false);
        } else {
            mp.setLooping(true);
        }
    }

    public void pause(View view){
        if(mp!=null && mp.isPlaying()){
            position = mp.getCurrentPosition();
            mp.pause();
        }
    }
    // método continuar
    public void cont(View view){
        if(mp!=null && mp.isPlaying() == false){
            mp.seekTo(position);
            mp.start();
        }
    }

    public void stop(View view){
        if(mp !=null){
            mp.stop();
            position = 0;
        }
    }

    public void circle(View view){
        stop(null);
        String op = b5.getText().toString();
        if(op.equals("no reproducir en forma circular")){
            b5.setText("reproducir en forma circular");
        } else {
            b5.setText("no reproducir en forma circular");
        }
    }
}