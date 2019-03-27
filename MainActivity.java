package com.example.hp.androidmp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView text1, text2;
    ImageButton ımgbt1, ımgbt2, ımgbt3;
    String[] sarkilar = { "Unutamadım Adını", "Kahrolsun Dünya"};
    String[] sureler = { "4.00", "2.00"};

    MediaPlayer mediaPlayer;
    int sayac=0;

    private void metot1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.hk);
    }

    private void metot2() {
        mediaPlayer = MediaPlayer.create(this, R.raw.ck);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        ımgbt1 = findViewById(R.id.ımgbt1);
        ımgbt2 = findViewById(R.id.ımgbt2);
        ımgbt3 = findViewById(R.id.imgbt3);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, sarkilar);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                text1.setText(spinner.getSelectedItem().toString());
                text2.setText(sureler[spinner.getSelectedItemPosition()]);

                if (spinner.getSelectedItemPosition() == 0) {
                    if (sayac>0)
                    {mediaPlayer.pause();}
                    metot1();

                } else if (spinner.getSelectedItemPosition() == 1) {
                sayac++;
                    mediaPlayer.pause();
                    metot2();
                }


                ımgbt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mediaPlayer.isPlaying() == false) {

                            mediaPlayer.start();
                        }

                    }
                });
                ımgbt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.pause();
                    }
                });
                ımgbt3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        if (spinner.getSelectedItemPosition() == 0) {
                            metot1();
                        } else if (spinner.getSelectedItemPosition() == 1) {
                            metot2();
                        }

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }
}

