package com.example.themecolortest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themecolortest.ui.theme.ThemeColorTestTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ThemeColorTestTheme (dynamicColor = false){
        val infoDisplayed = remember(key1 = true) {
          mutableStateOf<Boolean>(false)
        }
        val overwriteNativeBack = remember(key1 = true){
          mutableStateOf<Boolean>(false)
        }
        BackHandler(enabled = overwriteNativeBack.value){
          overwriteNativeBack.value = false
          infoDisplayed.value = false
        }
        // A surface container using the 'background' color from the theme
        Box(modifier=Modifier.fillMaxSize()){
          Column (
            modifier = Modifier
              .fillMaxSize()
          ){
            Spacer(modifier = Modifier.requiredHeight(25.dp))
            if (infoDisplayed.value) {
              Text(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp)
                  .background(
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(10.dp)
                  ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                text = "Title!",
                textAlign = TextAlign.Center
              )
              Spacer(modifier = Modifier.requiredHeight(8.dp))
              val scrollState = rememberScrollState()
              Column (
                modifier = Modifier
                  .fillMaxSize()
                  .verticalScroll(scrollState)
              ){
                Surface(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                  color = MaterialTheme.colorScheme.primaryContainer,
                  shape = RoundedCornerShape(10.dp),
                ) {
                  Column(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(8.dp),
                  )
                  {
                    Text(
                      style = MaterialTheme.typography.bodyMedium,
                      text = "A selection of code samples and templates for you to use to accelerate your app development. Browse samples to learn how to build different components for your applications.",
                      textAlign = TextAlign.Justify,
                      color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.requiredHeight(8.dp))
                    Text(
                      style = MaterialTheme.typography.bodyMedium,
                      text = "A selection of code samples and templates for you to use to accelerate your app development. Browse samples to learn how to build different components for your applications.",
                      color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                      style = MaterialTheme.typography.bodyMedium,
                      text = "A selection of code samples and templates for you to use to accelerate your app development. Browse samples to learn how to build different components for your applications.",
                      color = Color.Blue
                    )
                    Text(
                      style = MaterialTheme.typography.bodyMedium,
                      text = "A selection of code samples and templates for you to use to accelerate your app development. Browse samples to learn how to build different components for your applications.",
                      textAlign = TextAlign.Justify
                    )
                  }
                }
                Spacer(modifier = Modifier.requiredHeight(8.dp))
                Box(
                  modifier = Modifier.fillMaxSize(),
                  contentAlignment = Alignment.BottomCenter
                ) {
                  Text(
                    modifier = Modifier
                      .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(10.dp)
                      )
                      .clickable {
                        infoDisplayed.value = false
                      }
                      .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = "Close this",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                  )
                }
                Spacer(modifier = Modifier.requiredHeight(8.dp))
              }
            } else {
              Surface(
                color= Color.Transparent
              )
              {
                Text(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                      MaterialTheme.colorScheme.primary,
                      shape = RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp),
                  style = MaterialTheme.typography.titleLarge,
                  color = MaterialTheme.colorScheme.onPrimary,
                  text = "Select quiz...",
                  textAlign = TextAlign.Center
                )
              }
              Spacer(modifier = Modifier.requiredHeight(25.dp))
              Box(modifier = Modifier.fillMaxSize()) {
                Box(
                  modifier = Modifier.fillMaxSize(),
                  contentAlignment = Alignment.BottomEnd
                ) {
                  Surface(
                    modifier = Modifier.padding(8.dp),
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    onClick = {
                      infoDisplayed.value = true
                      overwriteNativeBack.value = true
                    }
                  ) {
                    Icon(
                      imageVector = Icons.Outlined.Info,
                      contentDescription = "Information",
                      modifier = Modifier
                        .padding(8.dp)
                        .size(36.dp)
                    )
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//  ThemeColorTestTheme {
//    Greeting("Android")
//  }
//}