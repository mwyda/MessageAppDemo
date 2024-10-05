package com.example.myapplication.database

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.core.Context
import com.google.firebase.database.database
import com.google.firebase.initialize

class Connection {
    private lateinit var database: DatabaseReference
    private lateinit var android:FirebaseOptions


    fun getDatabaseConnection():DatabaseReference {

        database = Firebase.database.getReference("https://console.firebase.google.com/u/0/project/messageappdemo-60375/database/messageappdemo-60375-default-rtdb/data/~2F")
        return database
    }
}