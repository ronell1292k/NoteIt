package ronell.noteit.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(

    @ColumnInfo(name = "note_title")
    val noteTitle: String,

    @ColumnInfo(name = "note_body")
    val noteBody: String,

    @PrimaryKey(autoGenerate = true)
    val noteId: Long = 0L
) : Parcelable

