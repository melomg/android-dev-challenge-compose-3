package com.example.androiddevchallenge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R

@Composable
fun LoginScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (bloomImage, bloomLogo, bloomSolutions, signUp, login) = createRefs()

            val guideline = createGuidelineFromBottom(fraction = 0.5f)

            Image(
                painterResource(R.drawable.bg_welcome),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
            )

            Image(
                painterResource(R.drawable.ic_welcome_illos),
                contentDescription = null,
                modifier = Modifier.constrainAs(bloomImage) {
                    top.linkTo(parent.top, margin = 72.dp)
                    bottom.linkTo(guideline)
                    end.linkTo(parent.end)
                },
                contentScale = ContentScale.Crop,
            )

            Image(
                painterResource(R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.constrainAs(bloomLogo) {
                    top.linkTo(bloomImage.bottom, margin = 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                contentScale = ContentScale.Crop,
            )
        }
    }
}
