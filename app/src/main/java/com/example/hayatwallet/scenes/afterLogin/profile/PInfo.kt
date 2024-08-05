package com.example.hayatwallet.scenes.afterLogin.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.databinding.FragmentPInfoBinding
import com.example.hayatwallet.scenes.NameSharedPref
import com.example.hayatwallet.scenes.afterLogin.profile.viewModel.UserViewModel
import com.example.hayatwallet.scenes.landingPage.LandingFragmentDirections
import java.util.jar.Attributes.Name

class PInfo : Fragment() {
    private lateinit var binding:FragmentPInfoBinding
    private val viewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        setupUserProfile()

        binding.forgetInfo.setOnClickListener { NameSharedPref.clear()
        findNavController().navigate(LandingFragmentDirections.LogingOut())}


    }
    fun setupUserProfile(){
        viewModel.userData.observe(viewLifecycleOwner, Observer { user->
            binding.name.text=user?.item?.firstName+" "+" "+user?.item?.lastName
            binding.mail.text=user?.item?.email
            NameSharedPref.putString("full_name",user?.item?.firstName)
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            PInfo()
    }
}