package com.example.pohozhe.DataProcessing.uiData.APIProcessing

import android.annotation.SuppressLint
import android.content.Context
import com.example.pohozhe.dataclasses.Coordinates
import com.google.android.gms.location.*
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


@SuppressLint("MissingPermission")
suspend fun getCurrentCoordinates(context: Context, timeoutMillis: Long = 5000L): Coordinates =
    withTimeout(timeoutMillis) {
        suspendCancellableCoroutine { continuation ->

            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY, 2000L
            ).apply {
                setMaxUpdates(1)
            }.build()

            val callback = object : LocationCallback() {
                override fun onLocationResult(result: LocationResult) {
                    fusedLocationClient.removeLocationUpdates(this)
                    val location = result.lastLocation
                    if (location != null) {
                        continuation.resume(Coordinates(location.latitude, location.longitude))
                    } else {
                        continuation.resumeWithException(Exception("Location is null"))
                    }
                }

                override fun onLocationAvailability(availability: LocationAvailability) {
                    if (!availability.isLocationAvailable) {
                        continuation.resumeWithException(Exception("Location unavailable"))
                    }
                }
            }

            fusedLocationClient.requestLocationUpdates(locationRequest, callback, null)

            continuation.invokeOnCancellation {
                fusedLocationClient.removeLocationUpdates(callback)
            }
        }
    }
