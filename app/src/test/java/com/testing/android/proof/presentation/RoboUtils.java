package com.testing.android.proof.presentation;

import com.testing.android.proof.utils.testing.activity.TestingActivity;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

public final class RoboUtils {

    @SuppressWarnings("UnusedReturnValue")
    public static ActivityController<TestingActivity> startTestingActivity() {
        return Robolectric.buildActivity(TestingActivity.class).create().visible().start();
    }
}
