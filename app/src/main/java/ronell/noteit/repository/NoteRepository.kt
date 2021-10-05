package ronell.noteit.repository

import androidx.lifecycle.LiveData
import ronell.noteit.database.Note
import ronell.noteit.database.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(private val dao: NoteDao) {
    val getNotes: LiveData<List<Note>> = dao.getAllNotes()

    suspend fun insertNote(note: Note) = dao.insert(note)

    suspend fun updateNote(note: Note) = dao.update(note)

    suspend fun deleteNote(note: Note) = dao.delete(note)
}