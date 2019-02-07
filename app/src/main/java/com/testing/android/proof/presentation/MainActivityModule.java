package com.testing.android.proof.presentation;

import com.testing.android.proof.annotations.PerActivity;
import com.testing.android.proof.presentation.specialtylist.SpecialtyListFragment;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public final class MainActivityModule {
    @PerActivity
    @Provides
    Fragment provideInitialFragment() {
        return SpecialtyListFragment.newInstance();
    }
}
