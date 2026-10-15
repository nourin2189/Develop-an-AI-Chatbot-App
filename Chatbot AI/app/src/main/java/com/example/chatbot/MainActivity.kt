package com.example.chatbot

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var etMessage: EditText
    private lateinit var btnSend: ImageButton

    private val messageList = mutableListOf<Message>()
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                maxOf(systemBars.bottom, imeInsets.bottom)
            )
            insets
        }

        recyclerViewChat = findViewById(R.id.recyclerViewChat)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)

        chatAdapter = ChatAdapter(messageList)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.stackFromEnd = true
        recyclerViewChat.layoutManager = linearLayoutManager
        recyclerViewChat.adapter = chatAdapter

        // Add welcome message from bot
        addBotMessage("Assalamu Alaikum! Ami apnar AI Assistant. Apnake kivabe sahajjo korte pari?")

        btnSend.setOnClickListener {
            val text = etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                addUserMessage(text)
                etMessage.text.clear()

                // Generate Bot Response after short delay
                recyclerViewChat.postDelayed({
                    val response = ChatBotAI.getResponse(text)
                    addBotMessage(response)
                }, 500)
            }
        }
    }

    private fun addUserMessage(text: String) {
        messageList.add(Message(text, isUser = true))
        chatAdapter.notifyItemInserted(messageList.size - 1)
        recyclerViewChat.scrollToPosition(messageList.size - 1)
    }

    private fun addBotMessage(text: String) {
        messageList.add(Message(text, isUser = false))
        chatAdapter.notifyItemInserted(messageList.size - 1)
        recyclerViewChat.scrollToPosition(messageList.size - 1)
    }
}
