package com.testing.android.proof.data.specialtylist;

import com.testing.android.proof.data.specialtylist.employeeservice.EmployeeServiceClient;
import com.testing.android.proof.data.specialtylist.employeeservice.EmployeeServiceResponse;

import java.io.IOException;

public final class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeServiceClient client;

    public EmployeeServiceImpl(EmployeeServiceClient client) {this.client = client;}

    @Override
    public EmployeeServiceResponse fetchEmployeeServiceResponse() {
        try {
            return client.fetchEmployeeData().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
