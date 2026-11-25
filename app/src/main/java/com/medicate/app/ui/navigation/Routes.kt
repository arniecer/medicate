package com.medicate.app.ui.navigation

object Routes {
    const val PROFILE_ID = "profileId"

    const val  PROFILES = "profiles"
    const val HOME = "home/{$PROFILE_ID}"
    const val CALENDAR = "calendar/{$PROFILE_ID}"
    const val INVENTORY = "inventory/{$PROFILE_ID}"
    const val ALERTS = "alerts/{$PROFILE_ID}"

    fun home(profileId: Long) = "home/$profileId"
    fun calendar(profileId: Long) = "calendar/$profileId"
    fun inventory(profileId: Long) = "inventory/$profileId"
    fun alerts(profileId: Long) = "alerts/$profileId"
}