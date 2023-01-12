package com.company.TestManager.TestAPIs._3Logout;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._3Logout.UnitTests.LogoutUnitTest1;
import com.company.TestManager.TestAPIs._3Logout.UnitTests.LogoutUnitTest2;

import java.util.List;

public class LogoutTest extends Test {
    public LogoutTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new LogoutUnitTest1(this), new LogoutUnitTest2(this)));
    }
}
