package com.torsoft.clevertodo.ui.screens.login.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.torsoft.clevertodo.R

@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    domain: String,
    domainError: String?,
    onDomainChanged: (String) -> Unit,
    onLoginClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            TextField(
                value = domain,
                onValueChange = onDomainChanged,
                enabled = !isLoading,
                isError = domainError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (domainError != null) {
                Text(
                    text = domainError,
                    color = MaterialTheme.colors.onError
                )
            }
        }

        Button(
            onClick = onLoginClicked,
            enabled = !isLoading,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(40.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp))
            } else {
                Text(text = stringResource(id = R.string.login_button_text))
            }
        }
    }

}
