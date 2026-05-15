package com.raitha.varta.data.remote

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path

interface VartaApi {
    @POST("api/tips/generate")
    suspend fun generateTip(@Body request: TipRequest): GeneratedTip

    @POST("api/disease/detect")
    suspend fun detectDisease(@Body request: DiseaseRequest): DiseaseResponse

    @GET("api/weather/{lat}/{lng}")
    suspend fun getWeather(@Path("lat") lat: Double, @Path("lng") lng: Double): WeatherResponse
}

data class TipRequest(val cropName: String, val language: String)
data class GeneratedTip(val title: String, val description: String, val imageUrl: String)
data class DiseaseRequest(val imageBase64: String)
data class DiseaseResponse(val analysis: String)
data class WeatherResponse(val location: String, val temperature: String, val condition: String, val advisory: String)
