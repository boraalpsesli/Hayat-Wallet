package com.example.hayatwallet.scenes.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLoginBinding
import com.example.hayatwallet.databinding.FragmentLoginSharedPrefBinding
import com.example.hayatwallet.scenes.NameSharedPref
import com.example.hayatwallet.scenes.afterLogin.TabLayoutFragmentDirections
import com.example.hayatwallet.scenes.login.viewModel.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class LoginFragmentSharedPref : Fragment() {
    private lateinit var binding: FragmentLoginSharedPrefBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginSharedPrefBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginSetup()

        binding.welcomeMessage.text="Hoş Geldiniz " + NameSharedPref.getString("user_ID")
        binding.LogInButton.setOnClickListener {
            val tempPass="123456789Aa@"
            val tempId=NameSharedPref.getString("user_ID")
            //Do not forget to give input field values later
            viewModel.login(tempId,tempPass)
        }

    }
    private fun loginSetup(){
        viewModel.loginData.observe(viewLifecycleOwner, Observer { login->
            if(login?.item?.isSuccess==true){
                Log.e("Token","${login.item.token}")
                Snackbar.make(binding.root, "Başarılı Giriş  ${NameSharedPref.getString("full_name")}", Snackbar.LENGTH_LONG).show()
                findNavController().navigate(TabLayoutFragmentDirections.toHub())
            }

        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragmentSharedPref()
    }
}