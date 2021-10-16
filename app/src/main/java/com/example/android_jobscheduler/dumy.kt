package com.example.android_jobscheduler

import java.util.*

fun main(){

    val rightNow: Calendar = Calendar.getInstance()
    val currentMin: Int = rightNow.get(Calendar.MINUTE)
    val currentHour: Int = rightNow.get(Calendar.HOUR)
println(currentHour)
for(i in currentHour..currentHour+10){
    println(currentMin)
}

}
//
//Job info.builder
//setMinimumLatency(long minLatencyMillis): This makes your job not launch until the stated number of milliseconds have passed. This is incompatible with setPeriodic(long time) and will cause an exception to be thrown if they are both used.
//setOverrideDeadline(long maxExecutionDelayMillis): This will set a deadline for your job. Even if other requirements are not met, your task will start approximately when the stated time has passed. Like setMinimumLatency(long time), this function is mutually exclusive with setPeriodic(long time) and will cause an exception to be thrown if they are both used.
//setPersisted(boolean isPersisted): This function tells the system whether your task should continue to exist after the device has been rebooted.
//setRequiredNetworkType(int networkType): This function will tell your job that it can only start if the device is on a specific kind of network. The default is JobInfo.NETWORK_TYPE_NONE, meaning that the task can run whether there is network connectivity or not. The other two available types are JobInfo.NETWORK_TYPE_ANY, which requires some type of network connection available for the job to run, and JobInfo.NETWORK_TYPE_UNMETERED, which requires that the device be on a non-cellular network.
//setRequiresCharging(boolean requiresCharging): Using this function will tell your application that the job should not start until the device has started charging.
//setRequiresDeviceIdle(boolean requiresDeviceIdle): This tells your job to not start unless the user is not using their device and they have not used it for some time.

//Notification Importance
//Importance-high = Urgent,Makes a sound and appears as a heads-up notification
//Importance-default = High,Makes a sound
//Importance-low = Medium ,No sound
//Importance-min = Low,No sound and does not appear in the status bar
