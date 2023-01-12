package com.company.TestManager.TestAPIs._15GetListComments;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._15GetListComments.UnitTest.GetListCommentUnitTest1;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetListCommentsTest extends Test {
    public GetListCommentsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListCommentUnitTest1(this)));
    }
    public static HashMap<String, String> generateDefaultParams() {

        String index="0";
        String count="1";
        return new HashMap<>(Map.of(
                "index", index ,
                "count", count

        ));
    }
}
