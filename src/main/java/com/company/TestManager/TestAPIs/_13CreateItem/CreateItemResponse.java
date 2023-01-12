package com.company.TestManager.TestAPIs._13CreateItem;

import com.company.TestManager.Objects.BaseResponse;

public class CreateItemResponse extends BaseResponse {
    public Data data;

    public static class Data {
        public String auction_id;
        public String name;
        public String brand_id;
        public String description;
        public String series;
    }
}
