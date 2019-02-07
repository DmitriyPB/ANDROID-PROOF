package com.testing.android.proof.presentation.employeelist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.testing.android.proof.R;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsFragment;
import com.testing.android.proof.utils.moxyandroidx.MvpAppCompatFragment;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;

public final class EmployeeListFragment extends MvpAppCompatFragment implements EmployeeListView, EmployeeListAdapter.OnEmployeeListItemClickListener {

    private static final String SPECIALTY_ID_KEY = "specialty_id_key";

    public static EmployeeListFragment newInstance(int specialtyId) {
        EmployeeListFragment employeeListFragment = new EmployeeListFragment();
        Bundle args = new Bundle();
        args.putInt(SPECIALTY_ID_KEY, specialtyId);
        employeeListFragment.setArguments(args);
        return employeeListFragment;
    }

    private EmployeeListAdapter employeeListAdapter;
    private RecyclerView employeeListRecycler;

    @Inject
    Provider<EmployeeListPresenter> presenterProvider;

    @InjectPresenter
    EmployeeListPresenter presenter;

    @ProvidePresenter
    EmployeeListPresenter providePresenter() {
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
        return inflater.inflate(R.layout.fragment_employee_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        employeeListAdapter = new EmployeeListAdapter(this, requireContext());
        employeeListRecycler = view.findViewById(R.id.recycler_employee_list);
        employeeListRecycler.setAdapter(employeeListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            presenter.loadEmployeeList(getSpecialtyId());
        }
    }

    @Override
    public void onDestroyView() {
        employeeListAdapter = null;
        employeeListRecycler = null;
        super.onDestroyView();
    }

    @Override
    public void applyEmployeeList(@Nullable List<EmployeeListItem> employeeList) {
        employeeListAdapter.submitList(employeeList);
    }

    @Override
    public void showLoadingError() {
        Toast.makeText(requireContext(), R.string.employee_list_loading_failure_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onEmployeeListItemClicked(@NonNull EmployeeListItem employeeListItem) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, EmployeeDetailsFragment.newInstance(employeeListItem.getEmployeeId()))
                .addToBackStack(null)
                .commit();
    }

    private int getSpecialtyId() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(SPECIALTY_ID_KEY);
        }
        throw new IllegalArgumentException("specialty id not found");
    }
}
