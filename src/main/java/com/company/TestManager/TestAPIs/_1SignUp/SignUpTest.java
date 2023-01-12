package com.company.TestManager.TestAPIs._1SignUp;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._1SignUp.UnitTests.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpTest extends Test {
    public SignUpTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {
        String email = Util.randomAlphabetOrNumberString(8, 0) + "@gmail.com";
        String password = Util.randomAlphabetOrNumberString(6, 4);
        String name = Util.randomAlphabetString(6);
        String phone = Util.randomNumberString(10);
        String address = Util.randomAlphabetOrNumberString(6, 6);
        return new HashMap<>(Map.of(
                "email", email,
                "password", password,
                "re_pass", password,
                "name", name,
                "phone", phone,
                "address", address,
                "avatar", "https://images.everydayhealth.com/images/pet-health/cs-pet-health-cat-exercises-1440x810.jpg"
        ));
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(
                new SignUpUnitTest1(this),
                new SignUpUnitTest2(this),
                new SignUpUnitTest3(this),
                new SignUpUnitTest4(this),
                new SignUpUnitTest5(this),
                new SignUpUnitTest6(this),
                new SignUpUnitTest7(this),
                new SignUpUnitTest8(this),
                new SignUpUnitTest9(this),
                new SignUpUnitTest10(this),
                new SignUpUnitTest11(this),
                new SignUpUnitTest12(this)
        ));
    }
}
