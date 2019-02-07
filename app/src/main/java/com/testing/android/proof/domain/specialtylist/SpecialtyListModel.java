package com.testing.android.proof.domain.specialtylist;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public final class SpecialtyListModel implements SpecialtyListInteractor {
    private final SpecialtyListRepository repository;
    private final SpecialtiesMapper specialtyMapper;

    @Inject
    public SpecialtyListModel(SpecialtyListRepository repository, SpecialtiesMapper specialtyMapper) {
        this.repository = repository;
        this.specialtyMapper = specialtyMapper;
    }

    @Override
    public Single<List<SpecialtyItem>> loadSpecialties() {
        return repository.loadSpecialties()
                .map(specialtyMapper::toSpecialtiesItems);
    }
}
