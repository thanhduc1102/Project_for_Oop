package com.company.TestManager.TestAPIs._24GetListLikes;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._24GetListLikes.UnitTest.GetListLikesUnitTest1;
import com.company.TestManager.TestAPIs._24GetListLikes.UnitTest.GetListLikesUnitTest2;

import java.util.List;

public class GetListLikesTest extends Test {
    public GetListLikesTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListLikesUnitTest1(this), new GetListLikesUnitTest2(this)));
    }
}
