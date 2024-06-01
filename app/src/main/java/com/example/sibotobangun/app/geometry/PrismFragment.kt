package com.example.sibotobangun.app.geometry

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class PrismFragment : Fragment() {
//    prisma segitiga
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var volumeFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var length: EditText
    private lateinit var width: EditText
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

        imageFigure.setImageResource(R.drawable.prisma)
        figureName.text = "Prisma"
        definition.text =
            "Prisma adalah bangun ruang yang terbentuk dari perpotongan dua buah persegi panjang yang saling tegak lurus."
        length = EditText(context)
        length.hint = "Masukkan panjang"
        length.inputType = InputType.TYPE_CLASS_NUMBER
        length.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(length)
        width = EditText(context)
        width.hint = "Masukkan lebar"
        width.inputType = InputType.TYPE_CLASS_NUMBER
        width.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(width)
        height = EditText(context)
        height.hint = "Masukkan tinggi"
        height.inputType = InputType.TYPE_CLASS_NUMBER
        height.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(height)
        areaFormula.text = "Luas = 2 x (panjang x lebar + panjang x tinggi + lebar x tinggi)"
        volumeFormula.text = "Volume = panjang x lebar x tinggi"
        areaButton.text = "Hitung Luas"
        volumeButton.text = "Hitung Volume"

        areaButton.setOnClickListener {
            if (length.text.isEmpty()){
                Toast.makeText(context, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (width.text.isEmpty()){
                Toast.makeText(context, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val l = length.text.toString().toDouble()
                val w = width.text.toString().toDouble()
                val h = height.text.toString().toDouble()
                val area = 2 * (l * w + l * h + w * h)
                result.text = "Luas Permukaan = $area"
            }
        }

        volumeButton.setOnClickListener {
            if (length.text.isEmpty()){
                Toast.makeText(context, "Panjang tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (width.text.isEmpty()){
                Toast.makeText(context, "Lebar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (height.text.isEmpty()){
                Toast.makeText(context, "Tinggi tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                val l = length.text.toString().toDouble()
                val w = width.text.toString().toDouble()
                val h = height.text.toString().toDouble()
                val volume = l * w * h
                result.text = "Volume = $volume"
            }
        }
        return view
    }
}
