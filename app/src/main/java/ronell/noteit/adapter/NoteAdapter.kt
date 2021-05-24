package ronell.noteit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ronell.noteit.database.Note
import ronell.noteit.databinding.NoteCardBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notesList = emptyList<Note>()

    class NoteViewHolder(private val binding: NoteCardBinding) :
        ViewHolder(binding.root) {
        fun bind(note: Note, context: Context) {
            binding.textViewTitle.text = note.noteTitle
            binding.textViewNote.text = note.noteBody
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
        holder.bind(note, holder.itemView.context)
    }

    override fun getItemCount(): Int = notesList.size

}