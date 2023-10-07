package com.example.vpweek4_exercise

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.vpweek4_exercise.data.DataSource
import com.example.vpweek4_exercise.ui.theme.VPweek4_ExerciseTheme
import com.example.vpweek4_exercise.ui.view.Soal3View

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VPweek4_ExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Soal1View(dummy_data().get_data_line())
                    Soal3View(DataSource().loadStory(), DataSource().loadFeed(), DataSource().loadSuggestion())
                }
            }
        }
    }
}