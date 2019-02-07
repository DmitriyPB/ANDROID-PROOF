package com.testing.android.proof.data.specialtylist.employeeservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeServiceClient {

    @GET("/65gb/static/raw/master/testTask.json")
    Call<EmployeeServiceResponse> fetchEmployeeData();
}
