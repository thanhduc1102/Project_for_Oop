package com.company.TestManager.TestAPIs._20GetListBrands;

import com.company.TestManager.Objects.BaseResponse;

import java.util.ArrayList;

public class GetListBrandsResponse extends BaseResponse {
    public Data data;

    static class Data {
        public ArrayList<Brand> brands;
    }

    static class Brand {
        public String brand_id;
        public String name;
        public String brand_info;
    }
}
