package maxmudov.farrux.Adapters

import android.graphics.Paint
import android.graphics.PaintFlagsDrawFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import maxmudov.farrux.Model.Tasks
import maxmudov.farrux.todolist.databinding.ItemTasksBinding

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemTasksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Tasks) {

            binding.checkbox.isChecked = data.isChecked
            binding.clock.text = data.clock
            binding.text.text = data.text
            if (data.isChecked) {
             binding.text.paintFlags=(Paint.STRIKE_THRU_TEXT_FLAG)
            }


        }
    }

    private val list = ArrayList<Tasks>()

    fun setData(list: List<Tasks>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTasksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size
}