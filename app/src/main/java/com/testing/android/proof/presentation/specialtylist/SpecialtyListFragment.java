package com.testing.android.proof.presentation.specialtylist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.testing.android.proof.R;
import com.testing.android.proof.domain.specialtylist.SpecialtyItem;
import com.testing.android.proof.utils.moxyandroidx.MvpAppCompatFragment;
import com.testing.android.proof.presentation.employeelist.EmployeeListFragment;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;

public final class SpecialtyListFragment extends MvpAppCompatFragment implements SpecialtyListView, SpecialtyListAdapter.OnSpecialtyClickListener {

    public static SpecialtyListFragment newInstance() {
        return new SpecialtyListFragment();
    }

    private SpecialtyListAdapter specialtyListAdapter;
    private RecyclerView specialtyListRecycler;

    @Inject
    Provider<SpecialtyListPresenter> presenterProvider;

    @InjectPresenter
    SpecialtyListPresenter presenter;

    @ProvidePresenter
    SpecialtyListPresenter providePresenter() {
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
        return inflater.inflate(R.layout.fragment_specialty_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        specialtyListAdapter = new SpecialtyListAdapter(this);
        specialtyListRecycler = view.findViewById(R.id.recycler_specialty_list);
        specialtyListRecycler.setAdapter(specialtyListAdapter);
    }

    @Override
    public void onDestroyView() {
        specialtyListAdapter = null;
        specialtyListRecycler = null;
        super.onDestroyView();
    }

    @Override
    public void applySpecialties(@NonNull List<SpecialtyItem> specialties) {
        specialtyListAdapter.submitList(specialties);
    }

    @Override
    public void showSpecialtiesLoadingError() {
        Toast.makeText(requireContext(), R.string.specialty_list_loading_failure_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSpecialtyClicked(@NonNull SpecialtyItem specialtyItem) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, EmployeeListFragment.newInstance(specialtyItem.getId()))
                .addToBackStack(null)
                .commit();
    }
}
