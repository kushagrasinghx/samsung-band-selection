package com.samsung.hiddenbandselection

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.samsung.hiddenbandselection.ui.theme.SamsungBandSelectionROOTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If launched from homescreen shortcut, execute the root command
        if (intent?.getBooleanExtra("launch_hidden_network", false) == true) {
            RootUtils.runAsRoot("am start -n com.samsung.android.app.telephonyui/.hiddennetworksetting.MainActivity")
        }

        setContent {
            SamsungBandSelectionROOTTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(color = Color.White, darkIcons = true)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    RootAccessScreen()
                }
            }
        }
    }
}

@Composable
fun RootAccessScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Samsung Hidden Network Settings Launcher",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Make sure to grant superuser rights using your Magisk/KernelSU")
        Spacer(modifier = Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                RootUtils.runAsRoot("am start -n com.samsung.android.app.telephonyui/.hiddennetworksetting.MainActivity")
            }) {
                Text("Open Settings")
            }

            Button(onClick = {
                val githubIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://github.com/kushagrasinghx")
                }
                context.startActivity(githubIntent)
            }) {
                Text("Visit GitHub")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            createHomeScreenShortcut(context)
        }) {
            Text("Create Homescreen Shortcut")
        }
    }
}

fun createHomeScreenShortcut(context: Context) {
    val shortcutIntent = Intent(context, MainActivity::class.java).apply {
        action = Intent.ACTION_MAIN
        putExtra("launch_hidden_network", true)
    }

    val shortcut = ShortcutInfoCompat.Builder(context, "hidden_network_shortcut")
        .setShortLabel("Band Selection")
        .setLongLabel("Open Samsung Network Settings")
        .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher))
        .setIntent(shortcutIntent)
        .build()

    ShortcutManagerCompat.requestPinShortcut(context, shortcut, null)
}
