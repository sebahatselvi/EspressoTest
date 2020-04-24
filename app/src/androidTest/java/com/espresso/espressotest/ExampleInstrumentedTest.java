package com.espresso.espressotest;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.espresso.espressotest", appContext.getPackageName());
    }

    @Before()
    public void before() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Test
    public void clickDashboardButton() throws InterruptedException {

        //navigation butonuna tıklanır
        Espresso.onView(ViewMatchers.withId(R.id.navigation_dashboard)).perform(ViewActions.click());

        //text değeri doğrulanır
        Espresso.onView(ViewMatchers.withId(R.id.text_dashboard))
                .check(ViewAssertions.matches(ViewMatchers.withText("This is dashboard fragment")));

        // Geri home  dönülür
        Espresso.pressBack();

       // Home text değeri doğrulanır
        Espresso.onView(ViewMatchers.withId(R.id.text_home))
                .check(ViewAssertions.matches(ViewMatchers.withText("This is home fragment")));
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        // uygulama kapatılır
        activityActivityTestRule.finishActivity();

    }

}
