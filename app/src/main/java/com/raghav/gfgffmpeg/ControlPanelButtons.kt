package com.raghav.gfgffmpeg

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlPanelButtons(
    slowClick: () -> Unit,
    reverseClick: () -> Unit,
    flashClick: () -> Unit,
    gifClick: () -> Unit,
    muteClick: () -> Unit,
    textClick: () -> Unit,
    audioClick: () -> Unit,
) {
    Column {
        Text("Tap to add effects", style = TextStyle(color = Color.White, fontSize = 14.sp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            SingleToolIcon(R.drawable.icon_effect_slow, "Slow Motion") { slowClick() }
            SingleToolIcon(R.drawable.icon_effect_time, "Reverse") { reverseClick() }
            SingleToolIcon(R.drawable.icon_effect_repeatedly, "Flash") { flashClick() }
            SingleToolIcon(R.drawable.icon_effect_mute, "Mute video") { muteClick() }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            SingleToolIcon(R.drawable.icon_effect_gif, "Video to gif") { gifClick() }
            SingleToolIcon(R.drawable.icon_effect_audio, "Mute video") { audioClick() }
            SingleToolIcon(R.drawable.icon_effect_text, "Add text") { textClick() }
        }
    }
}


@Composable
fun SingleToolIcon(@DrawableRes icon: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(text, style = TextStyle(color = Color.White, fontSize = 14.sp))
    }
}


@Preview(showBackground = true)
@Composable
fun ControlPanelButtonsPreview() {
    ControlPanelButtons({}, {}, {}, {}, {}, {}, {})
}