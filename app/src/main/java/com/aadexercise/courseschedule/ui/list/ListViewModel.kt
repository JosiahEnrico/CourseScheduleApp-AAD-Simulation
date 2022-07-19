package com.aadexercise.courseschedule.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aadexercise.courseschedule.data.Course
import com.aadexercise.courseschedule.data.DataRepository
import com.aadexercise.courseschedule.util.SortType

class ListViewModel(private val repository: DataRepository) : ViewModel() {

    private val _sortParams = MutableLiveData<SortType>()

    init {
        _sortParams.value = SortType.TIME
    }

    val courses = Transformations.switchMap(_sortParams) {
        repository.getAllCourse(it)
    }

    fun sort(newValue: SortType) {
        _sortParams.value = newValue
    }

    fun delete(course: Course) {
        repository.delete(course)
    }
}