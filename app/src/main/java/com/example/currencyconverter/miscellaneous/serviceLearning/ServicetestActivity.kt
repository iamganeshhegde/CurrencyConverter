package com.example.currencyconverter.miscellaneous.serviceLearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.R
import com.example.currencyconverter.miscellaneous.retrofit.MyApi
import com.example.currencyconverter.miscellaneous.retrofit.Posts
import com.example.currencyconverter.miscellaneous.retrofit.PostsAdapter
import com.example.currencyconverter.miscellaneous.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_service_rxjava_retrofit.*
import kotlinx.android.synthetic.main.activity_service_test.*
import retrofit2.Retrofit


const val BASE_URL = ""

class ServicetestActivity:AppCompatActivity() {
    var myAPI: MyApi? = null
    var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_rxjava_retrofit)
        val retrofit = RetrofitClient().getInstance()
        myAPI = retrofit?.create(MyApi::class.java)

        recycler_posts.setHasFixedSize(true)
        recycler_posts.setLayoutManager(LinearLayoutManager(this))
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(
            myAPI!!.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Consumer<List<Posts>?> {
                override fun accept(t: List<Posts>?) {
                    displayData(t)
                }
            })
        )
    }

    private fun displayData(posts: List<Posts>?) {
        val adapter = PostsAdapter(this@ServicetestActivity, posts)
        recycler_posts!!.adapter = adapter
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }







}


//    Retrofit with an api











    //retrofit with operators


//    var recyclerView: RecyclerView? = null
//    var retrofit: Retrofit? = null
//    var recyclerViewAdapter: RecyclerViewAdapter? = null
//
//        //Retrofit and RX
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_service_rxjava_retrofit)
//
//
//        setUpRetrofitandCallApi()
//
//    }
//
//    private fun setUpRetrofitandCallApi() {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//
//        retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//
//
//        callEndpoints()
//
//    }
//
//
//    private fun callEndpoints() {
//        val cryptocurrencyService: CryptocurrencyService =
//            retrofit.create(CryptocurrencyService::class.java)

        //Single call
        /*Observable<Crypto> cryptoObservable = cryptocurrencyService.getCoinData("btc");
        cryptoObservable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).map(result -> result.ticker).subscribe(this::handleResults, this::handleError);*/

//        var observable = cryptocurrencyService.getCoinData("btc").map {
//            Observable.fromIterable(it)
//        }
//
//
//
//        val btcObservable: Observable<MutableList<Any?>>? = cryptocurrencyService.getCoinData("btc")
//            .map(Function<MutableList<Crypto?>, Observable<Any?>> { result: MutableList<Crypto?> ->
//                Observable.fromIterable(
//                    result.ticker.markets
//                )
//            })
//            .flatMap { x: Observable<Any?>? -> x }.filter { y: Any ->
//                y.coinName = "btc"
//                true
//            }.toList().toObservable()
//
//        val ethObservable: Observable<List<Market>> = cryptocurrencyService.getCoinData("eth")
//            .map<Any>(Function<Crypto, Any> { result: Crypto ->
//                Observable.fromIterable(
//                    result.ticker!!.markets
//                )
//            })
//            .flatMap(Function<Any, ObservableSource<*>?> { x: Any? -> x }).filter { y: Any ->
//                y.coinName = "eth"
//                true
//            }.toList().toObservable()
//
//        Observable.merge(btcObservable, ethObservable)
//            .subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ marketList: List<Market>? -> handleResults(marketList) }) { t: Throwable ->
//                handleError(
//                    t
//                )
//            }
//    }


//    private fun handleResults(marketList: List<Market>?) {
//        if (marketList != null && marketList.size != 0) {
//            recyclerViewAdapter.setData(marketList)
//        } else {
//            Toast.makeText(
//                this, "NO RESULTS FOUND",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//
//    private fun handleError(t: Throwable) {
//        Toast.makeText(
//            this, "ERROR IN FETCHING API RESPONSE. Try again",
//            Toast.LENGTH_LONG
//        ).show()
//    }




//    Recycler view and services broadcast receivers example

//    companion object{
//        val FILTER_ACTION_KEY = "any_key"
//
//    }
//    var myReceiver:MyReceiver? = null
//
//    var handler = Handler()
//
//
//    inner class Task:Runnable {
//        override fun run() {
//            for(i in 0 until 20) {
//                Thread.sleep(1000)
//
//                handler.post {
//                    progressBar1.progress = i
//                }
//
//            }
//        }
//
//    }
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_service_test)
//
//        button.setOnClickListener {
//            val message: String = inputText.getText().toString()
//            val intent = Intent(this@ServicetestActivity, MyService::class.java)
//            intent.putExtra("message", message)
//            startService(intent)
//        }
//
//
//        button1.setOnClickListener {
//            Thread(Task()).start()
//        }
//
//    }
//
//    fun setReceiver() {
//
//        myReceiver = MyReceiver()
//
//        var intentFilter = IntentFilter()
//        intentFilter.addAction(FILTER_ACTION_KEY)
//
//        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver!!,intentFilter)
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//        setReceiver()
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(myReceiver)
//    }
//
//    inner class MyReceiver():BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            var message = intent?.getStringExtra("broadcastMessage")
//            textView.text = message
//        }
//    }
//}