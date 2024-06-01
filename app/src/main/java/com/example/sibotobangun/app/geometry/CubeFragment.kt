package com.example.sibotobangun.app.geometry

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R

class CubeFragment : Fragment() {
    private lateinit var imageFigure: ImageView
    private lateinit var figureName: TextView
    private lateinit var definition: TextView
    private lateinit var areaFormula: TextView
    private lateinit var volumeFormula: TextView
    private lateinit var formInput: LinearLayout
    private lateinit var side: EditText
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

        imageFigure.setImageResource(R.drawable.kubus)
        figureName.text = "Kubus"
        definition.text =
            "Dalam geometri, Kubus adalah bangun ruang tiga dimensi yang dibatasi oleh enam bidang sisi yang kongruen berbentuk bujur sangkar. Kubus memiliki 6 sisi, 12 rusuk, dan 8 titik sudut. Kubus juga disebut dengan Bidang enam beraturan, selain itu kubus juga merupakan bentuk khusus dalam prisma segi empat, Kubus."
        side = EditText(context)
        side.hint = "Masukkan sisi"
        side.inputType = InputType.TYPE_CLASS_NUMBER
        side.setHintTextColor(resources.getColor(R.color.black))
        formInput.addView(side)
        areaFormula.text = "Luas permukaan kubus = 6 x s x s"
        volumeFormula.text = "Volume kubus = s x s x s"
        areaButton.text = "Hitung Luas"
        volumeButton.text = "Hitung Volume"
        areaButton.setOnClickListener {
            if (side.text.isEmpty()) {
                Toast.makeText(context, "Masukkan sisi", Toast.LENGTH_SHORT).show()
            } else {
                val s = side.text.toString().toDouble()
                val area = 6 * s * s
                result.text = "Luas permukaan kubus = $area"
            }

        }
        volumeButton.setOnClickListener {
            if (side.text.isEmpty()) {
                Toast.makeText(context, "Masukkan sisi", Toast.LENGTH_SHORT).show()
            } else {
                val s = side.text.toString().toDouble()
                val volume = s * s * s
                result.text = "Volume kubus = $volume"
            }
        }
        return view
    }
}
