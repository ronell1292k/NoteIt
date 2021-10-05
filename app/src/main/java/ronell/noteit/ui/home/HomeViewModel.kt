package ronell.noteit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ronell.noteit.database.Note
import ronell.noteit.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: NoteRepository) : ViewModel() {

    private val _allNotes = repository.getNotes
    private var allNotes: LiveData<List<Note>>
        get() = _allNotes

    init {
        allNotes = _allNotes
    }
}