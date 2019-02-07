
package com.testing.android.proof.data.specialtylist.employeeservice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class EmployeeServiceResponse {

    @SerializedName("response")
    @Expose
    private List<Response> response = null;

    /**
     * No args constructor for use in serialization
     */
    public EmployeeServiceResponse() {}

    public EmployeeServiceResponse(List<Response> response) {
        super();
        this.response = response;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

}
