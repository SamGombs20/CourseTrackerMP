package org.work.project.model


class UserCreate(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
)
class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val username: String,
    val createdAt: String
)
class UserLogin(
    val username: String,
    val password: String
)