package com.mf.hotel.search.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Hotel {

    private int id;
    private String name;
    private int prefecture;
    private String address;
    private List<String> conditions;
    private List<Room> rooms;
    private List<List<Plan>> plans;

}
