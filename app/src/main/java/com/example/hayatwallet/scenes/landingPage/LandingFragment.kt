package com.example.hayatwallet.scenes.landingPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.databinding.FragmentLandingBinding
import com.example.hayatwallet.scenes.NameSharedPref
import com.example.hayatwallet.scenes.login.LoginFragmentDirections
import com.example.hayatwallet.scenes.login.LoginFragmentSharedPref
import com.example.hayatwallet.scenes.login.LoginFragmentSharedPrefDirections
import java.util.jar.Attributes.Name

class LandingFragment : Fragment() {

    private lateinit var binding:FragmentLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          NameSharedPref.init(requireContext())
        binding.RegisteredButton.setOnClickListener {
            val tempToken=NameSharedPref.getString("user_token")
            val tempId=NameSharedPref.getString("user_ID")
            if(tempId!=null){
                findNavController().navigate(LoginFragmentSharedPrefDirections.toSharedPrefLogin())
            }
            else{findNavController().navigate(
                LoginFragmentDirections.toLoginActivity()
            )}

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LandingFragment()
    }
}