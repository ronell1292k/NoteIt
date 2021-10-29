package ronell.noteit.ui.edit

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ronell.noteit.R
import ronell.noteit.database.Note
import ronell.noteit.databinding.EditFragmentBinding

@AndroidEntryPoint
class EditFragment : Fragment() {

    private val viewModel: EditViewModel by viewModels()
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EditFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_button -> {
                saveNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveNote() {
        val title = binding.editTitle.text.toString()
        val content = binding.editNote.text.toString()

        when {
            title.isEmpty() -> {
                binding.editTitle.error = "Enter title"
                binding.editTitle.requestFocus()
            }
            content.isEmpty() -> {
                binding.editNote.error = "Enter note body"
                binding.editNote.requestFocus()
            }
            else -> {
                val note = Note(title, content)
                viewModel.insertNote(note)
                Toast.makeText(context, "Note saved!", Toast.LENGTH_SHORT).show()
                val action = EditFragmentDirections.actionSaveNote()
                view?.findNavController()?.navigate(action)
            }
        }
    }
}