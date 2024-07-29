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
            viewModel.login(binding.idInput.text.toString(),binding.PasswordField.text.toString())
        }

    }
    private fun loginSetup(){
        viewModel.userData.observe(viewLifecycleOwner, Observer { user->
            if(user?.item?.isSuccess==true){
                findNavController().navigate(ViewUserFragmentDirections.toViewUser())
            }
            else{
                Log.e(tag,"${user?.errorMessage}")
                Toast.makeText(requireContext(),"${user?.errorMessage}", Toast.LENGTH_LONG).show()
            }
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }
}