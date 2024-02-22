package com.daily.affirmations.data.repo

import com.daily.affirmations.data.api.LLMApiService
import javax.inject.Inject

class LLMRepository @Inject constructor(
    private val api: LLMApiService
) {
    suspend fun sendMessage(message: String): String? {
        return api.sendMessage(message).takeIf { it.isSuccessful }?.body()
    }
}