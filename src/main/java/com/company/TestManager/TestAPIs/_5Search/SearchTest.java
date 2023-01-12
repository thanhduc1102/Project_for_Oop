package com.company.TestManager.TestAPIs._5Search;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Objects.Auction;
import com.company.TestManager.Objects.Item;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._10GetDetailsAuctions.GetDetailsAuctionsResponse;
import com.company.TestManager.TestAPIs._5Search.UnitTests.*;
import com.company.TestManager.TestAPIs._6GetListAuctions.GetListAuctionsResponse;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SearchTest extends Test {
    public static Auction testAuctionData;
    public static Item testItemData;

    public SearchTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new SearchUnitTest1(this),
                new SearchUnitTest2(this),
                new SearchUnitTest3(this),
                new SearchUnitTest4(this),
                new SearchUnitTest5(this),
                new SearchUnitTest6(this),
                new SearchUnitTest7(this),
                new SearchUnitTest8(this)
        ));
    }

    @Override
    protected void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("index", "2");
        tempParams.put("count", "1");
        GetListAuctionsResponse res = Connection.sendGetRequest(this.baseURLString + "/" + EndpointConstants.GET_LIST_AUCTIONS, tempParams, GetListAuctionsResponse.class, null);
        GetDetailsAuctionsResponse res2 = Connection.sendGetRequest(this.baseURLString + "/" + EndpointConstants.GET_DETAILS_AUCTIONS + "/" + res.data.auctions.get(0).auction_id, null, GetDetailsAuctionsResponse.class, null);
        SearchTest.testAuctionData = res2.data.auctions;
        SearchTest.testItemData = res2.data.items;
    }
}
