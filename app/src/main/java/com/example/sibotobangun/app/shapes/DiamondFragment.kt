package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class DiamondFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var perimeterFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var side: EditText
    private lateinit var diagonal1: EditText
    private lateinit var diagonal2: EditText
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
        areaFormula = view.findViewById(R.id.areaFormula)
        perimeterFormula = view.findViewById(R.id.perimeterVolumeFormula)
        formInput = view.findViewById(R.id.formInput)
        areaButton = view.findViewById(R.id.buttonArea)
        perimeterButton = view.findViewById(R.id.buttonPerimeterVolume)
        result = view.findViewById(R.id.result)

        imageFigure.setImageResource(R.drawable.belahketupat)
        figureName.text = "Belah Ketupat"
        definition.text =
            "Belah ketupat adalah bangun datar dua dimensi yang memiliki empat buah rusuk yang sama panjang dan empat buah sudut yang sama besar. Belah ketupat memiliki dua buah diagonal yang saling berpotongan pada titik sudut."
        areaFormula.text = "Luas = d1 x d2 / 2"
        side = EditText(context)
        side.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        side.setHintTextColor(resources.getColor(R.color.black))
        side.hint = "Masukkan panjang sisi"
        diagonal1 = EditText(context)
        diagonal1.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        diagonal1.setHintTextColor(resources.getColor(R.color.black))
        diagonal1.hint = "Masukkan diagonal 1"
        formInput.addView(diagonal1)
        diagonal2 = EditText(context)
        diagonal2.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        diagonal2.setHintTextColor(resources.getColor(R.color.black))
        diagonal2.hint = "Masukkan diagonal 2"
        formInput.addView(diagonal2)
        areaFormula.text = "Luas = d1 x d2 / 2"
        perimeterFormula.text = "Keliling = 4 x s"
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"

        areaButton.setOnClickListener {
            if (diagonal1.text.toString().isEmpty()) {
                Toast.makeText(context, "Diagonal 1 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (diagonal2.text.toString().isEmpty()) {
                Toast.makeText(context, "Diagonal 2 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val d1 = diagonal1.text.toString().toDouble()
                val d2 = diagonal2.text.toString().toDouble()
                val area = d1 * d2 / 2
                result.text = "Luas belah ketupat adalah $area"
            }
        }

        perimeterButton.setOnClickListener {
            if (side.text.toString().isEmpty()) {
                Toast.makeText(context, "Sisi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val s = side.text.toString().toDouble()
                val perimeter = 4 * s
                result.text = "Keliling belah ketupat adalah $perimeter"
            }
        }
        return view
    }
}
