package com.anzeh.databindingadapter.ui.activityes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anzeh.databindingadapter.R
import com.anzeh.databindingadapter.ui.activityes.adapter.UsersRecyclerAdapter
import com.anzeh.databindingadapter.binding.setOnItemClickListener
import com.anzeh.databindingadapter.data.model.User
import com.anzeh.databindingadapter.databinding.ActivityMainBinding
import com.anzeh.databindingadapter.ui.base.adapter.BaseBindingRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    var usersList = arrayListOf<User>()
    lateinit var usersRecyclerAdapter: UsersRecyclerAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(
            LayoutInflater.from(this), null, false
        )
        setContentView(binding.root)

        fillData()
    }

    private fun fillData() {
        usersList.add(User(0, "Mohammed", R.drawable.persone, "+96278962846"))
        usersList.add(User(1, "Essam", R.drawable.img_persone, "+4848154445"))
        usersList.add(User(2, "Saad", R.drawable.persone, "+9635963598"))
        usersList.add(User(3, "Ahmed", R.drawable.img_persone, "+9627854555"))

        setUpAdapter()
    }

    private fun setUpAdapter() {
        usersRecyclerAdapter = UsersRecyclerAdapter(this)
        usersRecyclerAdapter.submitItems(usersList)
        applyAdapter()
    }

    private fun applyAdapter() {
        binding.rvUsers.adapter = usersRecyclerAdapter

        binding.rvUsers.setOnItemClickListener(object :
            BaseBindingRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View?, position: Int, item: Any) {
                val user = item as User
                Toast.makeText(this@MainActivity, user.name, Toast.LENGTH_LONG).show()
            }
        })

    }
}