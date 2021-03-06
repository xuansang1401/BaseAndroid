package com.t3h.basemvvm.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryModel(
    @PrimaryKey val id_his: String,
    val title: String,
    val time:Long,
)