package com.company.TestManager.TestAPIs._27ReadNews;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._27ReadNews.UnitTest.ReadNewsUnitTest1;

import java.util.List;

public class ReadNewsTest extends Test {
    public ReadNewsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new ReadNewsUnitTest1(this)));
    }
}
