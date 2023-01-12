package com.company.TestManager.TestAPIs._28GetNotifications;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._28GetNotifications.UnitTest.GetNotificationsUnitTest1;
import com.company.TestManager.TestAPIs._28GetNotifications.UnitTest.GetNotificationsUnitTest2;

import java.util.List;

public class GetNotificationsTest extends Test {
    public GetNotificationsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetNotificationsUnitTest1(this), new GetNotificationsUnitTest2(this)));
    }
}
