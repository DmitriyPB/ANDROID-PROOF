package com.testing.android.proof.data;

import android.content.Context;

import com.testing.android.proof.data.database.ProofDB;
import com.testing.android.proof.data.database.dao.EmployeeDao;
import com.testing.android.proof.data.database.dao.EmployeeSpecialtyRelationDao;
import com.testing.android.proof.data.database.dao.SpecialtyDao;
import com.testing.android.proof.data.employeedetails.EmployeeDetailsDataModule;
import com.testing.android.proof.data.employeelist.EmployeeListDataModule;
import com.testing.android.proof.data.specialtylist.EmployeeService;
import com.testing.android.proof.data.specialtylist.EmployeeServiceImpl;
import com.testing.android.proof.data.specialtylist.SpecialtyListDataModule;
import com.testing.android.proof.data.specialtylist.employeeservice.EmployeeServiceClient;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.testing.android.proof.data.database.ProofDB.DATABASE_NAME;

@Module(includes = {
        SpecialtyListDataModule.class,
        EmployeeListDataModule.class,
        EmployeeDetailsDataModule.class
})
public final class DataModule {
    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://gitlab.65apps.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    ProofDB provideRoomDb(Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), ProofDB.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    EmployeeDao provideEmployeeDao(ProofDB db) {
        return db.employeeDao();
    }

    @Provides
    SpecialtyDao provideSpecialtyDao(ProofDB db) {
        return db.specialtyDao();
    }

    @Provides
    EmployeeSpecialtyRelationDao provideEmployeeSpecialtyRelationDao(ProofDB db) {
        return db.employeeSpecialtyRelationDao();
    }

    @Singleton
    @Provides
    EmployeeService provideEmployeeService(EmployeeServiceClient client) {
        return new EmployeeServiceImpl(client);
    }

    @Singleton
    @Provides
    EmployeeServiceClient provideEmployeeServiceClient(Retrofit retrofit) {
        return retrofit.create(EmployeeServiceClient.class);
    }
}
