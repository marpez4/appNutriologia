package com.example.appnutriologia

import com.example.appnutriologia.datasources.FoodApiService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiResponseTest {

    private lateinit var apiService: FoodApiService
    private val mockWebServer = MockWebServer()

    @Before
    fun setup(){

        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(FoodApiService::class.java)
    }

    @Test
    fun `test getAllCategories return correct data`() = runBlocking {
         val mockResponse = """
            {
                "categories": [
                    {"idCategory": "1", "strCategory": "Beef", "strCategoryThumb": "", "strCategoryDescription": "Beef dishes"},
                    {"idCategory": "2", "strCategory": "Chicken", "strCategoryThumb": "", "strCategoryDescription": "Chicken dishes"}
                ]
            }
        """
        mockWebServer.enqueue(MockResponse().setBody(mockResponse).setResponseCode(200))

        val response = apiService.getAllCategories()

        assertTrue(response.categories.isNotEmpty())
        assertEquals("Beef", response.categories[0].strCategory)
        assertEquals("Chicken", response.categories[1].strCategory)


    }

}