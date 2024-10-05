package com.example.myapplication

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import com.example.myapplication.database.Connection
import com.example.myapplication.login.User
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.Date

fun main(args: Array<String>) {
    var database:DatabaseReference = Connection().getDatabaseConnection()
    var user = User(username = "test", phoneNumber = "1234567890", firstName = "michael",
        lastName = "testing", hashedPassword = "123456", salt = "123456", email = "mwyda@test.com",
        birthDate = Date("1/12/2024"))
}

fun writeUser(user: User, database: DatabaseReference):Int {
    database.child("Users").child(user.getUserId()).setValue(user)
    return 0
}