package org.work.project.model

class CourseCreate(
    val name: String,
    val category: String,
    val description: String,
    val status: String,
    val startDate: String,
    val endDate: String,
    val rating: String
)
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