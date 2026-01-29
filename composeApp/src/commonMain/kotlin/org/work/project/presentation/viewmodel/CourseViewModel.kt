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
    private val _allCourses = MutableStateFlow(emptyList<Course>())
    private val _filteredCourses = MutableStateFlow(emptyList<Course>())
    val courseList: StateFlow<List<Course>> = _filteredCourses.asStateFlow()
    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()

    init {
        setCourses(courses)
    }
    fun setCourses(courses: List<Course>){
        viewModelScope.launch {
            _allCourses.value = courses
            _filteredCourses.value = courses
        }
    }
    fun addCourse(course: Course){
        viewModelScope.launch {
            _allCourses.value = _allCourses.value + course
            _filteredCourses.value = _allCourses.value
        }
    }
    fun setSelectedCourse(course: Course?){
        viewModelScope.launch {
            _selectedCourse.value = course
        }
    }
    fun editCourse(course: Course){
        viewModelScope.launch {
            _allCourses.value.forEachIndexed { index, c->
                if(c.id == course.id){
                    _filteredCourses.value = _allCourses.value.toMutableList().apply {
                        this[index] = course
                    }
                }
            }
        }
    }
    fun deleteCourse(course: Course){
        viewModelScope.launch {
            _allCourses.value = _allCourses.value.filter { it.id != course.id }
        }
    }
    fun filterCoursesByStatus(status:String){
        viewModelScope.launch {
            if (status =="All"){
                _filteredCourses.value = _allCourses.value
                return@launch
            }
            _filteredCourses.value = _allCourses.value.filter { it.status ==status }
        }
    }
}