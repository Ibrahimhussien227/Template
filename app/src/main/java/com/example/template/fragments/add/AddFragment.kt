package com.example.template.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.template.R
import com.example.template.model.User
import com.example.template.model.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.btn_add.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val firsName = et_firstName.text.toString()
        val email = et_userEmail.text.toString()
        val age = et_age.text

        if (inputCheck(firsName, email, age)) {

            val user = User(0, firsName, email, Integer.parseInt(age.toString()))

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill the all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, email: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(email) && age.isEmpty())
    }
}