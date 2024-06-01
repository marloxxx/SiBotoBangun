package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class SquareFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName : TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula : TextView
    private lateinit var perimeterFormula : TextView
    private lateinit var formInput : LinearLayout
    private lateinit var side : EditText
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

        imageFigure.setImageResource(R.drawable.persegi)
        figureName.text = "Persegi"
        definition.text = "Persegi adalah bangun datar dua dimensi yang memiliki empat sisi yang sama panjang dan empat sudut yang sama besar. Persegi memiliki empat buah titik sudut dan empat buah rusuk."
        areaFormula.text = "Luas = s x s"
        side = EditText(context)
        side.inputType = InputType.TYPE_CLASS_NUMBER
        side.setHintTextColor(resources.getColor(R.color.black))
        side.hint = "Masukkan sisi"
        formInput.addView(side)
        perimeterFormula.text = "Keliling = 4 x s"
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"

        areaButton.setOnClickListener {
            if (side.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan sisi", Toast.LENGTH_SHORT).show()
            } else {
                val s = side.text.toString().toDouble()
                val luas = s * s
                result.text = "Luas = $luas"
            }
        }

        perimeterButton.setOnClickListener {
            if (side.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan sisi", Toast.LENGTH_SHORT).show()
            } else {
                val s = side.text.toString().toDouble()
                val keliling = 4 * s
                result.text = "Keliling = $keliling"
            }
        }
        return view
    }
}