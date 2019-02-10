package jp.cordea.kompas.infra.favorite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Maybe

@Dao
abstract class FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    internal abstract fun insertFavorite(favorite: FavoriteEntity)

    @Query("DELETE FROM favorite WHERE id = :id")
    internal abstract fun deleteFavorite(id: Int)

    @Query("SELECT * FROM favorite WHERE id = :id LIMIT 1")
    internal abstract fun getFavorite(id: Int): Maybe<FavoriteEntity>
}
