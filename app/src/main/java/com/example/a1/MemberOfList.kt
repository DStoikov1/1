package com.example.a1

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview
@Composable
fun MemberOfListPreview() {
    MemberOfList(msg = message){}
}

@Composable
fun MemberOfList(msg: Message,onClick: () -> Unit) {
    var showImage by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Создайте Intent для перехода к другой активности
    val intent = Intent(context, Experiment::class.java)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "Image",
            modifier = Modifier
                .size(80.dp)
                .clickable {
                    showImage = !showImage

                }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = msg.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable {
                        context.startActivity(intent)
                    }
            )
            Text(
                text = msg.body,
                fontSize = 16.sp,
                modifier = Modifier
            )
        }
    }
    Box(
        modifier = Modifier
            .size(80.dp)
            .padding(6.dp)
    ) {
        if (showImage) {
            Image(
                painter = painterResource(id = R.drawable.baseline_check_24),
                contentDescription = "Another Image",
                modifier = Modifier
                    .size(80.dp)
            )
        }
    }
}
