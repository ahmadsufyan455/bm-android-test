package com.zerodev.bmandroidtest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zerodev.bmandroidtest.adapter.AppAdapter
import com.zerodev.bmandroidtest.adapter.OnClickListener
import com.zerodev.bmandroidtest.databinding.ActivityMainBinding
import com.zerodev.bmandroidtest.model.AppModel
import com.zerodev.bmandroidtest.viewmodel.AppViewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appAdapter: AppAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appAdapter = AppAdapter(OnClickListener {
            viewModel.insertData(it)
        })

        viewModel.setData()
        viewModel.getData().observe(this) { appData ->
            if (appData != null) {
                appAdapter.setData(appData)
            }
        }

        /*** it's possible to display json object (date key) to list of recyclerview ?
        correct me if I wrong
        I found this response
        {
        "key": []
        "key": []
        so on...
        }
         ***/

        with(binding.rvItem) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = appAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.saved) {
            startActivity(Intent(this, SavedActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}