package com.tarun.roommvvm.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tarun.roommvvm.R
import com.tarun.roommvvm.db.UserEntity
import com.tarun.roommvvm.viewmodel.MainViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
        }

        view.findViewById<Button>(R.id.insert).setOnClickListener {
            insertData()
        }

        view.findViewById<Button>(R.id.delete).setOnClickListener {
            deleteAllData()
        }

        viewModel.observeUserData().observe(viewLifecycleOwner, {
            //every time data is inserted or updated this will update data here
            Log.e("tarun", it.toString())
        })
    }


    private fun insertData() {
        val entity = UserEntity(
            currentDateAndTime = System.currentTimeMillis().toString(),
            name = "Tarun",
            age = 30
        )
        viewModel.storeData(entity)
    }

    private fun deleteAllData() {
        viewModel.delete()
    }
}