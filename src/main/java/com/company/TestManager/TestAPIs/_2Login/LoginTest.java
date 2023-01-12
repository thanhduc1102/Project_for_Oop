package com.company.TestManager.TestAPIs._2Login;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.SignUpResponse;
import com.company.TestManager.TestAPIs._1SignUp.SignUpTest;
import com.company.TestManager.TestAPIs._2Login.UnitTests.*;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

// class kế thừa class test với mục đích thêm các unit test
public class LoginTest extends Test {
    public static String email;
    public static String password;

    public LoginTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void beforeAll() throws IOException {
//        sign up new account
        HashMap<String, String> tempParams = SignUpTest.generateDefaultParams();
        Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.SIGN_UP, tempParams, SignUpResponse.class);
        LoginTest.email = tempParams.get("email");
        LoginTest.password = tempParams.get("password");
    }

    @Override
//    phương thức cần phải ghi đè từ phương thức của class cha
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new LoginUnitTest1(this),
                new LoginUnitTest2(this),
                new LoginUnitTest3(this),
                new LoginUnitTest4(this),
                new LoginUnitTest5(this)
        ));
    }
}
