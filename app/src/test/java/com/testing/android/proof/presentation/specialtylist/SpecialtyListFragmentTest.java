package com.testing.android.proof.presentation.specialtylist;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.specialtylist.SpecialtyItem;
import com.testing.android.proof.presentation.employeelist.EmployeeListFragment;
import com.testing.android.proof.presentation.employeelist.EmployeeListFragmentInjector;
import com.testing.android.proof.presentation.employeelist.EmployeeListPresenter;
import com.testing.android.proof.utils.testing.TestingApplication;
import com.testing.android.proof.utils.testing.activity.TestingActivity;
import com.testing.android.proof.utils.testing.activity.TestingActivityAndroidInjectorBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ApplicationProvider;

import static com.testing.android.proof.presentation.RoboUtils.startTestingActivity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(application = TestingApplication.class)
@RunWith(RobolectricTestRunner.class)
public final class SpecialtyListFragmentTest {

    private SpecialtyListView view;

    @Mock
    SpecialtyListPresenter mockPresenter;
    @Mock
    EmployeeListPresenter mockEmployeePresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        SpecialtyListFragment fragment = SpecialtyListFragment.newInstance();
        this.view = fragment;
        ((TestingApplication) ApplicationProvider.getApplicationContext()).activityDispatchingAndroidInjector =
                TestingActivityAndroidInjectorBuilder
                        .create(() -> fragment)
                        .addFragmentInjector(SpecialtyListFragment.class, new SpecialtyListFragmentInjector(mockPresenter))
                        .addFragmentInjector(EmployeeListFragment.class, new EmployeeListFragmentInjector(mockEmployeePresenter))
                        .build();
    }

    @Test
    public void testApplySpecialties() {
        TestingActivity activity = startTestingActivity().get();
        List<SpecialtyItem> specialties = Arrays.asList(
                new SpecialtyItem(1, "pilot"),
                new SpecialtyItem(2, "chef")
        );
        RecyclerView specialtyListRecycler = activity.findViewById(R.id.recycler_specialty_list);
        assertEquals(0, specialtyListRecycler.getChildCount());
        view.applySpecialties(specialties);

        assertEquals(specialties.size(), specialtyListRecycler.getChildCount());
    }

    @Test
    public void testClickOnSpecialty() {
        TestingActivity activity = startTestingActivity().get();
        List<SpecialtyItem> specialties = Arrays.asList(
                new SpecialtyItem(1, "pilot"),
                new SpecialtyItem(2, "chef")
        );

        view.applySpecialties(specialties);
        RecyclerView specialtyListRecycler = activity.findViewById(R.id.recycler_specialty_list);
        specialtyListRecycler.getChildAt(0).performClick();

        assertNotNull(activity.findViewById(R.id.recycler_employee_list));
    }
}