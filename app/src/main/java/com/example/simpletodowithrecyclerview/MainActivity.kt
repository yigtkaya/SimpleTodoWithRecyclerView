package com.example.simpletodowithrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpletodowithrecyclerview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            ToDo("Learn Kotlin", false),
            ToDo("Learn Android", false),
            ToDo("Build Simple Todo App", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.buttonAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = ToDo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
            binding.etTodo.text.clear()
        }
    }
}
