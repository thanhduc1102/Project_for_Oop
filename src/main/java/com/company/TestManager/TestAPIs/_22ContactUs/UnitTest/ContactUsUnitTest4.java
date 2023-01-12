package com.company.TestManager.TestAPIs._22ContactUs.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsResponse;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class ContactUsUnitTest4 extends UnitTest {


    public ContactUsUnitTest4(Test test) {
        super(test, "If more than 255 characters are entered in email field or email field is not set, the response code should be 1001 and the data should be null");
    }

    @Override
    protected void test() throws IOException {
        this.params = ContactUsTest.generateDefaultParams();
        this.params.put("email", Util.randomAlphabetOrNumberString(140, 130));
        ContactUsResponse res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

        this.params.remove("email");
        res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }

}
