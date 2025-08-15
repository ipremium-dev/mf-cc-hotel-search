package com.mf.hotel.search;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mf.hotel.search.intf.ApiSvcI;
import com.mf.hotel.search.intf.SearchSvcI;
import com.mf.hotel.search.model.Hotel;
import com.mf.hotel.search.model.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CliRunner implements CommandLineRunner{

    @Autowired
    ApiSvcI apiSvc;

    @Autowired
    SearchSvcI searchSvc;

    @Override
    public void run(String... args) throws Exception {
        if(args.length < 2){
            System.out.println("Unable to proceed");
            System.exit(0);
        }

        String strUUID = args[0].trim();
        String jsonParam = args[1].trim();

		SearchParam sp = new Gson().fromJson(jsonParam,SearchParam.class);

        String responseString = apiSvc.callGet(sp,strUUID);

        List<Hotel> hotelList = new Gson().fromJson(responseString,new TypeToken<List<Hotel>>(){}.getType());
        System.out.println(searchSvc.result(hotelList, sp.getPlanId()));
    }
}
