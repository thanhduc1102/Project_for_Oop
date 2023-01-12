package com.company.TestManager.TestAPIs._22ContactUs.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsResponse;
import com.company.TestManager.TestAPIs._22ContactUs.ContactUsTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class ContactUsUnitTest2 extends UnitTest {


    public ContactUsUnitTest2(Test test) {
        super(test, "If more than 255 characters are entered in the name field or empty name field, the response code should be 1001 and the data should be null");
    }

    @Override
    protected void test() throws IOException {
        this.params = ContactUsTest.generateDefaultParams();
        this.params.put("name", Util.randomAlphabetString(260));
        ContactUsResponse res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

        this.params.put("name", "");
        res = this.sendPostRequestWithAccessToken(ContactUsResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }

}
