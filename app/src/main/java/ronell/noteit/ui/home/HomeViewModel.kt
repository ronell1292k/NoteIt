package ronell.noteit.ui.home

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ronell.noteit.database.Note
import ronell.noteit.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    val allNotes = repository.getNotes.asLiveData()

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }
}