package com.zerodev.bmandroidtest.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class AppModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("label")
    val label: String,

    @SerializedName("nb_visits")
    val nbVisit: Long,

    @SerializedName("nb_hits")
    val nbHits: Long,

    @SerializedName("sum_time_spent")
    val sumTimeSpent: Long,

    @SerializedName("nb_hits_with_time_generation")
    val nbHitsWithTimeGeneration: Long,

    @SerializedName("min_time_generation")
    val minTimeGeneration: String,

    @SerializedName("max_time_generation")
    val maxTimeGeneration: String,

    @SerializedName("sum_bandwidth")
    val sumBandwidth: Long,

    @SerializedName("nb_hits_with_bandwidth")
    val nbHitsWithBandwidth: Long,

    @SerializedName("sum_daily_nb_uniq_visitors")
    val sumDailyNbUniqVisitors: Long,

    @SerializedName("entry_nb_visits")
    val entryNbVisits: Long,

    @SerializedName("entry_nb_actions")
    val entryNbActions: Long,

    @SerializedName("entry_sum_visit_length")
    val entrySumVisitLength: Long,

    @SerializedName("entry_bounce_count")
    val entryBounceCount: Long,

    @SerializedName("exit_nb_visits")
    val exitNbVisits: Long,

    @SerializedName("sum_daily_entry_nb_uniq_visitors")
    val sumDailyEntryNbUniqVisitors: Long,

    @SerializedName("sum_daily_exit_nb_uniq_visitors")
    val sumDailyExitNbUniqVisitors: Long,

    @SerializedName("avg_bandwidth")
    val avgBandwidth: Long,

    @SerializedName("avg_time_on_page")
    val avgTimeOnPage: Long,

    @SerializedName("bounce_rate")
    val bounceRate: String,

    @SerializedName("exit_rate")
    val exitRate: String,

    @SerializedName("avg_time_generation")
    val avgTimeGeneration: Double
) : Parcelable
