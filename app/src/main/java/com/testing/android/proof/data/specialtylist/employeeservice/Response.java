
package com.testing.android.proof.data.specialtylist.employeeservice;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Response {

    @SerializedName("f_name")
    @Expose
    private String fName;
    @SerializedName("l_name")
    @Expose
    private String lName;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("avatr_url")
    @Expose
    private String avatrUrl;
    @SerializedName("specialty")
    @Expose
    private List<Specialty> specialty = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    public Response(String fName, String lName, String birthday, String avatrUrl, List<Specialty> specialty) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.avatrUrl = avatrUrl;
        this.specialty = specialty;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatrUrl() {
        return avatrUrl;
    }

    public void setAvatrUrl(String avatrUrl) {
        this.avatrUrl = avatrUrl;
    }

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }

}
