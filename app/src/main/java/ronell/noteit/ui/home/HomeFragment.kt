package ronell.noteit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ronell.noteit.adapter.NoteAdapter
import ronell.noteit.databinding.HomeFragmentBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.newNoteButton.setOnClickListener {
            val action = HomeFragmentDirections.actionAddNote()
            findNavController(it).navigate(action)
        }

        val noteAdapter = NoteAdapter {
            val action = HomeFragmentDirections.actionAddNote(noteArg = it)
            view?.findNavController()?.navigate(action)
        }

        binding.apply {
            notesGrid.apply {
                adapter = noteAdapter
                layoutManager = StaggeredGridLayoutManager(
                    2,
                    GridLayoutManager.VERTICAL
                )
            }
            viewModel.allNotes.observe(viewLifecycleOwner, {
                noteAdapter.submitList(it)
            })
        }
        return binding.root
    }
}