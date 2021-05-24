package ronell.noteit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ronell.noteit.database.Note
import ronell.noteit.repository.NoteRepository

class HomeViewModel(repository: NoteRepository) : ViewModel() {

    private val _allNotes = repository.getNotes
    private var allNotes: LiveData<List<Note>>
        get() = _allNotes

    init {
        allNotes = _allNotes
    }
}