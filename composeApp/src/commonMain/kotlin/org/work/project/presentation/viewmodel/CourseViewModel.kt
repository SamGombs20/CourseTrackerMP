package org.work.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.work.project.api.AuthApi
import org.work.project.model.course.Course

class CourseViewModel(private val authApi: AuthApi): ViewModel() {
    private val _allCourses = MutableStateFlow(emptyList<Course>())
    private val _filteredCourses = MutableStateFlow(emptyList<Course>())
    val courseList: StateFlow<List<Course>> = _filteredCourses.asStateFlow()
    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse.asStateFlow()
    val allCourses: StateFlow<List<Course>> = _allCourses.asStateFlow()

    fun getCourses(){
        viewModelScope.launch {
            _allCourses.value = authApi.getCourses()
            if (!_allCourses.value.isEmpty()){
                _filteredCourses.value = _allCourses.value

            }
        }
    }
    fun addCourse(course: Course){
        viewModelScope.launch {
            _allCourses.value = _allCourses.value + course
            _filteredCourses.value = _allCourses.value
        }
    }
    fun resetCourses(){
        viewModelScope.launch {
            _allCourses.value = emptyList()
            _filteredCourses.value = emptyList()
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
                    _allCourses.value = _allCourses.value.toMutableList().apply {
                        this[index] = course
                    }
                }
            }
            _filteredCourses.value = _allCourses.value
        }
    }
    fun deleteCourse(course: Course){
        viewModelScope.launch {
            _allCourses.value = _allCourses.value.filter { it.id != course.id }
            _filteredCourses.value = _allCourses.value
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