package com.example.chatbot

import java.util.Locale

object ChatBotAI {

    fun getResponse(query: String): String {
        val lowerQuery = query.lowercase(Locale.ROOT).trim()

        return when {
            lowerQuery.contains("assalamualaikum") || lowerQuery.contains("salam") ->
                "Wa Alaikum Assalam! Apnake kivabe sahajjo korte pari?"
            
            lowerQuery.contains("hi") || lowerQuery.contains("hello") || lowerQuery.contains("hey") || lowerQuery.contains("hy") ->
                "Hello! I am your AI Chatbot assistant. How can I help you today?"
            
            lowerQuery.contains("kemon acho") || lowerQuery.contains("kemon achen") || lowerQuery.contains("how are you") ->
                "Ami alhamdulillah khub valo achi! Apni kemon achen? Apnake ki niye sahajjo korte pari?"
            
            lowerQuery.contains("tumi ke") || lowerQuery.contains("who are you") || lowerQuery.contains("your name") ->
                "Ami ekti AI Chatbot, apnake kotha bolte ebong bibhinno proshner uttor dite toiri kora hoyeche!"
            
            lowerQuery.contains("help") || lowerQuery.contains("sahajjo") ->
                "Nishchoi! Apni amake je kono proshno korte paren, jemon: 'Kemon acho?', 'Tumi ke?', 'Ajker abohowa kemon?', ba general coding ba general knowledge-er proshno."
            
            lowerQuery.contains("weather") || lowerQuery.contains("abohowa") ->
                "Ami sange sange live weather data dekhte pari na, kintu sadharonoto akash meghla ba roddur thakte pare. Apnar elakay abohowa kemon?"
            
            lowerQuery.contains("joke") || lowerQuery.contains("hasi") || lowerQuery.contains("comedy") ->
                "Eti ekta moja: Ekjon student ke shikkhok jiggesh korlo - 'Bokachoda' kon shobd? Student bollo - 'Sir, eta ekti obhibok-shobd!' 😄"
            
            lowerQuery.contains("dhonnobad") || lowerQuery.contains("thank") || lowerQuery.contains("thanks") ->
                "Apnakou onek dhonnobad! Aro kono sahajjo lagle bolben."
            
            lowerQuery.contains("bye") || lowerQuery.contains("tata") || lowerQuery.contains("allah hafez") ->
                "Allah Hafez! Valo thakben. Abaar kotha hobe!"

            else -> {
                if (lowerQuery.isNotEmpty()) {
                    "Ami apnar kotha '$query' bujhechi. E bepare aro kichu bolun ba onno kono proshno korun!"
                } else {
                    "Kichu likhun, jate ami uttor dite pari!"
                }
            }
        }
    }
}
