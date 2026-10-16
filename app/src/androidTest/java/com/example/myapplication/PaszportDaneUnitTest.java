package com.example.myapplication;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myapplication.ui.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PaszportDaneUnitTest {
    @Test
    public void klikniecieOk_PokazujeAlertZPoprawnymTekstem() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            onView(withId(R.id.editImie)).perform(typeText("Jan"));
            onView(withId(R.id.editNazwisko)).perform(typeText("Nowak"));
            onView(withId(R.id.radioPiwne)).perform(click());

            onView(withId(R.id.buttonOk)).perform(click());

            onView(withText("Jan Nowak kolor oczu piwne"))
                    .inRoot(isDialog())
                    .check(matches(isDisplayed()));
        }
    }
}