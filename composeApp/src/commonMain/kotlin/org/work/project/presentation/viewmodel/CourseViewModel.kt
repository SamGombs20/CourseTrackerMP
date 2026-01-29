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
    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()
    fun addCourse(course: Course){
        viewModelScope.launch {
            _courses.value = _courses.value + course
        }
    }
    fun setSelectedCourse(course: Course?){
        viewModelScope.launch {
            _selectedCourse.value = course
        }
    }
    fun editCourse(course: Course){
        viewModelScope.launch {
            _courses.value.forEachIndexed { index, c->
                if(c.id == course.id){
                    _courses.value = _courses.value.toMutableList().apply {
                        this[index] = course
                    }
                }
            }
        }
    }
    fun deleteCourse(course: Course){
        viewModelScope.launch {
            _courses.value = _courses.value.filter { it.id != course.id }
        }
    }
}