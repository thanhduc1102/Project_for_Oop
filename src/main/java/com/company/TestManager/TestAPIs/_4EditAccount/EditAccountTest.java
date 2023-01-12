package com.company.TestManager.TestAPIs._4EditAccount;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.TestAPIs._4EditAccount.UnitTests.*;
import com.company.constants.EndpointConstants;
import com.company.utils.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditAccountTest extends Test {
    public static String ACCESS_TOKEN;
    public static String OLD_PASSWORD;
    public static String EMAIL;

    public EditAccountTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {
        return new HashMap<>(Map.of(
                "email", Util.randomAlphabetString(10) + "@gmail.com",
                "name", Util.randomAlphabetString(8),
                "phone", Util.randomNumberString(10),
                "address", Util.randomAlphabetOrNumberString(10, 3),
                "avatar", Util.randomAlphabetString(40)
        ));
    }

    public static HashMap<String, String> generateDefaultParams2() {
        String pass = Util.randomAlphabetOrNumberString(5, 5);
        return new HashMap<>(Map.of(
                "old_pass", EditAccountTest.OLD_PASSWORD,
                "new_pass", pass,
                "re_pass", pass
        ));
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new EditAccountUnitTest1(this),
                new EditAccountUnitTest2(this),
                new EditAccountUnitTest3(this),
                new EditAccountUnitTest4(this),
                new EditAccountUnitTest5(this),
                new EditAccountUnitTest6(this),
                new EditAccountUnitTest7(this),
                new EditAccountUnitTest8(this),
                new EditAccountUnitTest9(this),
                new EditAccountUnitTest10(this),
                new EditAccountUnitTest11(this),
                new EditAccountUnitTest12(this),
                new EditAccountUnitTest13(this)
        ));
    }

    @Override
    protected void beforeAll() throws IOException {
//        sign up new account
        HashMap<String, String> tempParams = SignUpTest.generateDefaultParams();
        Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.SIGN_UP, tempParams, SignUpResponse.class, null);
        EditAccountTest.OLD_PASSWORD = tempParams.get("password");
        EditAccountTest.EMAIL = tempParams.get("email");
//        store access token
        EditAccountTest.ACCESS_TOKEN = Connection.getAccessToken(this.getBaseUrlString(), tempParams.get("email"), tempParams.get("password"));
    }
}
