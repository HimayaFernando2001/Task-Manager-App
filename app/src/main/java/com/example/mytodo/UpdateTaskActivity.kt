package com.example.mytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytodo.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db: TasksDatabaseHelper
    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        // Get the task ID from the intent
        taskId = intent.getIntExtra("task_id", -1)
        if (taskId == -1) {
            finish() // Finish the activity if no valid task ID is found
            return
        }

        // Load the task details from the database
        val task = db.getTaskByID(taskId)
        binding.updateTitleEditText.setText(task.title)
        binding.updateContentEditText.setText(task.content)

        // Set an OnClickListener on the Update Task button
        binding.btnUpdate.setOnClickListener {
            val newTitle = binding.updateTitleEditText.text.toString()
            val newContent = binding.updateContentEditText.text.toString()

            // Create the updated task object
            val updatedTask = Task(taskId, newTitle, newContent)

            // Update the task in the database
            db.updateTask(updatedTask)

            // Show a Toast message to indicate success
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()

            // Finish the activity and return to the previous screen
            finish()
        }
    }
}
