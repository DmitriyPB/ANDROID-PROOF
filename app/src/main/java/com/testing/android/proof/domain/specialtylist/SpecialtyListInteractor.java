package com.testing.android.proof.domain.specialtylist;

import java.util.List;

import io.reactivex.Single;

public interface SpecialtyListInteractor {
    Single<List<SpecialtyItem>> loadSpecialties();
}
