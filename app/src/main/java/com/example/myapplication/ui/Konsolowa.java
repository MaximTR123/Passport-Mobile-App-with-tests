package com.example.myapplication.ui;

import java.util.Scanner;

public class Konsolowa {

    private static final int[] WAGI = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    public static char sprawdzPlec(String pesel) {
        int cyfraPlci = pesel.charAt(9) - '0';
        return (cyfraPlci % 2 == 0) ? 'K' : 'M';
    }

    public static boolean sprawdzSumeKontrolna(String pesel) {
        int S = 0;

        for (int i = 0; i < 10; i++) {
            S += (pesel.charAt(i) - '0') * WAGI[i];
        }

        int M = S % 10;

        int R = (M == 0) ? 0 : 10 - M;

        int jedenastaCyfra = pesel.charAt(10) - '0';

        return R == jedenastaCyfra;
    }

    private static boolean czyFormatPoprawny(String pesel) {
        return pesel.matches("\\d{11}");
    }

    public static void main(String[] args) {
        String pesel = "55030101193";
        Scanner skaner = new Scanner(System.in);

        System.out.print("Podaj numer PESEl (Enter = " + pesel + "): ");
        String wczytany = skaner.nextLine().trim();

        if(!wczytany.isEmpty()) {
            pesel = wczytany;
        }

        if(!czyFormatPoprawny(pesel)) {
            System.out.println("Bledny format: PESEL musi miec dokladnie 11 cyfr.");
            return;
        }

        char plec = sprawdzPlec(pesel);
        System.out.println("Plec: " + (plec == 'K' ? "Kobieta" : "Mezczyzna"));

        if(sprawdzSumeKontrolna(pesel)) {
            System.out.println("Suma kontrolna jest zgodna.");
        } else {
            System.out.println("Suma kontrolna jest nie zgodna.");
        }
    }
}
