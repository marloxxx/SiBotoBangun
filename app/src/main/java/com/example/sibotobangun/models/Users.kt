package com.example.sibotobangun.models

class Users {
    private val userList = mutableListOf(
        User("1234567890", "Horas Siregar","081234567891", "horas@gmail.com", "password")
    )

    fun getUserList(): List<User> {
        return userList
    }

    fun addUser(user: User) {
        userList.add(user)
    }
}