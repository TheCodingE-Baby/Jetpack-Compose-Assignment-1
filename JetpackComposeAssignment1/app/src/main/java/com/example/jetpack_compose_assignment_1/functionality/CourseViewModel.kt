package com.example.jetpack_compose_assignment_1.functionality

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CourseViewModel : ViewModel(){
    private val _courses = MutableStateFlow(CourseRepo.getSampleCourses())
    val courses: StateFlow<List<Courses>> = _courses

    fun toggleCourseExpansion(courseId: Int){
        _courses.value = _courses.value.map{ course ->
            if (course.cId == courseId){
                course.copy(isExpanded = !course.isExpanded)
            } else{
                course
            }
        }
    }
}