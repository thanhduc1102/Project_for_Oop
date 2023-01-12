package com.company.TestManager.TestAPIs._9GetListAuctionsByType;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._6GetListAuctions.GetListAuctionsResponse;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;
import java.util.List;

public class GetListAuctionsByTypeTest extends Test {
    public GetListAuctionsByTypeTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new GetListAuctionsByTypeUnitTest1(this),
                new GetListAuctionsByTypeUnitTest2(this),
                new GetListAuctionsByTypeUnitTest3(this),
                new GetListAuctionsByTypeUnitTest4(this),
                new GetListAuctionsByTypeUnitTest5(this)
        ));
    }

    public static class GetListAuctionsByTypeUnitTest1 extends UnitTest {
        public GetListAuctionsByTypeUnitTest1(Test test) {
            super(test, "Can find auctions with type id 1");
        }

        @Override
        protected void test() throws IOException {
            this.params.put("index", "1");
            this.params.put("count", "5");
            String statusId = Util.randomNumberString(1, 1, 6);
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/1" + "/" + statusId, this.params, GetListAuctionsResponse.class, null);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertNotEquals(res.data, null);
            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals(statusId)));
        }
    }

    public static class GetListAuctionsByTypeUnitTest2 extends UnitTest {
        public GetListAuctionsByTypeUnitTest2(Test test) {
            super(test, "Can find auctions with type id 2");
        }

        @Override
        protected void test() throws IOException {
            this.params.put("index", "1");
            this.params.put("count", "5");
            String statusId = Util.randomNumberString(1, 1, 6);
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/2" + "/" + statusId, this.params, GetListAuctionsResponse.class, null);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertNotEquals(res.data, null);

            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals(statusId)));
        }
    }

    public static class GetListAuctionsByTypeUnitTest3 extends UnitTest {
        public GetListAuctionsByTypeUnitTest3(Test test) {
            super(test, "Can find auctions with type id 3");
        }

        @Override
        protected void test() throws IOException {
            this.params.put("index", "1");
            this.params.put("count", "5");
            String statusId = Util.randomNumberString(1, 1, 6);
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/3" + "/" + statusId, this.params, GetListAuctionsResponse.class, null);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertNotEquals(res.data, null);

            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals(statusId)));
        }
    }

    public static class GetListAuctionsByTypeUnitTest4 extends UnitTest {
        public GetListAuctionsByTypeUnitTest4(Test test) {
            super(test, "Can find auctions with type id 4");
        }

        @Override
        protected void test() throws IOException {
            this.params.put("index", "1");
            this.params.put("count", "5");
            String statusId = Util.randomNumberString(1, 1, 6);
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/4" + "/" + statusId, this.params, GetListAuctionsResponse.class, null);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertNotEquals(res.data, null);

            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals(statusId)));
        }
    }

    public static class GetListAuctionsByTypeUnitTest5 extends UnitTest {
        public GetListAuctionsByTypeUnitTest5(Test test) {
            super(test, "Can find auctions with type id 5");
        }

        @Override
        protected void test() throws IOException {
            this.params.put("index", "1");
            this.params.put("count", "5");
            String statusId = Util.randomNumberString(1, 1, 6);
            GetListAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/5" + "/" + statusId, this.params, GetListAuctionsResponse.class, null);
            this.assertion.assertNotEquals(res, null);
            this.assertion.assertEquals(res.code, 1000);
            this.assertion.assertNotEquals(res.data, null);

            this.assertion.assertTrue(res.data.auctions.stream().allMatch(auction -> auction.statusId.equals(statusId)));
        }
    }


}
