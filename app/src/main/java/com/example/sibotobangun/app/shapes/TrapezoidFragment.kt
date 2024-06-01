package com.example.sibotobangun.app.shapes

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class TrapezoidFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var perimeterFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var top: EditText
    private lateinit var bottom: EditText
    private lateinit var left: EditText
    private lateinit var right: EditText
    private lateinit var height: EditText
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

        imageFigure.setImageResource(R.drawable.trapesium)
        figureName.text = "Trapesium"
        definition.text =
            "Trapesium adalah bangun datar dua dimensi yang memiliki dua pasang sisi yang sejajar dan dua pasang sisi yang berbeda panjang. Trapesium memiliki empat buah titik sudut dan empat buah rusuk."
        areaFormula.text = "Luas = 1/2 x (a + b) x t"
        top = EditText(context)
        top.inputType = InputType.TYPE_CLASS_NUMBER
        top.setHintTextColor(resources.getColor(R.color.black))
        top.hint = "Masukkan sisi atas"
        formInput.addView(top)
        bottom = EditText(context)
        bottom.inputType = InputType.TYPE_CLASS_NUMBER
        bottom.setHintTextColor(resources.getColor(R.color.black))
        bottom.hint = "Masukkan sisi bawah"
        formInput.addView(bottom)
        left = EditText(context)
        left.inputType = InputType.TYPE_CLASS_NUMBER
        left.setHintTextColor(resources.getColor(R.color.black))
        left.hint = "Masukkan sisi kiri"
        formInput.addView(left)
        right = EditText(context)
        right.inputType = InputType.TYPE_CLASS_NUMBER
        right.setHintTextColor(resources.getColor(R.color.black))
        right.hint = "Masukkan sisi kanan"
        formInput.addView(right)
        height = EditText(context)
        height.inputType = InputType.TYPE_CLASS_NUMBER
        height.setHintTextColor(resources.getColor(R.color.black))
        height.hint = "Masukkan tinggi"
        formInput.addView(height)

        areaButton.text = "Hitung Luas"
        perimeterButton.text = "Hitung Keliling"
        areaButton.setOnClickListener {
            if (top.text.isEmpty()){
                Toast.makeText(context, "Sisi atas tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (bottom.text.isEmpty()){
                Toast.makeText(context, "Sisi bawah tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val a = top.text.toString().toDouble()
                val b = bottom.text.toString().toDouble()
                val t = height.text.toString().toDouble()
                val luas = 0.5 * (a + b) * t
                result.text = "Luas trapesium adalah $luas"
            }
        }
        perimeterButton.setOnClickListener {
            if (top.text.isEmpty()){
                Toast.makeText(context, "Sisi atas tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (bottom.text.isEmpty()){
                Toast.makeText(context, "Sisi bawah tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (left.text.isEmpty()){
                Toast.makeText(context, "Sisi kiri tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (right.text.isEmpty()){
                Toast.makeText(context, "Sisi kanan tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val a = top.text.toString().toDouble()
                val b = bottom.text.toString().toDouble()
                val c = left.text.toString().toDouble()
                val d = right.text.toString().toDouble()
                val keliling = a + b + c + d
                result.text = "Keliling trapesium adalah $keliling"
            }
        }
        return view
    }
}
