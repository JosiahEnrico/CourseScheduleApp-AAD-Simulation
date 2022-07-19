package com.aadexercise.courseschedule.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aadexercise.courseschedule.data.Course
import com.aadexercise.courseschedule.data.DataRepository
import com.aadexercise.courseschedule.util.QueryType

class HomeViewModel(private val repository: DataRepository): ViewModel() {

    private val _queryType = MutableLiveData<QueryType>()

    init {
        _queryType.value = QueryType.CURRENT_DAY
    }

    fun setQueryType(queryType: QueryType) {
        _queryType.value = queryType
    }

    fun getNearestSchedule(queryType: QueryType): LiveData<Course?> {
        return repository.getNearestSchedule(queryType)
    }
}
