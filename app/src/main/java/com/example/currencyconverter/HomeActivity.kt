package com.example.currencyconverter

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.joke.APIService
import com.example.currencyconverter.joke.APIService.Companion.base_new
import com.example.currencyconverter.joke.Jokes
import com.example.currencyconverter.joke.NewUser
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import okhttp3.*
import okhttp3.Interceptor.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import io.reactivex.functions.Function;
import java.util.*


class HomeActivity : AppCompatActivity() {

    var textView: TextView? = null

    var apiService: APIService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        textView = findViewById(R.id.textView)

        setupRetrofitAndOkHttp()
        buttonJoke.setOnClickListener(View.OnClickListener { getRandomJokeFromAPI() })
    }

    private fun setupRetrofitAndOkHttp() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpCacheDirectory = File(cacheDir, "offlineCache")

        //10 MB
        val cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(provideCacheInterceptor())
            .addInterceptor(provideOfflineCacheInterceptor())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(httpClient)
//            .baseUrl(BASE_URL)
            .baseUrl(base_new)
            .build()
        apiService = retrofit.create(APIService::class.java)
    }

    fun getRandomJokeFromAPI() {
//        val observable = apiService!!.getRandomJoke("random")
        val observable = apiService!!.getUser()
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .map(object : Function<NewUser?, String?> {
                @Throws(Exception::class)
                override fun apply(user: NewUser): String? {
                    return user.name
                }
            }).subscribe(object : Observer<String?> {
                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "An error occurred in the Retrofit request. Perhaps no response/cache",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.i("Error in user", e.toString())
                }

                override fun onComplete() {}
                override fun onNext(t: String) {
                    textView!!.text = t
                }

            })
    }
    private fun provideCacheInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request: Request = chain.request()
            val originalResponse: Response = chain.proceed(request)
            val cacheControl: String? = originalResponse.header("Cache-Control")
            if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-stale=0")
            ) {
                val cc: CacheControl = CacheControl.Builder()
                    .maxStale(1, TimeUnit.DAYS)
                    .build()
                request = request.newBuilder()
                    .cacheControl(cc)
                    .build()
                chain.proceed(request)
            } else {
                 originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-stale=" + 60 * 60 * 24)
                     .removeHeader("Pragma")
                    .build();
            }
        }
    }


    private fun provideOfflineCacheInterceptor(): Interceptor {
        return Interceptor { chain ->
            try {
                return@Interceptor chain.proceed(chain.request())
            } catch (e: Exception) {
                val cacheControl: CacheControl = CacheControl.Builder()
                    .onlyIfCached()
                    .maxStale(1, TimeUnit.DAYS)
                    .build()
                val offlineRequest: Request = chain.request().newBuilder()
                    .cacheControl(cacheControl)
                    .build()
                return@Interceptor chain.proceed(offlineRequest)
            }
        }
    }
}


fun main() {

//    smallerNumbersThanCurrent(intArrayOf(8,2,1,1,3))

//    mapping()

//    println(mySqrt(2147483647).toString())

//    squareroot(8)

    println(numberMiss(intArrayOf(3,4,2,0,1,6)))

}

//numbers and frequency
fun decompressRLElist(nums: IntArray): IntArray? {
    var arrSize = 0
    run {
        var i = 0
        while (i < nums.size) {
            arrSize += nums[i]
            i += 2
        }
    }
    val result = IntArray(arrSize)
    var startIdx = 0
    var i = 0
    while (i < nums.size) {
        Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1])
        startIdx += nums[i]
        i += 2
    }
    return result
}


//find missing number from array
fun missingNumber(nums: IntArray): Int {
    var sum = 0
    var i = 0
    while (i < nums.size) {
        sum = sum + i - nums[i]
        i++
    }
    return sum + i
}


//println(numberMiss(intArrayOf(3,4,2,0,1,6)))
fun numberMiss(nums:IntArray): Int {
    var res: Int = nums.size
    println("res $res")

    for (i in 0 until nums.size) {
        res = res xor i xor nums.get(i) // a^b^b = a


        println("res and i -  $res,  $i")
    }
    return res
}

//map value of intarray to string
fun mapping() {

    var input = "codeleet"
    var inputArray = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
    var arr = arrayOf("a", "b", "c")

    var hashmap = mutableMapOf<Int, String>()
    var string = ""


    for (i in 0 until inputArray.size) {
        hashmap.put(inputArray[i], input.get(i).toString())
    }


    val sortedMap: MutableMap<Int, String> = TreeMap(hashmap)

    hashmap.entries.sortedBy { it.key }.forEach {
        string += it.value
    }

//    println(string)

    println(inputArray.toString())
//    valueOf(arr)

}

fun restoreString(s: String, indices: IntArray): String? {
    val arr = CharArray(s.length)
    for (i in indices.indices) arr[indices[i]] = s[i]
    return String(arr)
}

//find square root
fun mySqrt(x: Int): Int {

    var answer = 0

    if (x == 1 || x == 2 || x == 3) {
        return 1
    }
    var abc: Long = 0

    for (abc in 0..(x / 2) + 1) {
        if (abc * abc == x) {
            answer = abc
            return answer
        } else if (abc * abc > x) {
            answer = abc - 1
            return answer
        }
    }

    return answer

}


fun squareroot(x:Int) {

    var first = 1
    var last = x


    while (first < last) {
        var mid = (first + (last-first)) /2

        if(mid <= x/mid && (mid+1) > x/(mid+1) ) {
            println("mid $mid");
            return
        } else if( mid > x/mid ){
            last = mid
        } else {
            first = mid+1
        }
    }

    println("first $first");



}


// find smaller number by counting sort technique
// for a O(n) time complexity
fun smallerNumbersThanCurrent(nums: IntArray): IntArray? {
    val count = IntArray(11)
    val res = IntArray(nums.size)
    for (i in nums.indices) {

        count[nums[i]]++

        println("count[nums[i]] - ${count[nums[i]]}   - $i")

    }
    for (i in 1..10) {
        print("count[i] - $i - ${count[i]}, ")
        count[i] += count[i - 1]

        print("after    count[i] - $i - ${count[i]}, ")

    }
    println()
    for (i in nums.indices) {
        if (nums[i] == 0) {
            res[i] = 0
        } else {
            res[i] = count[nums[i] - 1]
            print("res[i] - $i  - ${res[i]}, ")
        }
    }
    return res
}