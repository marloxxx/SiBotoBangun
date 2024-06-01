package com.example.sibotobangun.app.geometry

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class ConeFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var volumeFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var radius: EditText
    private lateinit var height: EditText
    private lateinit var slantHeight: EditText
    private lateinit var areaButton: Button
    private lateinit var volumeButton: Button
    private lateinit var result: TextView

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
        volumeFormula = view.findViewById(R.id.perimeterVolumeFormula)
        formInput = view.findViewById(R.id.formInput)
        areaButton = view.findViewById(R.id.buttonArea)
        volumeButton = view.findViewById(R.id.buttonPerimeterVolume)
        result = view.findViewById(R.id.result)

        imageFigure.setImageResource(R.drawable.kerucut)
        figureName.text = "Kerucut"
        definition.text = "Dalam geometri, kerucut adalah sebuah limas istimewa yang beralas lingkaran. Kerucut memiliki 2 sisi, 1 rusuk, dan 1 titik sudut."
        radius = EditText(context)
        radius.hint = "Masukkan jari-jari"
        radius.inputType = InputType.TYPE_CLASS_NUMBER
        radius.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(radius)
        height = EditText(context)
        height.hint = "Masukkan tinggi"
        height.inputType = InputType.TYPE_CLASS_NUMBER
        height.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(height)
        slantHeight = EditText(context)
        slantHeight.hint = "Masukkan garis pelukis"
        slantHeight.inputType = InputType.TYPE_CLASS_NUMBER
        slantHeight.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(slantHeight)
        areaFormula.text = "Luas permukaan kerucut = π x r x (r + s)"
        volumeFormula.text = "Volume kerucut = 1/3 x π x r x r x t"
        areaButton.text = "Hitung Luas"
        volumeButton.text = "Hitung Volume"

        areaButton.setOnClickListener {
            if (radius.text.isEmpty()){
                Toast.makeText(context, "Jari-jari tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (slantHeight.text.isEmpty()){
                Toast.makeText(context, "Garis pelukis tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val s = slantHeight.text.toString().toDouble()
                val area = Math.PI * r * (r + s)
                result.text = "Luas permukaan kerucut = $area"
            }
        }

        volumeButton.setOnClickListener {
            if (radius.text.isEmpty()){
                Toast.makeText(context, "Jari-jari tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val t = height.text.toString().toDouble()
                val volume = 1/3 * Math.PI * r * r * t
                result.text = "Volume kerucut = $volume"
            }
        }
        return view
    }
}
