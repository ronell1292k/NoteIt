package ronell.noteit.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
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
    fun getAllNotes(): Flow<List<Note>>

}