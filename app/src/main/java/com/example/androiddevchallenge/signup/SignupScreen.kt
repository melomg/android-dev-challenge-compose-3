package com.example.androiddevchallenge.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun SignupScreen() {
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
