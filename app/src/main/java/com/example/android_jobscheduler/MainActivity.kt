package com.example.android_jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var jobScheduler: JobScheduler
    companion object{
        //Job ID
        const val jobId = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          //Job Scheduler initialisation
        jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        startjobbtn.setOnClickListener {
            //Start Job Implementation
            startJob()
        }

        // You can cancel the job
        // If it's not started yet
        stopjobbtn.setOnClickListener {
            //Stop Job Implementation
            stopJob()
        }




    }

    //Stop job
    private fun stopJob() {
        jobScheduler.cancel(jobId)
    }
   //Start job
    private fun startJob() {
        Toast.makeText(this, "Job will start in few seconds...", Toast.LENGTH_SHORT).show()

        val jobService = ComponentName(this, MyJobScheduler::class.java)
       //setting constraints in Job Info
        val jobInfo = JobInfo
            .Builder(jobId, jobService)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//            .setPeriodic(10000)
//            .setOverrideDeadline(10000)
//            .setMinimumLatency(5000)
            .build()

       //Scheduling job
        jobScheduler.schedule(jobInfo)
            if (jobScheduler.schedule(jobInfo) <= 0) {
            Toast.makeText(this, "There is problem while scheduling job", Toast.LENGTH_SHORT).show()
        }

    }




}