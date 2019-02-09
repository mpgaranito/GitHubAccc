package garanito.com.br.githubaccc.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import garanito.com.br.githubaccc.data.local.entity.User
import java.util.*

@Dao // *** IMPORTANTE ***
interface UserDao{

    @Insert(onConflict = REPLACE)
    fun save(user:User)

    @Query("SELECT * FROM USER WHERE login=:login")
    fun load(login : String) : LiveData<User>

    @Query("SELECT * FROM USER WHERE login=:login and lastRefresh=:lastRefresh LIMIT 1")
    fun hasUser(login: String, lastRefresh: Date): User
}