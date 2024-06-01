package com.example.sibotobangun.app.geometry

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class CylinderFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var volumeFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var radius: EditText
    private lateinit var height: EditText
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

        imageFigure.setImageResource(R.drawable.tabung)
        figureName.text = "Tabung"
        definition.text =
            "Tabung atau silinder adalah bangun ruang tiga dimensi yang dibentuk oleh dua buah lingkaran identik yang sejajar dan sebuah persegi panjang yang mengelilingi kedua lingkaran tersebut. Tabung memiliki 3 sisi dan 2 rusuk."
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
        areaFormula.text = "Luas permukaan tabung = 2 x π x r x (r + t)"
        volumeFormula.text = "Volume tabung = π x r x r x t"
        areaButton.text = "Hitung Luas"
        volumeButton.text = "Hitung Volume"

        areaButton.setOnClickListener {
            if (radius.text.isEmpty()){
                Toast.makeText(context, "Jari-jari tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val t = height.text.toString().toDouble()
                val area = 2 * Math.PI * r * (r + t)
                result.text = "Luas permukaan tabung = $area"
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
                val volume = Math.PI * r * r * t
                result.text = "Volume tabung = $volume"
            }
        }
        return view
    }
}
