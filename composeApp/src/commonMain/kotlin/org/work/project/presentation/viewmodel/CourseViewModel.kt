package org.work.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.work.project.model.Course
import org.work.project.model.courses

class CourseViewModel: ViewModel() {
    private val _courses = MutableStateFlow(courses)
    val courseList: StateFlow<List<Course>> = _courses.asStateFlow()

    fun addCourse(course: Course){
        viewModelScope.launch {
            _courses.value = _courses.value + course
        }
    }
}