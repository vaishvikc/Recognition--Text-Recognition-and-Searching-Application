package com.example.android.recognition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnVoice,btnText,btnBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice=(Button)findViewById(R.id.voice_btn);
        btnText=(Button)findViewById(R.id.txt_btn);
        btnBar=(Button)findViewById(R.id.hand_btn);

        btnVoice.setOnClickListener(this);
        btnBar.setOnClickListener(this);
        btnText.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.about){
            Intent aboutIntent=new Intent(MainActivity.this,aboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.voice_btn:
                Intent voiceIntent=new Intent(MainActivity.this,voiceActivity.class);
                startActivity(voiceIntent);
                break;
            case R.id.txt_btn:
                Intent textIntent=new Intent(MainActivity.this,textActivity.class);
                startActivity(textIntent);
                break;
            case R.id.hand_btn:
                Intent handIntent=new Intent(MainActivity.this,barActivity.class);
                startActivity(handIntent);
                break;
        }
    }
}
