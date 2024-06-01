package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class RectangleFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName : TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula : TextView
    private lateinit var perimeterFormula : TextView
    private lateinit var formInput : LinearLayout
    private lateinit var length : EditText
    private lateinit var width : EditText
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

        imageFigure.setImageResource(R.drawable.persegipanjang)
        figureName.text = "Persegi Panjang"
        definition.text = "Persegi panjang adalah bangun datar dua dimensi yang memiliki empat sisi yang dua pasangnya sejajar dan empat sudut yang sama besar. Persegi panjang memiliki empat buah titik sudut dan empat buah rusuk."
        areaFormula.text = "Luas = p x l"
        length = EditText(context)
        length.inputType = InputType.TYPE_CLASS_NUMBER
        length.setHintTextColor(resources.getColor(R.color.black))
        length.hint = "Masukkan panjang"
        width = EditText(context)
        width.inputType = InputType.TYPE_CLASS_NUMBER
        width.setHintTextColor(resources.getColor(R.color.black))
        width.hint = "Masukkan lebar"
        formInput.addView(length)
        formInput.addView(width)
        perimeterFormula.text = "Keliling = 2 x (p + l)"

        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"
        areaButton.setOnClickListener {
            if (length.text.toString().isEmpty()){
                Toast.makeText(context, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (width.text.toString().isEmpty()){
                Toast.makeText(context, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val area = length.text.toString().toInt() * width.text.toString().toInt()
                result.text = "Luas persegi panjang adalah $area"
            }
        }

        perimeterButton.setOnClickListener {
            if (length.text.toString().isEmpty()){
                Toast.makeText(context, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (width.text.toString().isEmpty()){
                Toast.makeText(context, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val perimeter = 2 * (length.text.toString().toInt() + width.text.toString().toInt())
                result.text = "Keliling persegi panjang adalah $perimeter"
            }
        }
        return view
    }
}
