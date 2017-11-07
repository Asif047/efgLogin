package com.nanotech.DiscoverBangladesh.ShowDistrict;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by encrypt on 10/10/17.
 */

public class ShowDistrict {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("division_id")
    @Expose
    private Integer divisionId;
    @SerializedName("district_name")
    @Expose
    private String districtName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


}
