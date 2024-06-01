package com.example.sibotobangun.app.geometry

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class SphereFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var volumeFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var radius: EditText
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

        imageFigure.setImageResource(R.drawable.bola)
        figureName.text = "Bola"
        definition.text =
            "Bola sebagai bangun ruang adalah bangun dengan sisi lengkung yang tersusun dari lingkaran yang tidak terhingga. Lingkaran ini berpusat di satu titik, yaitu titik pusat bangun ruang bola."
        radius = EditText(context)
        radius.hint = "Masukkan jari-jari"
        radius.inputType = InputType.TYPE_CLASS_NUMBER
        radius.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(radius)
        areaFormula.text = "Luas permukaan = 4 x π x r²"
        volumeFormula.text = "Volume = 4/3 x π x r³"
        areaButton.text = "Hitung Luas"
        volumeButton.text = "Hitung Volume"

        areaButton.setOnClickListener {
            if (radius.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan jari-jari", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val area = 4 * Math.PI * r * r
                result.text = "Luas permukaan = $area"
            }
        }

        volumeButton.setOnClickListener {
            if (radius.text.toString().isEmpty()) {
                Toast.makeText(context, "Masukkan jari-jari", Toast.LENGTH_SHORT).show()
            } else {
                val r = radius.text.toString().toDouble()
                val volume = 4 / 3 * Math.PI * r * r * r
                result.text = "Volume = $volume"
            }
        }
        return view
    }
}
