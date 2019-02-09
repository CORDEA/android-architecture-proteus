package jp.cordea.kompas.infra.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jp.cordea.kompas.model.EventId
import jp.cordea.kompas.model.Favorite

@Entity
class FavoriteEntity(
        @PrimaryKey @ColumnInfo(name = "id") val rawId: Int,
        val addedAt: String
) : Favorite {
    override val id: EventId get() = EventId(rawId)
}
