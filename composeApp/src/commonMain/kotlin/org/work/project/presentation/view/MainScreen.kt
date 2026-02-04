package org.work.project.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.about
import coursetrackermp.composeapp.generated.resources.sign_out
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.user.AuthState

import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor
import org.work.project.presentation.viewmodel.AuthViewModel
import org.work.project.presentation.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen( authViewModel: AuthViewModel, courseViewModel: CourseViewModel){
    var expanded by remember { mutableStateOf(false) }
    val authState by authViewModel.authState.collectAsStateWithLifecycle()
    val user = (authState as? AuthState.Authenticated)?.user
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8 .dp)
                    ) {
                        Text(
                            text = "Hey,",
                            color = secondaryColor
                        )
                        Text(
                            text = user?.firstName?:"",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = primaryColor
                ),
                actions = {
//
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier.size(55 .dp).padding(8 .dp).background(
                                color = secondaryColor,
                                shape = CircleShape
                            ).clickable(
                                true, onClick = {expanded=!expanded}
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "${user?.firstName?.first()?:"C"}",
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
//
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {expanded=false},
                        containerColor = Color.White,
                        modifier = Modifier.padding(
                            8 .dp
                        ).width(250 .dp)
                    ){
//                        DropdownMenuItem(
//                            onClick = {},
//                            text = {
//
//                            },
//                            leadingIcon = {
//                            }
//                        )
                        Text("${user?.firstName} ${user?.lastName}", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                        Spacer(Modifier.height(24 .dp))
                        HorizontalDivider(color = primaryColor, modifier = Modifier.height(8 .dp))
                        DropdownMenuItem(
                            contentPadding = PaddingValues(start = 2 .dp),
                            onClick = {expanded=false},
                            text = {
                                Text(stringResource(Res.string.about), fontSize = 12 .sp)
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.about),
                                    contentDescription = null,
                                    modifier = Modifier.size(18 .dp)
                                )
                            }
                        )
                        DropdownMenuItem(
                            contentPadding = PaddingValues(start = 2 .dp),
                            onClick = {
                                expanded=false
                                authViewModel.logOut()
                                      },
                            text = {
                                Text(stringResource(Res.string.sign_out), fontSize = 12 .sp)
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.sign_out),
                                    contentDescription = null,
                                    modifier = Modifier.size(18 .dp)
                                )
                            }
                        )


                    }
                }

            )
        },
        content = { innerPadding->
            Column(
                modifier = Modifier.padding(innerPadding).background(Color.White).fillMaxSize()
            ) {
                HomeScreen(courseViewModel)

            }
        }
    )
}