package com.example.shoppinglistapp.database

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment: BottomSheetDialogFragment(), CoroutineScope  {

    //define a job (background task in coroutine)
    private lateinit var job: Job
    //overide the Couritine context and define the context which the job occurs
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    //override oncreate method and create the job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }
    //destroy the job when the fragment is destroyed
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}