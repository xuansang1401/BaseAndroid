package com.t3h.basemvvm.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.t3h.basemvvm.data.model.db.HistoryModel

@Dao
interface DatabaseDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun addHis(historyModel: HistoryModel)

    @Query("Select * from HistoryModel ORDER BY time DESC limit 20")
    fun getAllHistory(): LiveData<List<HistoryModel>>
}