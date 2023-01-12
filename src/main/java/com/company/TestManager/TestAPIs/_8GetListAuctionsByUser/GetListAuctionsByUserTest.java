package com.company.TestManager.TestAPIs._8GetListAuctionsByUser;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Objects.User;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.TestManager.TestAPIs._6GetListAuctions.GetListAuctionsResponse;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetListAuctionsByUserTest extends Test {
    public static User userTestData;
    public static String accessTokenTestData;
    public static String auctionId;
    public static HashMap<String, String> defaultParams = new HashMap<>();

    public GetListAuctionsByUserTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void beforeAll() throws IOException {
        // default params
        GetListAuctionsByUserTest.defaultParams.put("index", "1");
        GetListAuctionsByUserTest.defaultParams.put("count", "5");

        //login user and set test data
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "Cube@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
        GetListAuctionsByUserTest.userTestData = res.data.user;
        GetListAuctionsByUserTest.accessTokenTestData = res.data.access_token;

        // create auctions to test
//        HashMap<String, String> tempParams2 = CreateAuctionTest.generateDefaultParams();
//        CreateAuctionResponse createAuctionRes = Connection.sendPostRequest(this.baseURLString + "/" + Constant.CREATE_AUCTION, tempParams2, CreateAuctionResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
//        GetListAuctionsByUserTest.auctionId = createAuctionRes.data.auction_id;
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new GetListAuctionsByUserUnitTest1(this),
                new GetListAuctionsByUserUnitTest2(this),
                new GetListAuctionsByUserUnitTest3(this),
                new GetListAuctionsByUserUnitTest4(this),
                new GetListAuctionsByUserUnitTest5(this),
                new GetListAuctionsByUserUnitTest6(this)
        ));
    }

    //  unit tests
    public static class GetListAuctionsByUserUnitTest1 extends UnitTest {
        public GetListAuctionsByUserUnitTest1(Test test) {
            super(test, "Can find auction with status 1");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("1") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }

    public static class GetListAuctionsByUserUnitTest2 extends UnitTest {
        public GetListAuctionsByUserUnitTest2(Test test) {
            super(test, "Can find auctions with status 2");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/2", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("2") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }

    public static class GetListAuctionsByUserUnitTest3 extends UnitTest {
        public GetListAuctionsByUserUnitTest3(Test test) {
            super(test, "Can find auctions with status 3");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/3", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("3") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }

    public static class GetListAuctionsByUserUnitTest4 extends UnitTest {
        public GetListAuctionsByUserUnitTest4(Test test) {
            super(test, "Can find auctions with status 4");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/4", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("4") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }

    public static class GetListAuctionsByUserUnitTest5 extends UnitTest {
        public GetListAuctionsByUserUnitTest5(Test test) {
            super(test, "Can find auctions with status 5");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/5", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("5") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }

    public static class GetListAuctionsByUserUnitTest6 extends UnitTest {
        public GetListAuctionsByUserUnitTest6(Test test) {
            super(test, "Can find auctions with status 6");
        }

        @Override
        protected void test() throws IOException {
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/6", GetListAuctionsByUserTest.defaultParams, GetListAuctionsResponse.class, GetListAuctionsByUserTest.accessTokenTestData);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertTrue(res.message.length() > 0);
            this.assertion.assertTrue(res.data.total >= 0);
            if (res.data.auctions.size() == 0) return;
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals("6") && auction.selling_user_id.equals(GetListAuctionsByUserTest.userTestData.user_id)));
        }
    }
}
