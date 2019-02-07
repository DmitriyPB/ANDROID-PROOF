package com.testing.android.proof.presentation.specialtylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testing.android.proof.R;
import com.testing.android.proof.domain.specialtylist.SpecialtyItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public final class SpecialtyListAdapter extends ListAdapter<SpecialtyItem, SpecialtyListAdapter.SpecialtyViewHolder> {

    private final OnSpecialtyClickListener clickListener;

    public SpecialtyListAdapter(@NonNull OnSpecialtyClickListener clickListener) {
        super(new SpecialtyItemDiffCallback());
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SpecialtyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SpecialtyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_specialty, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialtyViewHolder specialtyViewHolder, int position) {
        specialtyViewHolder.bind(getItem(position));
    }

    private static class SpecialtyItemDiffCallback extends DiffUtil.ItemCallback<SpecialtyItem> {
        @Override
        public boolean areItemsTheSame(@NonNull SpecialtyItem specialtyItem, @NonNull SpecialtyItem anotherSpecialtyItem) {
            return specialtyItem.getName().equals(anotherSpecialtyItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SpecialtyItem specialtyItem, @NonNull SpecialtyItem anotherSpecialtyItem) {
            return specialtyItem.equals(anotherSpecialtyItem);
        }
    }

    class SpecialtyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewSpecialtyName;
        private SpecialtyItem specialtyItem;

        SpecialtyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSpecialtyName = itemView.findViewById(R.id.text_view_specialty_item_name);
            itemView.setOnClickListener(v -> {
                if (specialtyItem != null) {
                    clickListener.onSpecialtyClicked(specialtyItem);
                }
            });
        }

        void bind(@Nullable final SpecialtyItem specialtyItem) {
            this.specialtyItem = specialtyItem;
            if (specialtyItem != null) {
                textViewSpecialtyName.setText(specialtyItem.getName());
            } else {
                textViewSpecialtyName.setText("");
            }
        }
    }

    public interface OnSpecialtyClickListener {
        void onSpecialtyClicked(@NonNull SpecialtyItem specialtyItem);
    }
}
