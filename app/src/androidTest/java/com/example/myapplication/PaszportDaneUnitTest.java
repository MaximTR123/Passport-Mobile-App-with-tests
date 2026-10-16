package com.example.myapplication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.myapplication.ui.DaneValidator;

import org.junit.Test;

public class PaszportDaneUnitTest {

    @Test
    public void imie_poprawne() {
        assertTrue(DaneValidator.czyImiePoprawne("Jan"));
        assertTrue(DaneValidator.czyImiePoprawne("Łukasz"));
        assertTrue(DaneValidator.czyImiePoprawne("  Anna  "));
    }

    @Test
    public void imie_niepoprawne() {
        assertFalse(DaneValidator.czyImiePoprawne(null));
        assertFalse(DaneValidator.czyImiePoprawne(""));
        assertFalse(DaneValidator.czyImiePoprawne("   "));
        assertFalse(DaneValidator.czyImiePoprawne("J"));
        assertFalse(DaneValidator.czyImiePoprawne("Jan1"));
        assertFalse(DaneValidator.czyImiePoprawne("Jan Maria"));
    }

    @Test
    public void nazwisko_poprawne() {
        assertTrue(DaneValidator.czyNazwiskoPoprawne("Nowak"));
        assertTrue(DaneValidator.czyNazwiskoPoprawne("Żółć"));
        assertTrue(DaneValidator.czyNazwiskoPoprawne("Kowalska-Nowak"));
    }

    @Test
    public void nazwisko_niepoprawne() {
        assertFalse(DaneValidator.czyNazwiskoPoprawne(null));
        assertFalse(DaneValidator.czyNazwiskoPoprawne(""));
        assertFalse(DaneValidator.czyNazwiskoPoprawne("N"));
        assertFalse(DaneValidator.czyNazwiskoPoprawne("Nowak2"));
        assertFalse(DaneValidator.czyNazwiskoPoprawne("-Nowak"));
        assertFalse(DaneValidator.czyNazwiskoPoprawne("Nowak-"));
    }
}