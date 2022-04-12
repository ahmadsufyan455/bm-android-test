package com.zerodev.bmandroidtest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zerodev.bmandroidtest.adapter.AppSavedAdapter
import com.zerodev.bmandroidtest.databinding.ActivitySavedBinding
import com.zerodev.bmandroidtest.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedBinding
    private val viewModel: AppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = SavedActivity::class.java.simpleName

        val appSavedAdapter = AppSavedAdapter()
        viewModel.getDataFromDb().observe(this) { appData ->
            if (appData != null && appData.isNotEmpty()) {
                appSavedAdapter.setData(appData)
                binding.noData.visibility = View.GONE
            } else {
                binding.noData.visibility = View.VISIBLE
                binding.rvItem.visibility = View.GONE
            }
        }

        with(binding.rvItem) {
            layoutManager = LinearLayoutManager(this@SavedActivity)
            setHasFixedSize(true)
            adapter = appSavedAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu_saved, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            viewModel.deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }
}