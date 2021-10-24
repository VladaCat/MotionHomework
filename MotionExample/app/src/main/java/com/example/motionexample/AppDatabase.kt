
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.motionexample.MyCatsDao
import com.example.motionexample.MyCatsDb

@Database(
    version = 1,
    entities = [MyCatsDb::class],
    exportSchema = true
)

abstract class AppDatabase() : RoomDatabase() {

    abstract fun myCatsDao(): MyCatsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "MYCAT"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}