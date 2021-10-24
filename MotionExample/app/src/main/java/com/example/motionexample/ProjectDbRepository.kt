package com.example.motionexample

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectDbRepository @Inject constructor(private val catsDbDao: MyCatsDao) {

    fun getAllCats() = catsDbDao.getAll()

    fun getCat(id: Long) = catsDbDao.getCat(id)

    fun insertCat(projectDb: MyCatsDb): Long = catsDbDao.insertCat(projectDb)

    fun updateCat(projectDb: MyCatsDb) = catsDbDao.updateCat(projectDb)

    fun deleteCat(id: Long) = catsDbDao.deleteCat(id)
}