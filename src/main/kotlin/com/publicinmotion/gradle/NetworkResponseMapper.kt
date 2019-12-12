package com.publicinmotion.gradle

import com.google.gson.Gson
import okhttp3.Response

class NetworkResponseMapper {
    private val gson = Gson()

    fun map(response: Response): ZanderResponse {
        return if (response.isSuccessful) {
            gson.fromJson(response.body?.string(), ZanderResponse.Success::class.java)
        } else {
            ZanderResponse.Error(response.code, response.message)
        }
    }
}
