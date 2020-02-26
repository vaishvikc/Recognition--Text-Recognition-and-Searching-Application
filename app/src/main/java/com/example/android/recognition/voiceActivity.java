package com.example.android.recognition;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class voiceActivity extends AppCompatActivity {

    TextView voiceInput;
    Button voiceSearch;
    ImageView btn;
    final int REQ_CODE_VOICE_INPUT=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        voiceSearch=(Button)findViewById(R.id.voiceSearch_btn);
        voiceSearch.setVisibility(View.INVISIBLE);
        voiceInput=(TextView)this.findViewById(R.id.tv);
        btn=(ImageView)findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please speak something..!");

                try {
                    startActivityForResult(intent, REQ_CODE_VOICE_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Your Device doesn't support Speech Input", Toast.LENGTH_SHORT).show();

                }

            }

        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100)
        {

            if(data != null){
                ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                voiceInput.setText(result.get(0));
                voiceSearch.setVisibility(View.VISIBLE);
                voiceSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri=Uri.parse("http://google.com/search?").buildUpon()
                                .appendQueryParameter("q",voiceInput.getText().toString())
                                .build();

                        Intent vcSearchIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()));
                        startActivity(vcSearchIntent);
                    }
                    });
            }

        }
    }
}
