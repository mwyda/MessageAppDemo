package com.example.myapplication.login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import java.util.Date

class User(private var userId:String = "-1",
           private var username:String, private var email:Email,
           private var hashedPassword:String, private var salt:String,
           private var firstName:String, private var lastName:String,
           private var birthDate: Date, private var phoneNumber:Phone) {

}