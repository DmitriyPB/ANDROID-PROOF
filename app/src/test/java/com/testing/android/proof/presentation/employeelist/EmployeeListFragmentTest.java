package com.testing.android.proof.presentation.employeelist;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsFragment;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsFragmentInjector;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsPresenter;
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
import static org.mockito.Mockito.verify;

@Config(application = TestingApplication.class)
@RunWith(RobolectricTestRunner.class)
public final class EmployeeListFragmentTest {

    private EmployeeListFragment fragment;
    private EmployeeListView view;
    private final int specialtyId = 666;

    @Mock
    EmployeeListPresenter mockPresenter;
    @Mock
    EmployeeDetailsPresenter mockEmployeeDetailsPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.fragment = EmployeeListFragment.newInstance(specialtyId);
        this.view = fragment;
        ((TestingApplication) ApplicationProvider.getApplicationContext()).activityDispatchingAndroidInjector =
                TestingActivityAndroidInjectorBuilder
                        .create(() -> fragment)
                        .addFragmentInjector(EmployeeListFragment.class, new EmployeeListFragmentInjector(mockPresenter))
                        .addFragmentInjector(EmployeeDetailsFragment.class, new EmployeeDetailsFragmentInjector(mockEmployeeDetailsPresenter))
                        .build();
    }

    @Test
    public void testLoadSpecialtiesPresenterCall() {
        startTestingActivity();

        verify(mockPresenter).loadEmployeeList(specialtyId);
    }

    @Test
    public void testApplyEmployeeList() {
        TestingActivity activity = startTestingActivity().get();
        List<EmployeeListItem> employeeList = Arrays.asList(
                new EmployeeListItem(1, "Фёдор Кепочков", "20"),
                new EmployeeListItem(2, "Игнат Машинный", "73")
        );

        RecyclerView employeeListRecycler = activity.findViewById(R.id.recycler_employee_list);
        assertEquals(0, employeeListRecycler.getChildCount());
        view.applyEmployeeList(employeeList);

        assertEquals(employeeList.size(), employeeListRecycler.getChildCount());
    }

    @Test
    public void testClickOnEmployeeItem() {
        TestingActivity activity = startTestingActivity().get();
        List<EmployeeListItem> employeeList = Arrays.asList(
                new EmployeeListItem(1, "Фёдор Кепочков", "20"),
                new EmployeeListItem(2, "Игнат Машинный", "73")
        );

        view.applyEmployeeList(employeeList);
        RecyclerView employeeListRecycler = activity.findViewById(R.id.recycler_employee_list);
        employeeListRecycler.getChildAt(0).performClick();

        assertNotNull(activity.findViewById(R.id.text_view_employee_details_forename));
    }
}