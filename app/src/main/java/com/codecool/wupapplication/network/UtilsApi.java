package com.codecool.wupapplication.network;

public class UtilsApi {

    private static final String BASE_URL_API = "https://raw.githubusercontent.com/wupdigital/interview-api/master/api/v1/";

    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
