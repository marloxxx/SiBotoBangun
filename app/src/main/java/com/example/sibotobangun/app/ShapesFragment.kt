package com.example.sibotobangun.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R
import com.example.sibotobangun.app.shapes.*
import com.example.sibotobangun.utils.FragmentNavigation

class ShapesFragment : Fragment() {
    private lateinit var greetingTitle: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shapes, container, false)
//        change greeting text on greeting home activity
        greetingTitle = activity?.findViewById(R.id.greeting) as TextView
        greetingTitle.text = "Ayo belajar tentang bangun datar!"
        view.findViewById<View>(R.id.squareLink).setOnClickListener{
            val squareFragment = activity as FragmentNavigation
            squareFragment.navigateTo(SquareFragment(), true)
        }
        view.findViewById<View>(R.id.rectangleLink).setOnClickListener{
            val rectangleFragment = activity as FragmentNavigation
            rectangleFragment.navigateTo(RectangleFragment(), true)
        }
        view.findViewById<View>(R.id.triangleLink).setOnClickListener{
            val triangleFragment = activity as FragmentNavigation
            triangleFragment.navigateTo(TriangleFragment(), true)
        }
        view.findViewById<View>(R.id.circleLink).setOnClickListener{
            val circleFragment = activity as FragmentNavigation
            circleFragment.navigateTo(CircleFragment(), true)
        }
        view.findViewById<View>(R.id.trapezoidLink).setOnClickListener{
            val trapezoidFragment = activity as FragmentNavigation
            trapezoidFragment.navigateTo(TrapezoidFragment(), true)
        }
        view.findViewById<View>(R.id.parallelogramLink).setOnClickListener{
            val parallelogramFragment = activity as FragmentNavigation
            parallelogramFragment.navigateTo(ParallelogramFragment(), true)
        }
        view.findViewById<View>(R.id.kiteLink).setOnClickListener{
            val kiteFragment = activity as FragmentNavigation
            kiteFragment.navigateTo(KiteFragment(), true)
        }
        view.findViewById<View>(R.id.diamondLink).setOnClickListener{
            val diamondFragment = activity as FragmentNavigation
            diamondFragment.navigateTo(DiamondFragment(), true)
        }
        return view
    }
}