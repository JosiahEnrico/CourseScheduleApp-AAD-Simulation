package com.aadexercise.courseschedule.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aadexercise.courseschedule.data.Course
import com.aadexercise.courseschedule.data.DataRepository

class DetailViewModel(private val repository: DataRepository, courseId: Int) : ViewModel() {

    val course: LiveData<Course> = repository.getCourse(courseId)

    fun delete() {
        course.value?.let {
            repository.delete(it)
        }
    }
}