package maxmudov.farrux.todolist

import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import maxmudov.farrux.Adapters.CalendarAdapter
import maxmudov.farrux.Adapters.TasksAdapter
import maxmudov.farrux.Model.Calendar
import maxmudov.farrux.Model.Tasks
import maxmudov.farrux.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var adapter: CalendarAdapter
    lateinit var adapterT:TasksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CalendarData()
        TasksData()




    }

    private fun TasksData() {
        adapterT= TasksAdapter()

        val list =ArrayList<Tasks>()

        list.add(0,Tasks("8:00 AM","Go to church",true))
        list.add(1, Tasks("12:00 PM","Cook for the family",true))
        list.add(2, Tasks("2:00 PM","Wash my clothes",true))
        list.add(3, Tasks("5:00 PM","Visit Chastity",false))
        list.add(4, Tasks("6:00 PM","Make my hair",true))
        list.add(5, Tasks("8:00 PM","Call my brother",false))
        adapterT.setData(list)
        binding.list2.adapter=adapterT


    }

    private  fun CalendarData(){

        adapter= CalendarAdapter()

        val dayList =ArrayList<Calendar>()

        dayList.add(0, Calendar("Thur",5))
        dayList.add(1,Calendar("Fri",6))
        dayList.add(2,Calendar("Sat",7))
        dayList.add(3,Calendar("Sun",8))
        dayList.add(4,Calendar("Mon",9))
        dayList.add(5,Calendar("Tues",10))
        dayList.add(6,Calendar("Wed",11))

        adapter.setData(dayList)

        binding.list.adapter=adapter


    }

}