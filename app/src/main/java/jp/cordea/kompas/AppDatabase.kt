package jp.cordea.kompas

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.cordea.kompas.infra.favorite.Favorite
import jp.cordea.kompas.infra.favorite.FavoriteDao

@Database(entities = [Favorite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
