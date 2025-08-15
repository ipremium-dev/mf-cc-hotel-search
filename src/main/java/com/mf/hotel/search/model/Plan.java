package com.mf.hotel.search.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plan {

    private int id;
    private String name;
    @SerializedName("room_id")
    private int roomId;
    private int price;
    private List<String> conditions;
    private List<Plan> plan;
}
