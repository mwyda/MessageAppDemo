package com.example.myapplication

import java.io.File

/**
 * Describes a message object that can be sent by users.
 */
class Message(private var messageId: String, private var chatRoomId: String, private var messageContent: String,
              private var messageAttachments: ArrayList<File>) {

    /**
     * Getter for message unique identifier
     */
    fun getMessageId(): String {
        return this.messageId
    }

    /**
     * Getter for chat room foreign key
     */
    fun getChatRoomId(): String {
        return this.chatRoomId
    }

    /**
     * Getter for the message content (text)
     */
    fun getMessageContent(): String {
        return this.messageContent
    }

    /**
     * Getter for the attachments on the message
     */
    fun getMessageAttachments(): ArrayList<File> {
        return this.messageAttachments
    }

    /**
     * Setter for the unique identifier for a message
     */
    fun setMessageId(messageId:String) {
        this.messageId = messageId
    }

    /**
     * Setter for the foreign key to the Chat Room
     */
    fun setChatRoomId(chatRoomId: String) {
        this.chatRoomId = chatRoomId
    }

    /**
     * Setter for the content of a message
     */
    fun setMessageContent(messageContent: String) {
        this.messageContent = messageContent
    }

    /**
     * Setter for the file attachments to a message
     */
    fun setFileAttachments(fileAttachments:ArrayList<File>) {
        this.messageAttachments = fileAttachments
    }

    /**
     * Overrides the equals operator
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (messageId != other.messageId) return false
        if (chatRoomId != other.chatRoomId) return false
        if (messageContent != other.messageContent) return false
        if (messageAttachments != other.messageAttachments) return false

        return true
    }

    /**
     * Overrides the hashcode function
     */
    override fun hashCode(): Int {
        var result = messageId.hashCode()
        result = 31 * result + chatRoomId.hashCode()
        result = 31 * result + messageContent.hashCode()
        result = 31 * result + messageAttachments.hashCode()
        return result
    }

    /**
     * Overrides the toString method
     */
    override fun toString(): String {
        return "Message(messageId='$messageId', chatRoomId='$chatRoomId', messageContent='$messageContent', messageAttachments=$messageAttachments)"
    }

    fun addFileAttachment(fileList: ArrayList<File>) {
        this.messageAttachments.addAll(fileList)
    }

}