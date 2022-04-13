package com.example.high_or_low;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void randomNumberGenerator()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }


    public void onGuess(View view) {
        String message = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if (guessedNumber < 1 || guessedNumber > 20) {
                message = "Masukan angka 1 sampai 20";
            } else if (guessedNumber < randomNumber) {
                message = "Angka terlalu rendah";
            } else if (guessedNumber > randomNumber) {
                message = "Angka  terlalu tinggi";
            }else {
                message = "You Got Me !!!";
                randomNumberGenerator();
            }
        } catch (Exception e){
            message = "tidak boleh kosong";
        } finally {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //untuk batas sampai 20

    }
}