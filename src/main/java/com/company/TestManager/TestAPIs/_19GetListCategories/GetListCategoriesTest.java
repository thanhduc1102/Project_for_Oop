package com.company.TestManager.TestAPIs._19GetListCategories;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._19GetListCategories.UnitTest.GetListCategoriesUnitTest;


import java.util.List;

public class GetListCategoriesTest extends Test {
    public GetListCategoriesTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }


    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListCategoriesUnitTest(this)));
    }
}
