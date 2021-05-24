package ronell.noteit.ui.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ronell.noteit.database.Note
import ronell.noteit.repository.NoteRepository

class EditViewModel(private val repository: NoteRepository) : ViewModel() {

    private val _allNotes: LiveData<List<Note>> = repository.getNotes
    private var allNotes: LiveData<List<Note>>
        get() = _allNotes

    init {
        allNotes = _allNotes
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }
}
