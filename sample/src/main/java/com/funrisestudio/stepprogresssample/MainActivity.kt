package com.funrisestudio.stepprogresssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stepsCount = 4
        vStepProgress.setStepsCount(stepsCount)
        vStepProgress.setStepTitles(List(stepsCount) { "Step ${it + 1}" })
        vStepProgress.onStepSelected = {
            val stepName = "Step ${it + 1}"
            val isStepFinished = vStepProgress.isStepDone(it)
            val isProgressFinished = vStepProgress.isProgressFinished()
            Toast.makeText(
                    this@MainActivity,
                    "$stepName finished = $isStepFinished\nProgressFinished = $isProgressFinished",
                    Toast.LENGTH_SHORT
            ).show()
        }
        btnNext.setOnClickListener {
            val isFinished = vStepProgress.nextStep(true)
            if (isFinished) {
                Toast.makeText(this@MainActivity, "Done !", Toast.LENGTH_SHORT).show()
            }
        }
        btnMarkDone.setOnClickListener {
            vStepProgress.markCurrentAsDone()
        }
        btnMarkUndone.setOnClickListener {
            vStepProgress.markCurrentAsUndone()
        }
    }

}