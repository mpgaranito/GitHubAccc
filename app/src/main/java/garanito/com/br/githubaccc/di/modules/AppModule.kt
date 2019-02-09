package garanito.com.br.githubaccc.di.modules

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import garanito.com.br.githubaccc.data.local.MeuBancoDeDados
import garanito.com.br.githubaccc.data.local.dao.UserDao
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideDataBase(application: Application): MeuBancoDeDados {
        return Room.databaseBuilder(application,
                MeuBancoDeDados::class.java,
                "meuqueridobanco.db").build()
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
}