package com.github.juan1393.heroe;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.juan1393.heroe.data.exception.CharacterComicsNotFoundException;
import com.github.juan1393.heroe.data.exception.NetworkConnectionException;
import com.github.juan1393.heroe.ui.activity.ComicsActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Juan Gómez on 12/2/17.
 */

@RunWith(AndroidJUnit4.class)
public class ComicsActivityTest {

    @Before
    public void initialize() throws NetworkConnectionException, CharacterComicsNotFoundException {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public ActivityTestRule<ComicsActivity> comicsActivityTestRule =
            new ActivityTestRule<>(ComicsActivity.class);

    @Test
    public void progressWheelIsShownWhenActivityStarts()
            throws NetworkConnectionException, CharacterComicsNotFoundException {
        onView(withId(R.id.progress_wheel)).check(matches(isDisplayed()));
    }

    @Test
    public void comicsAreShownInScreen() throws InterruptedException {
        Thread.sleep(4000);
        onView(withId(R.id.comic_list)).check(matches(isDisplayed()));
    }

    @Test
    public void comicDetailActivityIsShownWhenClickOnComicItem() throws InterruptedException {
        Thread.sleep(4000);
        onView(withId(R.id.comic_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        Thread.sleep(4000);
        onView(withId(R.id.comic_detail_image)).check(matches(isDisplayed()));
    }
}
