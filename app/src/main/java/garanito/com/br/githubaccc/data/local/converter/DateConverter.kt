package garanito.com.br.githubaccc.data.local.converter

import android.arch.persistence.room.TypeConverter
import java.sql.Date
import java.sql.Timestamp

//Criar classe statica
object DateConverter{
    @TypeConverter
    @JvmStatic  //conversor do banco, como static
    fun toDate(timestamp: Long?) : Date? {
        return  if(timestamp== null) null else Date(timestamp)
    }

    @TypeConverter
    @JvmStatic
    fun toTimestamp(date : Date?) : Long?{
        return  date?.time
    }
}