package com.company.TestManager.TestAPIs._18GetListBids.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._18GetListBids.GetListBidsResponse;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Connection;

import java.io.IOException;

public class GetListBidsUnitTest1 extends UnitTest  {

    public GetListBidsUnitTest1(Test test){super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted Bids");}

    @Override
    public void test() throws IOException{
        this.params.put("index", "0");
        this.params.put("count","10");

        GetListBidsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, GetListBidsResponse.class, null);

        this.assertion.assertNotEquals(res,null);
        this.assertion.assertEquals(res.code,1000);
        this.assertion.assertNotEquals(res.message, null);
        this.assertion.assertNotEquals(res.data,null);
        this.assertion.assertNotEquals(res.data.total, null);




    }
}

