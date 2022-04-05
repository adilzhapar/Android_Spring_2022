package com.example.todolist

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityDashboardBinding
import com.example.todolist.DTO.ToDo

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        dbHandler = DBHandler(this)
        setContentView(binding.root)
//        setSupportActionBar(binding.dashboardToolbar)
        title = "Dashboard"
        binding.rvDashboard.layoutManager = LinearLayoutManager(this)

        binding.fabDashboard.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_dashboard, null)
            val toDoName = view.findViewById<EditText>(R.id.ev_todo)
            dialog.setView(view)
            dialog.setPositiveButton("Add") { _: DialogInterface, _: Int ->
                if (toDoName.text.isNotEmpty()) {
                    val toDo = ToDo()
                    toDo.name = toDoName.text.toString()
                    dbHandler.addToDo(toDo)
                    refreshList()
                }
            }
            dialog.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->

            }
            dialog.show()
        }
    }

    override fun onResume() {
        refreshList()
        super.onResume()
    }

    private fun refreshList(){
        val x = DashboardAdapter(this, dbHandler, dbHandler.getToDos())
        binding.rvDashboard.adapter = x
    }



    class DashboardAdapter(private val context: Context, val dbHandler: DBHandler, private val list: MutableList<ToDo>) :
        RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
                return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_child_dashboard, p0, false))
            }

            override fun getItemCount(): Int {
                return list.size
            }

            override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
                holder.toDoName.text = list[p1].name

                holder.toDoName.setOnClickListener {
                    val intent = Intent(context, ItemActivity::class.java)
                    intent.putExtra(INTENT_TODO_ID, list[p1].id)
                    intent.putExtra(INTENT_TODO_NAME, list[p1].name)
                    context.startActivity(intent)
                }

                holder.menu.setOnClickListener {
                    val popup = PopupMenu(context, holder.menu)
                    popup.inflate(R.menu.dashboard_child)
//                    popup.setOnMenuItemClickListener {

//                        when(it.itemId){
//                            R.id.menu_edit -> Unit{
//
//                            }
//                            R.id.menu_delete -> Unit{
//                                dbHandler.deleteToDo()
//                            }
//                            R.id.menu_mark_as_completed -> {
//
//                            }
//                            R.id.menu_reset -> {
//
//                            }
//                            else -> Unit{}
//                        }
//                    }
                }
            }

            inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
                val toDoName: TextView = v.findViewById(R.id.ev_todo)
                val menu: ImageView = v.findViewById(R.id.iv_menu)
            }
    }

}