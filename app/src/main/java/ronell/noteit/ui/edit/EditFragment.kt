package ronell.noteit.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ronell.noteit.R
import ronell.noteit.databinding.EditFragmentBinding

class EditFragment : Fragment() {
    private val viewModel: EditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<EditFragmentBinding>(
            inflater,
            R.layout.edit_fragment,
            container,
            false
        )
        return binding.root
    }
}