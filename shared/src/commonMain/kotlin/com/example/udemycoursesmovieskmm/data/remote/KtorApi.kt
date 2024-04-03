package com.example.udemycoursesmovieskmm.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/*
internal ??
 visibility modifier
 ilgili modül içerisinde geçerli olur
 ios modul, android modül, shared modül
 sınıflarımızı özellikle de shared içerisinde kalması gereken kısımları internal olarak işaretliyoruz
 */

// ContentNegotiation = networking işlemleri , authentication = kullanıcı işlemleri
//ignoreUnknownKeys = uygulamayı çökertmeden sadece bildiği keyleri gelen dönüşten bildiği keyleri alabilecek


//https://api.themoviedb.org/3/movie/157336?api_key=59fde4290514f7733a49cd1852fa1887
//https://api.themoviedb.org/3/movie/157336/videos?api_key=59fde4290514f7733a49cd1852fa1887
//https://api.themoviedb.org/3/movie/popular?page=1&api_key=59fde4290514f7733a49cd1852fa1887

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "59fde4290514f7733a49cd1852fa1887"

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }


    fun HttpRequestBuilder.pathUrl(path: String){
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", API_KEY)
        }
    }

}