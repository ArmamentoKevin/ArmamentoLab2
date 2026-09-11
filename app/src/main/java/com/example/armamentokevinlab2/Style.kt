package com.example.armamentokevinlab2

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
 * Profile screen colors.
 */
object ProfileColors {

    val Background = Color(0xFFF9F7FC)
    val Name = Color(0xFF202020)
    val SecondaryText = Color(0xFF68687A)
    val ContactText = Color(0xFF424252)
    val Icon = Color(0xFF53658F)
    val PrimaryButton = Color(0xFF6073A3)
}

/*
 * Font sizes used on the profile screen.
 */
object ProfileTextSizes {

    val Name = 24.sp
    val Bio = 14.sp
    val Contact = 14.sp
    val Button = 14.sp
}

/*
 * Font weights used on the profile screen.
 */
object ProfileFontWeights {

    val Name = FontWeight.Bold
}

/*
 * Padding and spacing used throughout the profile screen.
 */
object ProfileSpacing {

    val ScreenPadding = 24.dp
    val AvatarToName = 18.dp
    val NameToBio = 5.dp
    val BioToContact = 22.dp
    val ContactSpacing = 10.dp
    val ContactToButtons = 22.dp
    val ButtonSpacing = 12.dp
    val IconToText = 9.dp
}

/*
 * Component sizes used on the profile screen.
 */
object ProfileSizes {

    val Avatar = 120.dp
    val ContactRow = 270.dp
    val ContactIcon = 20.dp
    val ButtonCornerRadius = 20.dp
}