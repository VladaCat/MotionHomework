package com.example.motionexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myCatsDb")
data class MyCatsDb(
@ColumnInfo(name = "catName") val catName: String?,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var catId: Long = 0
}