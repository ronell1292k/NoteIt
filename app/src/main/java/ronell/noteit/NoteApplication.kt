package ronell.noteit

import android.app.Application
import ronell.noteit.database.NoteDatabase
import ronell.noteit.repository.NoteRepository

class NoteApplication : Application() {


    private val noteDatabase by lazy { NoteDatabase.getDatabase(this) }
    val repository by lazy { NoteRepository(noteDatabase.noteDao()) }
}