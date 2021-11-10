package com.example.currencyconverter.asynctask

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.activity_async_task.*
import java.lang.ref.WeakReference


class AsyncTaskActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_async_task)

        val progressDrawable = progressBar.progressDrawable.mutate()
        progressDrawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
        progressBar.progressDrawable = progressDrawable

        startAsyncTask.setOnClickListener {

            var exampleAsyncTask = ExampleAsyncTask(this)
            exampleAsyncTask.execute(10)
        }
    }

    companion object {
        private class ExampleAsyncTask(var activity: AsyncTaskActivity):AsyncTask<Int,Int,String>() {
            var activityWeakReference:WeakReference<AsyncTaskActivity> = WeakReference(activity)

            override fun onPreExecute() {
                super.onPreExecute()
                var activity = activityWeakReference.get()
                if(activity == null && activity?.isFinishing == true) {

                    return
                }
                activity?.progressBar!!.show()
            }
            override fun doInBackground(vararg params: Int?): String {

                for(i in 0 until params[0]!!) {
                    publishProgress((i*100) / params[0]!!)
                    Thread.sleep(1000)
                }

                return "Finished!"
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                var activity = activityWeakReference.get()
                if(activity == null && activity?.isFinishing == true) {

                    return
                }
                activity?.progressBar!!.progress = values[0]!!
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                var activity = activityWeakReference.get()
                if(activity == null && activity?.isFinishing == true) {

                    return
                }

                Toast.makeText(activity,result,Toast.LENGTH_SHORT).show()
                activity?.progressBar!!.progress = 0
                activity?.progressBar!!.hide()
            }
        }
    }

}