package org.work.project.model.course

import kotlinx.serialization.Serializable

@Serializable
class CourseCreate(
    val name: String,
    val category: String,
    val description: String,
    val status: String,
    val startDate: String,
    val endDate: String,
    val rating: String
)
@Serializable
class Course(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val status: String,
    val startDate: String,
    val endDate: String,
    val rating: String
)

@Serializable
class Message(
    val message: String
)