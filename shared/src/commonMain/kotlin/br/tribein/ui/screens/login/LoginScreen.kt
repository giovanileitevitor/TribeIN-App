package br.tribein.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.tribein.ui.components.LoadingAnimation
import br.tribein.ui.theme.AppStrings
import br.tribein.ui.theme.GreyColor
import br.tribein.ui.theme.HalfBlackColor
import br.tribein.ui.theme.PrimaryGreen
import br.tribein.ui.theme.ZigbeeDeepGreen
import br.tribein.ui.theme.ZigbeeText
import br.tribein.ui.theme.gradient_colors
import br.tribein.ui.theme.middleColor
import br.tribein.ui.theme.rememberRobotoFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onForgotPassClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

    ) { paddingValues ->
        if (uiState.isLoading) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(brush = verticalGradient(colors = gradient_colors)),
                contentAlignment = Alignment.Center
            ) {
                LoadingAnimation(defaultText = AppStrings.LoadingTextLogin)
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = verticalGradient(colors = gradient_colors))
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(48.dp))

                // Title
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//        Box(
//            modifier = Modifier
//                .size(54.dp)
//                .shadow(12.dp, RoundedCornerShape(18.dp))
//                .clip(RoundedCornerShape(18.dp))
//                .background(Color.White),
//            contentAlignment = Alignment.Center
//        ) {
//
//        }
                    Spacer(Modifier.width(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Tribe",
                            color = ZigbeeText,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = (-0.25).sp,
                            fontFamily = rememberRobotoFontFamily()
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = "IN",
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White.copy(alpha = 0.80f))
                                .padding(horizontal = 5.dp, vertical = 1.dp),
                            color = ZigbeeDeepGreen,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = (+2).sp,
                            fontFamily = rememberRobotoFontFamily()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    text = AppStrings.TXT_LOGIN_DESCRIPTION,
                    fontSize = 14.sp,
                    color = GreyColor,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Email Input
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = AppStrings.EmailLabel,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = HalfBlackColor,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = uiState.email,
                        onValueChange = { viewModel.updateEmail(it) },
                        textStyle = TextStyle(fontSize = 12.sp),
                        placeholder = {
                            Text(
                                text = AppStrings.EmailPlaceholder,
                                color = GreyColor.copy(alpha = 0.5f),
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryGreen,
                            unfocusedBorderColor = GreyColor.copy(alpha = 0.3f),
                            focusedContainerColor = middleColor.copy(alpha = 0.3f),
                            unfocusedContainerColor = middleColor.copy(alpha = 0.1f)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Password Input
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = AppStrings.PasswordLabel,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = HalfBlackColor,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = uiState.password,
                        onValueChange = { viewModel.updatePassword(it) },
                        textStyle = TextStyle(fontSize = 12.sp),
                        placeholder = {
                            Text(
                                text = AppStrings.PasswordPlaceholder,
                                color = GreyColor.copy(alpha = 0.5f)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        visualTransformation = if (uiState.passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                                Icon(
                                    imageVector = if (uiState.passwordVisible) {
                                        Icons.Default.Visibility
                                    } else {
                                        Icons.Default.VisibilityOff
                                    },
                                    contentDescription = if (uiState.passwordVisible) {
                                        AppStrings.PASSWORD_HIDDEN
                                    } else {
                                        AppStrings.PASSWORD_VISIBLE
                                    },
                                    tint = GreyColor
                                )
                            }
                        },
                        maxLines = 1,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryGreen,
                            unfocusedBorderColor = GreyColor.copy(alpha = 0.3f),
                            focusedContainerColor = middleColor.copy(alpha = 0.3f),
                            unfocusedContainerColor = middleColor.copy(alpha = 0.1f)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Forgot Password and Remember Me Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { viewModel.toggleRememberMe() }
                    ) {
                        Checkbox(
                            checked = uiState.rememberMe,
                            onCheckedChange = { viewModel.toggleRememberMe() },
                            colors = CheckboxDefaults.colors(
                                checkedColor = PrimaryGreen,
                                uncheckedColor = GreyColor.copy(alpha = 0.3f)
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = AppStrings.RecordPassword,
                            fontSize = 12.sp,
                            color = HalfBlackColor,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    TextButton(onClick = { onForgotPassClick() }) {
                        Text(
                            text = AppStrings.ForgotPassword,
                            fontSize = 12.sp,
                            color = PrimaryGreen,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Error message
                if (uiState.error != null) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        color = Color.Red.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = uiState.error!!,
                            fontSize = 12.sp,
                            color = Color.Red,
                            modifier = Modifier.padding(12.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Login Button
                Button(
                    onClick = {
                        viewModel.login(
                            onSuccess = onLoginSuccess,
                            onError = { }
                        )
                    },
                    enabled = !uiState.isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryGreen,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = AppStrings.LoginButton + " →",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Sign Up Link
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = AppStrings.NoAccount,
                        fontSize = 12.sp,
                        color = HalfBlackColor
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = AppStrings.CreateAccount,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryGreen,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable { onCreateAccountClick() }
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))

                Text(
                    text = AppStrings.SPLASH_COPYRIGHT,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryGreen,
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen(){
    MaterialTheme {
        LoginScreen(
            onLoginSuccess = {},
            onCreateAccountClick = {},
            onForgotPassClick = {}
        )
    }
}