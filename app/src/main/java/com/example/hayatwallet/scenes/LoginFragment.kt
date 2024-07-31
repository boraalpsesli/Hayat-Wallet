package com.example.hayatwallet.scenes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLandingBinding
import com.example.hayatwallet.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginSetup()
        binding.LogInButton.setOnClickListener {
            val tempId="ararat2@oktein.com"
            val tempPass="123456789Aa@"
            //Do not forget to give input field values later
            viewModel.login(tempId,tempPass)
        }

    }
    private fun loginSetup(){
        viewModel.loginData.observe(viewLifecycleOwner, Observer { login->
            if(login?.item?.isSuccess==true){
                viewModel.getUser()
            }

        })
        viewModel.userData.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(TabLayoutFragmentDirections.toHub())

        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }
}