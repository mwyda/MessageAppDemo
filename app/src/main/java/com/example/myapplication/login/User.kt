package com.example.myapplication.login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import java.util.Date

class User(private var userId:String = "-1",
           private var username:String, private var email:String,
           private var hashedPassword:String, private var salt:String,
           private var firstName:String, private var lastName:String,
           private var birthDate: Date, private var phoneNumber:String) {

    fun getUserId():String {
        return this.userId
    }

    fun getUsername():String {
        return this.username
    }

    fun getEmail(): String {
        return this.email
    }

    fun getHashedPassword():String {
        return this.hashedPassword
    }

    fun getSalt():String {
        return this.salt
    }

    fun getFirstName():String {
        return this.firstName
    }

    fun getLastName():String {
        return this.lastName
    }

    fun getBirthDate():Date {
        return this.birthDate
    }

    fun getPhoneNumber():String {
        return this.phoneNumber
    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setHashedPassword(newPassword:String) {
        this.hashedPassword = newPassword
    }

    fun setSalt(salt: String) {
        this.salt = salt
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun setBirthDate(birthDate: Date) {
        this.birthDate = birthDate
    }

    fun setPhone(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (userId != other.userId) return false
        if (username != other.username) return false
        if (email != other.email) return false
        if (hashedPassword != other.hashedPassword) return false
        if (salt != other.salt) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (birthDate != other.birthDate) return false
        if (phoneNumber != other.phoneNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userId.hashCode()
        result = 31 * result + username.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + hashedPassword.hashCode()
        result = 31 * result + salt.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + birthDate.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        return result
    }

    override fun toString(): String {
        return "User(username='$username', email=$email, firstName='$firstName', lastName='$lastName', birthDate=$birthDate, phoneNumber=$phoneNumber)"
    }

}