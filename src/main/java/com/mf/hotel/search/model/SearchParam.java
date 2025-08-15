package com.mf.hotel.search.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchParam {

    private String keyword;
    @SerializedName("plan_id")
    private int planId;
    private String checkin;
    private String checkout;
    private  int number;

}
