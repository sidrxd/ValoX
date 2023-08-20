package screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ui.Color

class ComingSoonScreen : Screen {
    @Composable
    override fun Content() {
        MaterialTheme {
            Box(modifier = Modifier.fillMaxSize().background(color = ui.Color.colorBackground), contentAlignment = Alignment.Center) {
                Text("Coming soon....", color = Color.secondaryText)
            }
        }

    }
}