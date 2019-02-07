package com.testing.android.proof.domain.specialtylist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class SpecialtiesMapper {

    @Inject
    public SpecialtiesMapper() {
    }

    List<SpecialtyItem> toSpecialtiesItems(List<Specialty> specialties) {
        List<SpecialtyItem> items = new ArrayList<>(specialties.size());
        for (Specialty specialty : specialties) {
            items.add(new SpecialtyItem(specialty.getId(), specialty.getName()));
        }
        return items;
    }
}
