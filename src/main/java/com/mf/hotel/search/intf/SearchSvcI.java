package com.mf.hotel.search.intf;

import com.mf.hotel.search.model.Hotel;
import com.mf.hotel.search.model.Plan;

import java.util.List;

public interface SearchSvcI {

    default boolean checkPlanId(List<Hotel> hotelList, int planId){
        boolean exist = false;

        for(Hotel hotel: hotelList){
            for(List<Plan> planlist: hotel.getPlans()){
                for(Plan plan: planlist){
                    if(plan.getId() == planId){
                        exist = true;
                        break;
                    }
                }
            }
        }

        return exist;
    }

    String result(List<Hotel> hotelList, int planId);

}
