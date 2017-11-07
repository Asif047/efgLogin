package com.nanotech.DiscoverBangladesh.FeaturedPlaces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by encrypt on 10/17/17.
 */

public class FeaturedPlaces {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("place_name")
    @Expose
    private String placeName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("details")
    @Expose
    private String details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
