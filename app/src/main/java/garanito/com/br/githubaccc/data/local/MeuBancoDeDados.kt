package garanito.com.br.githubaccc.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import garanito.com.br.githubaccc.data.local.converter.DateConverter
import garanito.com.br.githubaccc.data.local.dao.UserDao
import garanito.com.br.githubaccc.data.local.entity.User

@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
//Sem implementar, usar classe abstrada,
abstract class MeuBancoDeDados : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val INSTANCE: MeuBancoDeDados? = null
    }
}