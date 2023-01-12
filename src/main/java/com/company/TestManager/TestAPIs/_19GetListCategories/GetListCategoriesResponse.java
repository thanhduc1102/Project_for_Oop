package com.company.TestManager.TestAPIs._19GetListCategories;

import com.company.TestManager.Objects.BaseResponse;

import java.util.ArrayList;


public class GetListCategoriesResponse extends BaseResponse {
    public ArrayList<Category> data;


    public static class Category {
        public String category_id;
        public String name;
        public String image;
        public String type;
    }
}

