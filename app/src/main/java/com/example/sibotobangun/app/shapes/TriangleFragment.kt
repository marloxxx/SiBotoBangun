package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class TriangleFragment : Fragment() {
    private lateinit var imageFigure : ImageView
    private lateinit var figureName : TextView
    private lateinit var definition : TextView
    private lateinit var areaFormula : TextView
    private lateinit var perimeterFormula : TextView
    private lateinit var formInput : LinearLayout
    private lateinit var base : EditText
    private lateinit var height : EditText
    private lateinit var areaButton : Button
    private lateinit var perimeterButton : Button
    private lateinit var result : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        imageFigure = view.findViewById(R.id.image_figure)
        figureName = view.findViewById(R.id.figure_name)
        definition = view.findViewById(R.id.definition)
        areaFormula = view.findViewById(R.id.areaFormula)
        perimeterFormula = view.findViewById(R.id.perimeterVolumeFormula)
        formInput = view.findViewById(R.id.formInput)
        areaButton = view.findViewById(R.id.buttonArea)
        perimeterButton = view.findViewById(R.id.buttonPerimeterVolume)
        result = view.findViewById(R.id.result)

        imageFigure.setImageResource(R.drawable.segitiga)
        figureName.text = "Segitiga"
        definition.text = "Segitiga adalah bangun datar dua dimensi yang dibatasi oleh tiga buah rusuk yang berbentuk garis lurus. Segitiga memiliki tiga buah titik sudut dan tiga buah rusuk."
        areaFormula.text = "Luas = 1/2 x a x t"
        perimeterFormula.text = "Keliling = a + b + c"
        base = EditText(context)
        base.inputType = InputType.TYPE_CLASS_NUMBER
        base.setHintTextColor(resources.getColor(R.color.black))
        base.hint = "Masukkan alas"
        height = EditText(context)
        height.inputType = InputType.TYPE_CLASS_NUMBER
        height.setHintTextColor(resources.getColor(R.color.black))
        height.hint = "Masukkan tinggi"
        formInput.addView(base)
        formInput.addView(height)
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"

        areaButton.setOnClickListener {
            val a = base.text.toString().toDouble()
            val t = height.text.toString().toDouble()
            val area = 0.5 * a * t
            result.text = "Luas = $area"
        }
        perimeterButton.setOnClickListener {
            val a = base.text.toString().toDouble()
            val perimeter = 3 * a
            result.text = "Keliling = $perimeter"
        }
        return view
    }
}
