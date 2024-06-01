package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class ParallelogramFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName : TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula : TextView
    private lateinit var perimeterFormula : TextView
    private lateinit var formInput : LinearLayout
    private lateinit var side : EditText
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

        imageFigure.setImageResource(R.drawable.jajargenjang)
        figureName.text = "Jajar Genjang"
        definition.text = "Jajar genjang adalah bangun datar dua dimensi yang memiliki dua pasang sisi yang sejajar dan sama panjang. Jajar genjang memiliki empat buah titik sudut dan empat buah rusuk."
        areaFormula.text = "Luas = a x t"
        side = EditText(context)
        side.inputType = InputType.TYPE_CLASS_NUMBER
        side.setHintTextColor(resources.getColor(R.color.black))
        side.hint = "Masukkan sisi"
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
        formInput.addView(side)

        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"
        areaButton.setOnClickListener {
            if (base.text.toString().isEmpty()){
                Toast.makeText(context, "Alas tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.toString().isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val a = base.text.toString().toDouble()
                val t = height.text.toString().toDouble()
                val luas = a * t
                result.text = "Luas = $luas"
            }
        }
        perimeterFormula.text = "Keliling = 2 x (a + b)"

        perimeterButton.setOnClickListener {
            if (base.text.toString().isEmpty()){
                Toast.makeText(context, "Alas tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (side.text.toString().isEmpty()){
                Toast.makeText(context, "Masukkan nilai sisi", Toast.LENGTH_SHORT).show()
            } else {
                val a = base.text.toString().toDouble()
                val b = side.text.toString().toDouble()
                val keliling = 2 * (a + b)
                result.text = "Keliling = $keliling"
            }
        }
        return view
    }
}
