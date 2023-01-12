package com.company.TestManager.TestAPIs._30GetSlider;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._30GetSlider.UnitTest.GetSliderUnitTest;

import java.util.List;

public class GetSliderTest extends Test {
    public GetSliderTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetSliderUnitTest(this)));
    }
}
