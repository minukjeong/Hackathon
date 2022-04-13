package com.dkdus.dementia.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class PlaceUtil {
    var placeAPI: PlaceAPI
    init {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.data.go.kr/openapi/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        placeAPI  = retrofit.create(PlaceAPI::class.java)
    }
    public fun getApi() : PlaceAPI {
        return placeAPI
    }
}