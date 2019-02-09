package jp.cordea.kompas.infra.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jp.cordea.kompas.infra.EventId

@Entity
class FavoriteEntity(
        @PrimaryKey @ColumnInfo(name = "id") val rawId: Int,
        val addedAt: String
) {
    val id: EventId get() = EventId(rawId)
}
