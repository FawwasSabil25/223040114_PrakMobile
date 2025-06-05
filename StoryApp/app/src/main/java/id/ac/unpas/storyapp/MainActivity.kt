package id.ac.unpas.storyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import id.ac.unpas.storyapp.ui.navigation.StoryApp
import id.ac.unpas.storyapp.ui.theme.StoryAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoryAppTheme {
                StoryApp()
            }
        }
    }
}