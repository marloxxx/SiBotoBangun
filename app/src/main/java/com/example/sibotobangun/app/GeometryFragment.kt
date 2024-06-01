package com.example.sibotobangun.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R
import com.example.sibotobangun.app.geometry.*
import com.example.sibotobangun.utils.FragmentNavigation

class GeometryFragment: Fragment() {
    private lateinit var greetingTitle: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_geometry, container, false)
//        change greeting text on greeting home activity
        greetingTitle = activity?.findViewById(R.id.greeting) as TextView
        greetingTitle.text = "Ayo belajar tentang menghitung bangun ruang!"
        view.findViewById<View>(R.id.cubeLink).setOnClickListener{
            val cubeFragment = activity as FragmentNavigation
            cubeFragment.navigateTo(CubeFragment(), true)
        }
        view.findViewById<View>(R.id.cuboidsLink).setOnClickListener{
            val cuboidsFragment = activity as FragmentNavigation
            cuboidsFragment.navigateTo(CuboidsFragment(), true)
        }
        view.findViewById<View>(R.id.prismLink).setOnClickListener{
            val prismFragment = activity as FragmentNavigation
            prismFragment.navigateTo(PrismFragment(), true)
        }
        view.findViewById<View>(R.id.sphereLink).setOnClickListener{
            val sphereFragment = activity as FragmentNavigation
            sphereFragment.navigateTo(SphereFragment(), true)
        }
        view.findViewById<View>(R.id.coneLink).setOnClickListener{
            val coneFragment = activity as FragmentNavigation
            coneFragment.navigateTo(ConeFragment(), true)
        }
        view.findViewById<View>(R.id.cylinderLink).setOnClickListener{
            val cylinderFragment = activity as FragmentNavigation
            cylinderFragment.navigateTo(CylinderFragment(), true)
        }
        return view
    }
}