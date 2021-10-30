package ronell.noteit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ronell.noteit.database.Note
import ronell.noteit.databinding.NoteCardBinding

class NoteAdapter(private val onClick: (Note) -> Unit) : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class NoteViewHolder(private val binding: NoteCardBinding, private val onClick: (Note) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.textViewTitle.text = note.noteTitle
            binding.textViewNote.text = note.noteBody
            binding.root.setOnClickListener {
                onClick(note)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

}