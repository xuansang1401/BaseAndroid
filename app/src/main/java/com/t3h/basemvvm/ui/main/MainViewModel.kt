package com.t3h.basemvvm.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.t3h.basemvvm.data.model.db.HistoryModel
import com.t3h.basemvvm.data.room.DatabaseDao

class MainViewModel @ViewModelInject constructor(
    private val dao: DatabaseDao
): ViewModel(){
    fun addData(historyModel: HistoryModel) {
        dao.addHis(historyModel)
    }
    fun getAll()=  dao.getAllHistory()
}