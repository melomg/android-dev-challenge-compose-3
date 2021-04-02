/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
fun WelcomeScreen(
    onCreateAccountClicked: () -> Unit,
    onLoginClicked: () -> Unit
) {
    Surface(
        color = colors.primary,
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
                onClick = onCreateAccountClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(48.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .constrainAs(signUp) {
                        top.linkTo(bloomSolutions.bottom, margin = 40.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                colors = ButtonDefaults.buttonColors(backgroundColor = colors.secondary),
                shape = shapes.medium,
            ) {
                Text(
                    text = stringResource(id = R.string.create_account),
                    color = colors.onSecondary,
                    style = typography.button,
                )
            }

            TextButton(
                onClick = onLoginClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(48.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .constrainAs(login) {
                        top.linkTo(signUp.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = colors.onPrimary,
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
        WelcomeScreen({}, {})
    }
}

@Preview("Dark Theme Welcome Screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcomeScreen() {
    MyTheme(
        darkTheme = true,
    ) {
        WelcomeScreen({}, {})
    }
}
