package com.example.androiddevchallenge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun WelcomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
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

            Text(
                text = stringResource(id = R.string.beautiful_garden_solutions),
                modifier = Modifier.constrainAs(bloomSolutions) {
                    top.linkTo(bloomLogo.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                style = typography.subtitle1,
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(48.dp)
                    .padding(top = 0.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(signUp) {
                        top.linkTo(bloomSolutions.bottom, margin = 40.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                shape = shapes.medium,
            ) {
                Text(
                    text = stringResource(id = R.string.create_account),
                    color = MaterialTheme.colors.onSecondary,
                    style = typography.button,
                )
            }

            TextButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(48.dp)
                    .padding(top = 0.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(login) {
                        top.linkTo(signUp.bottom, margin = 8.dp)
                    },
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colors.onPrimary,
                    style = typography.button,
                )
            }
        }
    }
}

@Preview("Light Theme Welcome Screen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcomeScreen() {
    MyTheme(
        darkTheme = false,
    ) {
        WelcomeScreen()
    }
}

@Preview("Dark Theme Welcome Screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcomeScreen() {
    MyTheme(
        darkTheme = true,
    ) {
        WelcomeScreen()
    }
}
