package com.daily.affirmations.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LLMApiService {

    @POST("/chat/completions")
    suspend fun sendMessage(@Body message: String): Response<String>
}

class LLMApiServiceFake: LLMApiService {
    override suspend fun sendMessage(message: String): Response<String> {
        return Response.success("Yesssssir")
    }

}