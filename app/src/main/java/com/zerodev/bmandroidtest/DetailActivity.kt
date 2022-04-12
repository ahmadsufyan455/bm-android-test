package com.zerodev.bmandroidtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zerodev.bmandroidtest.databinding.ActivityDetailBinding
import com.zerodev.bmandroidtest.model.AppModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = DetailActivity::class.java.simpleName

        val appData = intent.getParcelableExtra<AppModel>(EXTRA_DETAIL)

        binding.label.text = appData?.label
        binding.nbVisits.text = appData?.nbVisit.toString()
        binding.nbHits.text = appData?.nbHits.toString()
        binding.sumTimeSpent.text = appData?.sumTimeSpent.toString()
        binding.nbHitsWithTimeGeneration.text = appData?.nbHitsWithTimeGeneration.toString()
        binding.minTimeGeneration.text = appData?.minTimeGeneration
        binding.maxTimeGeneration.text = appData?.maxTimeGeneration
        binding.bounceRate.text = appData?.bounceRate
        binding.exitRate.text = appData?.exitRate
    }
}