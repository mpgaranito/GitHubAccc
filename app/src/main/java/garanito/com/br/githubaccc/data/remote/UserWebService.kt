package garanito.com.br.githubaccc.data.remote

import garanito.com.br.githubaccc.data.local.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebService {
    @GET("/users/{users}")
    fun getUser(@Path("user") userId: String): Call<User>
}