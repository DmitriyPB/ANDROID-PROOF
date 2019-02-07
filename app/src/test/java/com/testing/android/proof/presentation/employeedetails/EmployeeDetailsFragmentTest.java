package com.testing.android.proof.presentation.employeedetails;

import android.widget.TextView;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsItem;
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

import androidx.test.core.app.ApplicationProvider;

import static com.testing.android.proof.presentation.RoboUtils.startTestingActivity;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@Config(application = TestingApplication.class)
@RunWith(RobolectricTestRunner.class)
public final class EmployeeDetailsFragmentTest {

    private final int employeeId = 668;
    private EmployeeDetailsView view;
    private EmployeeDetailsFragment fragment;

    @Mock
    EmployeeDetailsPresenter mockPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.fragment = EmployeeDetailsFragment.newInstance(employeeId);
        this.view = fragment;
        ((TestingApplication) ApplicationProvider.getApplicationContext()).activityDispatchingAndroidInjector =
                TestingActivityAndroidInjectorBuilder
                        .create(() -> fragment)
                        .addFragmentInjector(EmployeeDetailsFragment.class, new EmployeeDetailsFragmentInjector(mockPresenter))
                        .build();
    }

    @Test
    public void testLoadSpecialtiesPresenterCall() {
        startTestingActivity();

        verify(mockPresenter).loadEmployeeDetails(employeeId);
    }

    @Test
    public void testApplyEmployeeDetails() {
        TestingActivity activity = startTestingActivity().get();
        String name = "name";
        String surname = "surname";
        String birthdate = "birthdate";
        String age = "age";
        String specialty = "specialty";
        view.applyEmployeeDetails(new EmployeeDetailsItem(name, surname, birthdate, age, specialty));

        TextView forenameField = activity.findViewById(R.id.text_view_employee_details_forename);
        TextView surnameField = activity.findViewById(R.id.text_view_employee_details_surname);
        TextView birthdateField = activity.findViewById(R.id.text_view_employee_details_birthdate);
        TextView ageField = activity.findViewById(R.id.text_view_employee_details_age);
        TextView specialtyField = activity.findViewById(R.id.text_view_employee_details_specialty);
        assertEquals(name, forenameField.getText().toString());
        assertEquals(surname, surnameField.getText().toString());
        assertEquals(birthdate, birthdateField.getText().toString());
        assertEquals(age, ageField.getText().toString());
        assertEquals(specialty, specialtyField.getText().toString());
    }
}