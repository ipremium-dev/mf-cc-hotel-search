package com.mf.hotel.search.service;

import com.mf.hotel.search.intf.SearchSvcI;
import com.mf.hotel.search.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSvc implements SearchSvcI {
    @Override
    public String result(List<Hotel> hotelList, int planId) {

        if(!checkPlanId(hotelList,planId)){
            return "Plan not found\n";
        }

        return "";
    }
}
