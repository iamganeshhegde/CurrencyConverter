package com.example.currencyconverter.miscellaneous.fragmentlearnings

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import com.example.currencyconverter.R
import com.example.currencyconverter.miscellaneous.workmanager.BackgroundTask
import com.example.currencyconverter.miscellaneous.workmanager.NotificationWorker
import kotlinx.android.synthetic.main.activity_fragmet_first.*
import java.util.concurrent.TimeUnit


class FragmentFirstActivity: AppCompatActivity() {

    companion object {
        val MESSAGE_STATUS = "message_status"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragmet_first)


        startWorkManager()

        startPeiodicMAnager()


        setRecycleView()


    }

    private fun setRecycleView() {
        val dataList = ArrayList<Data>()
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "1. Hi! I am in View 1"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "2. Hi! I am in View 2"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "3. Hi! I am in View 3"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "4. Hi! I am in View 4"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "5. Hi! I am in View 5"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "6. Hi! I am in View 6"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "7. Hi! I am in View 7"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "8. Hi! I am in View 8"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "9. Hi! I am in View 9"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "10. Hi! I am in View 10"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "11. Hi! I am in View 11"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "12. Hi! I am in View 12"))


        recycleView.adapter = RecyclerViewAdapter(this,dataList)
        recycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }


    //related to work managers

    @SuppressLint("RestrictedApi")
    private fun startPeiodicMAnager() {

        var constraint = Constraints.Builder().setRequiresCharging(true).setRequiredNetworkType(NetworkType.CONNECTED).build()


        var periodicRequest = PeriodicWorkRequest.Builder(BackgroundTask::class.java,16,TimeUnit.MINUTES)
//            .setInputData(Data.Builder().putBoolean("isStart",true).build())
            .setConstraints(constraint)
            .build()

        var workManager = WorkManager.getInstance()

        workManager.enqueue(periodicRequest)

        workManager.getWorkInfoByIdLiveData(periodicRequest.id).observeForever {
            if(it != null) {
                Log.d("periodicWorkRequest", "Status changed to ${it.state}")
            }
        }


//        val periodicWorkRequest1: PeriodicWorkRequest = PeriodicWorkRequest.Builder(
//            BackgroundTask::class.java, 1, TimeUnit.MILLISECONDS
//        )
//            .setInitialDelay(6000, TimeUnit.MILLISECONDS)
//            .build()


    }

    private fun startWorkManager() {
        var workManager = WorkManager.getInstance()

        var oneTimeRequest = OneTimeWorkRequest.Builder(NotificationWorker::class.java).build()


        button.setOnClickListener {
            workManager.enqueue(oneTimeRequest)
        }


        workManager.getWorkInfoByIdLiveData(oneTimeRequest.id).observe(this){
            if(it!=null) {
                var state = it.state

                textView.text = state.toString()

            }
        }

    }
}