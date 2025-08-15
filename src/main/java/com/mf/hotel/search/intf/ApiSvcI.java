package com.mf.hotel.search.intf;

import com.mf.hotel.search.model.SearchParam;

//API Service Interface
public interface ApiSvcI {

    String callGet(SearchParam searchParam, String uuid);

}
