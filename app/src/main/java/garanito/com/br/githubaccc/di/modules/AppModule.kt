package garanito.com.br.githubaccc.di.modules

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import garanito.com.br.githubaccc.data.local.MeuBancoDeDados
import garanito.com.br.githubaccc.data.local.dao.UserDao
import garanito.com.br.githubaccc.data.remote.UserWebService
import garanito.com.br.githubaccc.data.repositories.UserRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideDataBase(application: Application): MeuBancoDeDados {
        return Room.databaseBuilder(application,
                MeuBancoDeDados::class.java,
                "meuqueridobanco.db").build()
    }

    @Provides
    @Singleton
    fun provideOkhttp() : OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build();
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: MeuBancoDeDados): UserDao {
        return database.userDao()
    }

    @Singleton
    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

/*
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com")
                .build()
    }
*/

    @Singleton
    @Provides
    fun provideUserWebService(retrofit: Retrofit): UserWebService {
        return retrofit.create(UserWebService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRepository(
            userWebService: UserWebService,
            userDao: UserDao,
            executor: Executor
    ): UserRepository {
        return UserRepository(userWebService,
                userDao,
                executor)
    }
}