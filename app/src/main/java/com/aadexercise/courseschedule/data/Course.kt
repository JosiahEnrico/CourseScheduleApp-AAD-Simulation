package com.aadexercise.courseschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 1 : Define a local database table using the schema in app/schema/course.json
@Entity(tableName = DataCourseName.TABLE_NAME)
data class Course(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataCourseName.COL_ID)
    val id: Int = 0,

    @ColumnInfo(name = DataCourseName.COL_COURSE_NAME)
    @NonNull
    val courseName: String,

    @ColumnInfo(name = DataCourseName.COL_DAY)
    @NonNull
    val day: Int,

    @ColumnInfo(name = DataCourseName.COL_START_TIME)
    @NonNull
    val startTime: String,

    @ColumnInfo(name = DataCourseName.COL_END_TIME)
    @NonNull
    val endTime: String,

    @ColumnInfo(name = DataCourseName.COL_LECTURER)
    @NonNull
    val lecturer: String,

    @ColumnInfo(name = DataCourseName.COL_NOTE)
    @NonNull
    val note: String
)
