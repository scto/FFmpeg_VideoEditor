package com.raghav.gfgffmpeg

import android.R.attr.textColor
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddTextPanel(
    text: String,
    onTextChange: (String) -> Unit,
    onClickDone: (String) -> Unit
) {
    Column {
        TextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {"Add your text"},
            trailingIcon = {
                if(text.isNotEmpty()){
                    IconButton(onClick = { onClickDone(text) }) {
                        Icon(Icons.Default.Done, contentDescription = null)
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                trailingIconColor = Color.Green,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
                .padding(2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddTextPanelPreview() {
    AddTextPanel("kkkk", {}, {})
}