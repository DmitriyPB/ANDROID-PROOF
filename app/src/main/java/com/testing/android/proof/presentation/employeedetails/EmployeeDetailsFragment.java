package com.testing.android.proof.presentation.employeedetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.testing.android.proof.R;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsItem;
import com.testing.android.proof.utils.moxyandroidx.MvpAppCompatFragment;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dagger.android.support.AndroidSupportInjection;

public final class EmployeeDetailsFragment extends MvpAppCompatFragment implements EmployeeDetailsView {

    private static final String EMPLOYEE_ID_KEY = "employee_id_key";
    private TextView textViewForename;
    private TextView textViewSurname;
    private TextView textViewBirthdate;
    private TextView textViewAge;
    private TextView textViewSpecialty;

    public static EmployeeDetailsFragment newInstance(int employeeId) {
        EmployeeDetailsFragment employeeDetailsFragment = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(EMPLOYEE_ID_KEY, employeeId);
        employeeDetailsFragment.setArguments(args);
        return employeeDetailsFragment;
    }

    @Inject
    Provider<EmployeeDetailsPresenter> presenterProvider;

    @InjectPresenter
    EmployeeDetailsPresenter presenter;

    @ProvidePresenter
    EmployeeDetailsPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewForename = view.findViewById(R.id.text_view_employee_details_forename);
        textViewSurname = view.findViewById(R.id.text_view_employee_details_surname);
        textViewBirthdate = view.findViewById(R.id.text_view_employee_details_birthdate);
        textViewAge = view.findViewById(R.id.text_view_employee_details_age);
        textViewSpecialty = view.findViewById(R.id.text_view_employee_details_specialty);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            presenter.loadEmployeeDetails(getEmployeeId());
        }
    }

    @Override
    public void onDestroyView() {
        textViewForename = null;
        textViewSurname = null;
        textViewBirthdate = null;
        textViewAge = null;
        textViewSpecialty = null;
        super.onDestroyView();
    }

    @Override
    public void applyEmployeeDetails(@NonNull EmployeeDetailsItem employeeDetailsItem) {
        textViewForename.setText(employeeDetailsItem.getName());
        textViewSurname.setText(employeeDetailsItem.getSurname());
        textViewBirthdate.setText(employeeDetailsItem.getBirthdate());
        textViewAge.setText(employeeDetailsItem.getAge());
        textViewSpecialty.setText(employeeDetailsItem.getSpecialty());
    }

    @Override
    public void showEmployeeDetailsLoadingFailed() {
        Toast.makeText(requireContext(), R.string.employee_details_loading_failure_message, Toast.LENGTH_LONG).show();
    }

    private int getEmployeeId() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(EMPLOYEE_ID_KEY);
        }
        throw new IllegalArgumentException("employee id not found");
    }
}
