package com.company.TestManager.TestAPIs._12EditAuction;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.TestAPIs._12EditAuction.UnitTest.*;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditAuctionTest extends Test {
    public static String access_token;
    public static String idAuctionTest;

    public EditAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {

        String category_id = Util.randomNumberString(1, 1, 7);
        String start_date = "2023/06/20 11:03";
        String end_date = "2023/06/21 11:03";
        String title_ni = "Tui xach " + Util.randomAlphabetString(20);
        return new HashMap<>(Map.of(
                "category_id", category_id,
                "start_date", start_date,
                "end_date", end_date,
                "title_ni", title_ni

        ));
    }

    @Override
    protected void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "Cube@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = Connection.sendPostRequest(EndpointConstants.DEFAULT_BASE_URL + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
        EditAuctionTest.access_token = res.data.access_token;
        tempParams = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CREATE_AUCTION, tempParams, CreateAuctionResponse.class, access_token);
        EditAuctionTest.idAuctionTest = resAuction.data.auction_id;

    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new EditAuctionUnitTest1(this), new EditAuctionUnitTest2(this), new EditAuctionUnitTest3(this),
                new EditAuctionUnitTest4(this), new EditAuctionUnitTest5(this), new EditAuctionUnitTest6(this), new EditAuctionUnitTest7(this),
                new EditAuctionUnitTest8(this), new EditAuctionUnitTest9(this), new EditAuctionUnitTest10(this), new EditAuctionUnitTest11(this),
                new EditAuctionUnitTest12(this), new EditAuctionUnitTest13(this)));
    }


}
