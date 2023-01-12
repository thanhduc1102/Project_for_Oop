package com.company.TestManager.TestAPIs._22ContactUs.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsResponse;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ContactUsUnitTest5 extends UnitTest {


    public ContactUsUnitTest5(Test test) {
        super(test, "If content is not set, the response code should be 1001 and the data should be null ");
    }

    @Override
    protected void test() throws IOException {
        this.params = ContactUsTest.generateDefaultParams();
        this.params.remove("content");
        ContactUsResponse res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }

}
