package com.example.pohozhe.DataProcessing.uiData.APIProcessing

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.Manifest


@Composable
fun RequestLocationPermissionOnce(
    onPermissionsChecked: (Boolean) -> Unit
) {
    val context = LocalContext.current
    var hasRequested by rememberSaveable { mutableStateOf(false) }
    var permissionsGranted by rememberSaveable { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        permissionsGranted = fineGranted || coarseGranted
        onPermissionsChecked(permissionsGranted)
    }

    LaunchedEffect(Unit) {

    }
}
