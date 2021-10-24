package com.example.motionexample

import androidx.room.*

@Dao
interface MyCatsDao {
    @Query("SELECT * FROM myCatsDb")
    fun getAll(): List<MyCatsDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCat(cat: MyCatsDb): Long

    @Query("SELECT * FROM myCatsDb WHERE id = :catId")
    fun getCat(catId: Long): MyCatsDb

    @Update
    fun updateCat(catDb: MyCatsDb)

    @Query("DELETE FROM myCatsDb WHERE id = :catId")
    fun deleteCat(catId: Long)
}