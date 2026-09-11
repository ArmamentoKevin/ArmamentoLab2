package com.example.armamentokevinlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.armamentokevinlab2.ui.theme.ArmamentoKevinLab2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ArmamentoKevinLab2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Displays the complete profile screen
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    // Stores the Follow state and preserves it during rotation
    var isFollowing by rememberSaveable {
        mutableStateOf(false)
    }

    // Stores the current profile view count
    var viewCount by remember {
        mutableIntStateOf(143)
    }

    // Arranges the profile elements vertically and centers them
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ProfileColors.Background)
            .padding(ProfileSpacing.ScreenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Displays the profile picture as a circle
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(ProfileSizes.Avatar)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.AvatarToName)
        )

        // Displays the user's name
        Text(
            text = "Armamento Kevin",
            fontSize = ProfileTextSizes.Name,
            fontWeight = ProfileFontWeights.Name,
            color = ProfileColors.Name
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.NameToBio)
        )

        // Displays the user's short bio or tagline
        Text(
            text = "BSIT Student • Mobile Developer",
            fontSize = ProfileTextSizes.Bio,
            color = ProfileColors.SecondaryText
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.BioToContact)
        )

        // Displays the email contact information
        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = ProfileColors.Icon,
                    modifier = Modifier.size(ProfileSizes.ContactIcon)
                )
            },
            text = "armamentokevin50@gmail.com"
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.ContactSpacing)
        )

        // Displays the phone contact information
        ContactRow(
            icon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone",
                    tint = ProfileColors.Icon,
                    modifier = Modifier.size(ProfileSizes.ContactIcon)
                )
            },
            text = "+63 926 0055 817"
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.ContactToButtons)
        )

        // Places the Message and Follow buttons beside each other
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Creates the Message button
            Button(
                onClick = {
                    // Message functionality can be added later
                },
                shape = RoundedCornerShape(
                    ProfileSizes.ButtonCornerRadius
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ProfileColors.PrimaryButton
                )
            ) {
                Text(
                    text = "Message",
                    fontSize = ProfileTextSizes.Button
                )
            }

            Spacer(
                modifier = Modifier.width(ProfileSpacing.ButtonSpacing)
            )

            // Creates the hoisted Follow button
            FollowButton(
                isFollowing = isFollowing,
                onToggle = {
                    isFollowing = !isFollowing
                }
            )
        }

        Spacer(
            modifier = Modifier.height(ProfileSpacing.ButtonToCounter)
        )

        // Displays the profile view counter
        Counter(
            viewCount = viewCount,
            onIncrement = {
                viewCount++
            }
        )
    }
}

// Creates a Follow button controlled by the parent state
@Composable
fun FollowButton(
    isFollowing: Boolean,
    onToggle: () -> Unit
) {

    if (isFollowing) {

        // Shows an outlined button when already following
        OutlinedButton(
            onClick = onToggle,
            shape = RoundedCornerShape(
                ProfileSizes.ButtonCornerRadius
            )
        ) {
            Text(
                text = "Following",
                fontSize = ProfileTextSizes.Button
            )
        }

    } else {

        // Shows a filled button when not following
        Button(
            onClick = onToggle,
            shape = RoundedCornerShape(
                ProfileSizes.ButtonCornerRadius
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = ProfileColors.PrimaryButton
            )
        ) {
            Text(
                text = "Follow",
                fontSize = ProfileTextSizes.Button
            )
        }
    }
}

// Creates a reusable row for contact information
@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String
) {

    // Arranges the contact icon and text horizontally
    Row(
        modifier = Modifier.width(ProfileSizes.ContactRow),
        verticalAlignment = Alignment.CenterVertically
    ) {

        icon()

        Spacer(
            modifier = Modifier.width(ProfileSpacing.IconToText)
        )

        Text(
            text = text,
            fontSize = ProfileTextSizes.Contact,
            color = ProfileColors.ContactText
        )
    }
}

// Creates a small counter for profile views
@Composable
fun Counter(
    viewCount: Int,
    onIncrement: () -> Unit
) {

    // Arranges the counter elements vertically
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Displays the current number of profile views
        Text(
            text = "Profile views: $viewCount",
            fontSize = ProfileTextSizes.Contact,
            color = ProfileColors.ContactText
        )

        Spacer(
            modifier = Modifier.height(ProfileSpacing.CounterTextToButton)
        )

        // Increases the profile view count
        Button(
            onClick = onIncrement,
            shape = RoundedCornerShape(
                ProfileSizes.ButtonCornerRadius
            )
        ) {
            Text(
                text = "+1",
                fontSize = ProfileTextSizes.Button
            )
        }
    }
}

// Displays a preview of the profile screen in Android Studio
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenPreview() {

    // Applies the application's theme to the preview
    ArmamentoKevinLab2Theme {
        ProfileScreen()
    }
}