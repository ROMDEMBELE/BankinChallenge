package com.dembeyo.challengebankin.data.network.service

import com.dembeyo.challengebankin.data.network.dto.CategoryBodyDto
import com.dembeyo.challengebankin.data.network.dto.CategoryDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

/**
 * Network service to get [CategoryDto] from BASE_URL json file.
 */
class CategoryService {

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val jsonAdapter = moshi.adapter(CategoryBodyDto::class.java)
    private val BASE_URL =
        "https://raw.githubusercontent.com/bankin-engineering/challenge-android/master/categories.json"

    suspend fun getCategories(): List<CategoryDto> = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(BASE_URL).build()
        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                response.body?.string()?.let { json ->
                    val body = jsonAdapter.fromJson(json) as CategoryBodyDto
                    return@let body.resources
                } ?: run {
                    throw NullPointerException("Http request response body is null")
                }
            } else {
                throw IOException("Http request failed with code : ${response.code}")
            }
        }
    }
}