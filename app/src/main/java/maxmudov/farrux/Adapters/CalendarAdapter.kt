package maxmudov.farrux.Adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import maxmudov.farrux.Model.Calendar
import maxmudov.farrux.todolist.R
import maxmudov.farrux.todolist.databinding.ItemCalendarBinding

class CalendarAdapter() : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    private val list = ArrayList<Calendar>()


   inner class ViewHolder(private val binding: ItemCalendarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bindData(data: Calendar) {

            binding.date.text=data.date.toString()
            binding.day.text=data.day.toString()

            if (adapterPosition==3){
                binding.date.let {
                    it.setBackgroundResource(R.drawable.calendar_drawable2)
                    it.width=40
                    it.height=40
                }
                binding.day.let {
                    it.setTextSize(18F)
                    it.setTextColor(Color.parseColor("#DFBD43"))
                }
            }
        }

    }



    fun setData(list: List<Calendar>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCalendarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
        Log.d("TAG", "bindData: $list")


    }

    override fun getItemCount(): Int=list.size

}
