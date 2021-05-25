package ronell.noteit.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ronell.noteit.R
import ronell.noteit.adapter.NoteAdapter
import ronell.noteit.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<HomeFragmentBinding>(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )
        binding.newNoteButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.actionAddNote)
        )

        val recyclerView = binding.notesGrid
        recyclerView.setHasFixedSize(true)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.notesGrid.layoutManager =
                StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        } else
            binding.notesGrid.layoutManager =
                StaggeredGridLayoutManager(3, GridLayoutManager.VERTICAL)

        recyclerView.adapter = NoteAdapter()

        return binding.root
    }

}