package com.company.TestManager.TestAPIs._22ContactUs.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsResponse;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class ContactUsUnitTest1 extends UnitTest {


    public ContactUsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    protected void test() throws IOException {
        this.params = ContactUsTest.generateDefaultParams();
        ContactUsResponse res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);

        this.assertion.assertEquals(res.data.name, this.params.get("name"));
        this.assertion.assertEquals(res.data.phone, this.params.get("phone"));
        this.assertion.assertEquals(res.data.email, this.params.get("email"));
        this.assertion.assertEquals(res.data.content, this.params.get("content"));
        this.assertion.assertEquals(res.data.report_type, this.params.get("report_type"));

    }

}
