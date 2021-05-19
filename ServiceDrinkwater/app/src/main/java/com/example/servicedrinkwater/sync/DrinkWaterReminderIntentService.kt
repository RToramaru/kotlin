package com.example.servicedrinkwater.sync

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.example.servicedrinkwater.utils.PreferencesUtils


class DrinkWaterReminderIntentService:IntentService("DrinkWaterReminderIntentService"){
    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.action
        DrinkWaterReminderTask.executeTask(this, action)
    }
}