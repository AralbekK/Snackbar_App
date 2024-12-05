package com.example.snackbar_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        val inputField: EditText = findViewById(R.id.input_field)
        val outputField: TextView = findViewById(R.id.output_field)
        val saveButton: Button = findViewById(R.id.save_button)
        val deleteButton: Button = findViewById(R.id.delete_button)

        saveButton.setOnClickListener {
            val text = inputField.text.toString()
            outputField.text = text
        }

        deleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Подтвердите удаление")
                .setPositiveButton("Удалить") { _, _ ->
                    outputField.text = ""
                    Snackbar.make(it, "Данные удалены", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Отмена", null)
            builder.create().show()
        }
    }
}
