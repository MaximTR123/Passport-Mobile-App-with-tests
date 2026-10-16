package com.example.myapplication.ui;

public final class DaneValidator {

    private static final int MIN_DLUGOSC = 2;
    private static final int MAX_DLUGOSC = 50;

    private static final String IMIE_REGEX = "\\p{L}{" + MIN_DLUGOSC + "," + MAX_DLUGOSC + "}";
    private static final String NAZWISKO_REGEX = IMIE_REGEX + "(-" + IMIE_REGEX + ")?";

    private DaneValidator() {
    }

    public static boolean czyImiePoprawne(String imie) {
        return pasuje(imie, IMIE_REGEX);
    }

    public static boolean czyNazwiskoPoprawne(String nazwisko) {
        return pasuje(nazwisko, NAZWISKO_REGEX);
    }

    private static boolean pasuje(String tekst, String regex) {
        return tekst != null && tekst.trim().matches(regex);
    }
}