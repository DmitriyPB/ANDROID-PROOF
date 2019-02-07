package com.testing.android.proof.domain.specialtylist;

import java.util.List;

import io.reactivex.Single;

public interface SpecialtyListRepository {
    Single<List<Specialty>> loadSpecialties();
}
