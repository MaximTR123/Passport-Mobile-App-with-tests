package com.example.myapplication.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;

public class MainActivity extends Activity {

    private static final String PREFIX_ZDJECIE = "zdjecie_";
    private static final String PREFIX_ODCISK = "odcisk_";

    private EditText editNumer;
    private EditText editImie;
    private EditText editNazwisko;
    private RadioGroup groupKolorOczu;
    private ImageView imageZdjecie;
    private ImageView imageOdcisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        editNumer.setOnFocusChangeListener((widok, maFokus) -> {
            if (!maFokus) {
                aktualizujObrazy();
            }
        });

        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(widok -> pokazKomunikat());
    }

    private void findViews() {
        editNumer = findViewById(R.id.editNumer);
        editImie = findViewById(R.id.editImie);
        editNazwisko = findViewById(R.id.editNazwisko);
        groupKolorOczu = findViewById(R.id.groupKolorOczu);
        imageZdjecie = findViewById(R.id.imageZdjecie);
        imageOdcisk = findViewById(R.id.imageOdcisk);
    }

    private void aktualizujObrazy() {
        String numer = editNumer.getText().toString().trim();
        ustawObraz(imageZdjecie, PREFIX_ZDJECIE + numer);
        ustawObraz(imageOdcisk, PREFIX_ODCISK + numer);
    }

    private void ustawObraz(ImageView imageView, String nazwaZasobu) {
        int idZasobu = getResources().getIdentifier(nazwaZasobu, "drawable", getPackageName());

        if(idZasobu != 0) {
            imageView.setImageResource(idZasobu);
        } else {
            imageView.setImageDrawable(null);
        }
    }

    private void pokazKomunikat() {
        String imie = editImie.getText().toString().trim();
        String nazwisko = editNazwisko.getText().toString().trim();

        String tresc = "";

        if(imie.isEmpty() || nazwisko.isEmpty()) {
            tresc = "Wprowadz dane";
        } else {
            tresc = imie + " " + nazwisko + " kolor oczu " + pobierzKolorOczu();
        }

        new AlertDialog.Builder(this)
                .setMessage(tresc)
                .setPositiveButton("OK", null)
                .show();
    }

    private String pobierzKolorOczu() {
        RadioButton radioButton = findViewById(groupKolorOczu.getCheckedRadioButtonId());
        return radioButton.getText().toString();
    }
}