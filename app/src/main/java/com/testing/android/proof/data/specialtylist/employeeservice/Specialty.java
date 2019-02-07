
package com.testing.android.proof.data.specialtylist.employeeservice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Specialty {

    @SerializedName("specialty_id")
    @Expose
    private Integer specialtyId;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Specialty() {}

    public Specialty(Integer specialtyId, String name) {
        super();
        this.specialtyId = specialtyId;
        this.name = name;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
