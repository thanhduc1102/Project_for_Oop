package com.company;

import com.company.constants.EndpointConstants;

public class BaseURL {
    private String baseURL;

    public BaseURL() {
        this.baseURL = EndpointConstants.DEFAULT_BASE_URL;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
