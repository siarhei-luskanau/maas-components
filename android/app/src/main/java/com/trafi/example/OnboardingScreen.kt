package com.trafi.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.trafi.example.ui.DemoMaasTheme
import com.trafi.ui.Button
import com.trafi.ui.theme.MaasTheme

@Composable
fun OnboardingScreen(onComplete: () -> Unit = {}) {
    val asset = vectorResource(id = R.drawable.onboarding_visual)
    Column(
        modifier = Modifier
            .background(MaasTheme.colors.background)
            .fillMaxHeight()
            .padding(horizontal = MaasTheme.spacing.globalMargin)
            .padding(top = 128.dp, bottom = 62.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(asset)
        Text(
            text = "Welcome to our MaaS!",
            textAlign = TextAlign.Center,
            color = MaasTheme.colors.onBackground,
            style = MaasTheme.typography.headingXL,
        )
        Button(
            text = "Let's go!",
            onClick = onComplete,
        )
    }
}

@Preview(widthDp = 375)
@Composable
fun OnboardingScreenPreview() {
    DemoMaasTheme {
        OnboardingScreen()
    }
}

@Preview(widthDp = 375)
@Composable
fun DarkOnboardingScreenPreview() {
    DemoMaasTheme(darkTheme = true) {
        OnboardingScreen()
    }
}

@Preview(widthDp = 280)
@Composable
fun NarrowOnboardingScreenPreview() {
    DemoMaasTheme(narrowScreen = true) {
        OnboardingScreen()
    }
}