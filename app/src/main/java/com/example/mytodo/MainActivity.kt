package com.example.mytodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: TasksDatabaseHelper
    private lateinit var tasksAdapter: TasksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_start_page)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)
        tasksAdapter = TasksAdapter(db.getAllTasks(),this)

        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = tasksAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    //refresh data method
    override fun onResume() {
        super.onResume()
        tasksAdapter.refreshData(db.getAllTasks())
    }
}