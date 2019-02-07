package com.testing.android.proof.presentation.employeelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public final class EmployeeListAdapter extends ListAdapter<EmployeeListItem, EmployeeListAdapter.EmployeeListItemViewHolder> {

    private final OnEmployeeListItemClickListener clickListener;
    private final Context context;

    public EmployeeListAdapter(@NonNull OnEmployeeListItemClickListener clickListener, Context context) {
        super(new EmployeeListItemItemDiffCallback());
        this.clickListener = clickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EmployeeListItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employee, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListItemViewHolder employeeListItemViewHolder, int position) {
        employeeListItemViewHolder.bind(getItem(position));
    }

    private static class EmployeeListItemItemDiffCallback extends DiffUtil.ItemCallback<EmployeeListItem> {
        @Override
        public boolean areItemsTheSame(@NonNull EmployeeListItem employeeListItem, @NonNull EmployeeListItem anotherEmployeeListItem) {
            return employeeListItem.getFullName().equals(anotherEmployeeListItem.getFullName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull EmployeeListItem employeeListItem, @NonNull EmployeeListItem anotherEmployeeListItem) {
            return employeeListItem.equals(anotherEmployeeListItem);
        }
    }

    class EmployeeListItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewEmployeeName;
        private final TextView textViewEmployeeAge;
        private EmployeeListItem employee;

        EmployeeListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEmployeeName = itemView.findViewById(R.id.text_view_employee_item_full_name);
            textViewEmployeeAge = itemView.findViewById(R.id.text_view_employee_item_age);
            itemView.setOnClickListener(v -> {
                if (employee != null) {
                    clickListener.onEmployeeListItemClicked(employee);
                }
            });
        }

        void bind(@Nullable final EmployeeListItem employeeListItem) {
            this.employee = employeeListItem;
            if (employeeListItem != null) {
                textViewEmployeeName.setText(employeeListItem.getFullName());
                textViewEmployeeAge.setText(context.getString(R.string.employee_item_age, employeeListItem.getAge()));
            } else {
                textViewEmployeeName.setText("");
                textViewEmployeeAge.setText("");
            }
        }
    }

    public interface OnEmployeeListItemClickListener {
        void onEmployeeListItemClicked(@NonNull EmployeeListItem employeeListItem);
    }
}
