package com.company.TestManager.TestAPIs._22ContactUs;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._22ContactUs.UnitTest.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.Map;

public class ContactUsTest extends Test {
    public ContactUsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {
        String email = Util.randomAlphabetOrNumberString(8, 0) + "@gmail.com";
        String name = Util.randomAlphabetString(6);
        String phone = Util.randomNumberString(10);
        String report_type = Util.randomNumberString(1, 1, 3);
        String content = Util.randomAlphabetString(6);
        //Byte file = Util.randomNumberString(4);
        return new HashMap<>(Map.of(
                "email", email,
                "report_type", report_type,
                "name", name,
                "phone", phone,
                "content", content
                //"file", file
        ));
    }

    @Override
    protected void initUnitTests() {

        this.unitTests.add(new ContactUsUnitTest1(this));
        this.unitTests.add(new ContactUsUnitTest2(this));
        this.unitTests.add(new ContactUsUnitTest3(this));
        this.unitTests.add(new ContactUsUnitTest4(this));
        this.unitTests.add(new ContactUsUnitTest5(this));
        this.unitTests.add(new ContactUsUnitTest6(this));
    }
}
