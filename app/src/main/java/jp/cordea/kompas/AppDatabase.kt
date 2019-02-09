package jp.cordea.kompas

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.cordea.kompas.infra.favorite.FavoriteEntity
import jp.cordea.kompas.infra.favorite.FavoriteDao

@Database(entities = [FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
