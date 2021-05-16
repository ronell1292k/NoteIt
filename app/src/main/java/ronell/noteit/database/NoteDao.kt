package ronell.noteit.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface NoteDao {

    @Query("SELECT * FROM Note_table WHERE NoteId = :key")
    fun get(key: Long): Note

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM Note_table ORDER BY NoteId DESC")
    suspend fun getAllNotes(): List<Note>

}