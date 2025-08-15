package com.mf.hotel.search.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {

    private int id;
    private String name;
    private String capacity;
    private String count;
    private List<String> conditions;

}
