package com.example.sibotobangun.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R
import com.example.sibotobangun.utils.FragmentNavigation

class DashboardFragment : Fragment(){
    private lateinit var greetingTitle: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        change greeting text on greeting home activity
        greetingTitle = activity?.findViewById(R.id.greeting) as TextView
        greetingTitle.text = "Selamat Datang di Siboto Bangun\nApa yang ingin kamu pelajari?"
        view.findViewById<View>(R.id.shapesLink).setOnClickListener{
            val shapesFragment = activity as FragmentNavigation
            shapesFragment.navigateTo(ShapesFragment(), true)
        }
        view.findViewById<View>(R.id.geometryLink).setOnClickListener{
            val geometryFragment = activity as FragmentNavigation
            geometryFragment.navigateTo(GeometryFragment(), true)
        }
        return view
    }
}