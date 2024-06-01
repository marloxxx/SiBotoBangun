package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class CircleFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var perimeterFormula: TextView
    private lateinit var formInput : LinearLayout
    private lateinit var radius: EditText
    private lateinit var areaButton: Button
    private lateinit var perimeterButton: Button
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
        formInput = view.findViewById(R.id.formInput)
        areaFormula = view.findViewById(R.id.areaFormula)
        perimeterFormula = view.findViewById(R.id.perimeterVolumeFormula)
        areaButton = view.findViewById(R.id.buttonArea)
        perimeterButton = view.findViewById(R.id.buttonPerimeterVolume)
        result = view.findViewById(R.id.result)

        imageFigure.setImageResource(R.drawable.lingkaran)
        figureName.text = "Lingkaran"
        definition.text =
            "Lingkaran adalah bangun datar dua dimensi yang terdiri dari titik pusat dan titik-titik pada garis yang sama jaraknya dari pusat sama dengan jari-jari."
        radius = EditText(context)
        radius.hint = "Masukkan jari-jari"
        radius.inputType = InputType.TYPE_CLASS_NUMBER
        radius.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(radius)
        areaFormula.text = "Luas = π x r x r"
        perimeterFormula.text = "Keliling = 2 x π x r"
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"

        areaButton.setOnClickListener {
            if (radius.text.toString().isEmpty()) {
                Toast.makeText(context, "Jari-jari tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val area = Math.PI * r * r
                result.text = "Luas lingkaran adalah $area"
            }
        }
        perimeterButton.setOnClickListener {
            if (radius.text.toString().isEmpty()) {
                Toast.makeText(context, "Jari-jari tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val perimeter = 2 * Math.PI * r
                result.text = "Keliling lingkaran adalah $perimeter"
            }
        }
        return view
    }
}
