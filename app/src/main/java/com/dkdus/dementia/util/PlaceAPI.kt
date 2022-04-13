package com.dkdus.dementia.util

import com.dkdus.dementia.model.Responses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceAPI {

    @GET("tn_pubr_public_imbclty_cnter_api?serviceKey=GSW2pxLURLBrWyVipFetJcmGk%2FaF%2BOF5CJBUKR%2BUU9LSWW4B%2FVga%2BXePeLT5eN6%2F2r6UPxDx1d7FDKv0YMC94A%3D%3D")
    fun getPlace(
        @Query("numOfRows") numOfRows: String?,
        @Query("type") type: String?
    ): Call<String>


}