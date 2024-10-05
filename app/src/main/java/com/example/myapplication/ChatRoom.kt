package com.example.myapplication

import java.util.Date

class ChatRoom(private var chatRoomId: String, private var longitude: String,
               private var latitude: String, private var startDate: Date,
               private var isActive: Boolean, private var privacy: String,
               private var isDM: Boolean) {

    fun getChatRoomId():String {
        return chatRoomId
    }

    fun getLongitude():String {
        return longitude
    }

    fun getLatitude():String {
        return latitude
    }

    fun getStartDate():Date {
        return startDate
    }

    fun getActiveFlag():Boolean {
        return isActive
    }

    fun getPrivacy():String {
        return privacy
    }

    fun getDMFlag():Boolean {
        return isDM
    }

    fun setChatRoomId(chatRoomId: String) {
        this.chatRoomId = chatRoomId
    }

    fun setLongitude(longitude: String) {
        this.longitude = longitude
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatRoom

        if (chatRoomId != other.chatRoomId) return false
        if (longitude != other.longitude) return false
        if (latitude != other.latitude) return false
        if (startDate != other.startDate) return false
        if (isActive != other.isActive) return false
        if (privacy != other.privacy) return false
        if (isDM != other.isDM) return false

        return true
    }

    override fun hashCode(): Int {
        var result = chatRoomId.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + latitude.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + isActive.hashCode()
        result = 31 * result + privacy.hashCode()
        result = 31 * result + isDM.hashCode()
        return result
    }


}