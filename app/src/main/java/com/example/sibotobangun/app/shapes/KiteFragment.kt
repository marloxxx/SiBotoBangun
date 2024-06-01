package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class KiteFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName : TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula : TextView
    private lateinit var perimeterFormula : TextView
    private lateinit var formInput : LinearLayout
    private lateinit var side1 : EditText
    private lateinit var side2 : EditText
    private lateinit var diagonal1 : EditText
    private lateinit var diagonal2 : EditText
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

        imageFigure.setImageResource(R.drawable.jajargenjang)
        figureName.text = "Layang-layang"
        definition.text =
            "Layang-layang adalah bangun datar dua dimensi yang memiliki dua pasang diagonal yang saling sejajar dan sejajar dengan dua pasang sisi yang saling tegak lurus. Layang-layang memiliki empat buah titik sudut dan empat buah rusuk."
        areaFormula.text = "Luas = d1 x d2 / 2"
        side1 = EditText(context)
        side1.inputType = InputType.TYPE_CLASS_NUMBER
        side1.setHintTextColor(resources.getColor(R.color.black))
        side1.hint = "Masukkan sisi 1"
        side2 = EditText(context)
        side2.inputType = InputType.TYPE_CLASS_NUMBER
        side2.setHintTextColor(resources.getColor(R.color.black))
        side2.hint = "Masukkan sisi 2"
        diagonal1 = EditText(context)
        diagonal1.inputType = InputType.TYPE_CLASS_NUMBER
        diagonal1.setHintTextColor(resources.getColor(R.color.black))
        diagonal1.hint = "Masukkan diagonal 1"
        formInput.addView(diagonal1)
        diagonal2 = EditText(context)
        diagonal2.inputType = InputType.TYPE_CLASS_NUMBER
        diagonal2.setHintTextColor(resources.getColor(R.color.black))
        diagonal2.hint = "Masukkan diagonal 2"
        formInput.addView(diagonal2)
        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"

        areaButton.setOnClickListener {
            if (diagonal1.text.toString().isEmpty()){
                Toast.makeText(context, "Diagonal 1 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (diagonal2.text.toString().isEmpty()){
                Toast.makeText(context, "Diagonal 2 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val d1 = diagonal1.text.toString().toDouble()
                val d2 = diagonal2.text.toString().toDouble()
                val area = d1 * d2 / 2
                result.text = "Luas layang-layang adalah $area"
            }
        }
        perimeterFormula.text = "Keliling = 2 x (d1 + d2)"

        perimeterButton.setOnClickListener {
            if (diagonal1.text.toString().isEmpty()){
                Toast.makeText(context, "Diagonal 1 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (diagonal2.text.toString().isEmpty()){
                Toast.makeText(context, "Diagonal 2 tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val d1 = diagonal1.text.toString().toDouble()
                val d2 = diagonal2.text.toString().toDouble()
                val perimeter = 2 * (d1 + d2)
                result.text = "Keliling layang-layang adalah $perimeter"
            }
        }
        return view
    }
}
