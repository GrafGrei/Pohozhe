package com.example.pohozhe.WhetherParser

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URL


class Weateher(lat: Double, lon: Double) {
    private var weather = JSONObject()
    private var adata: JSONObject? = null
    private var geometry: JSONObject? = null
    private var properties: JSONObject? = null
    private var meta: JSONObject? = null
    private var timeseries: JSONArray? = null
    private var url: URL? = null
    private var request: Request? = null
    private var call: Call? = null
    private var client: OkHttpClient? = OkHttpClient()
    private var response: Response? = null
    private var time_map: JSONObject? = null



    init {
        this.url = URL("https://api.met.no/weatherapi/locationforecast/2.0/complete?lat=${lat}&lon=${lon}")

        println(this.url)

        this.request = Request.Builder()
            .url(this.url!!)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
            .build()

        this.call= client?.newCall(request!!)
        this.response = call?.execute()

        this.adata = JSONObject(response?.body?.string())

        this.geometry = this.adata!!.get("geometry") as JSONObject?
        this.properties = this.adata!!.get("properties") as JSONObject?
        this.meta = this.properties!!.get("meta") as JSONObject?
        this.timeseries = this.properties!!.get("timeseries") as JSONArray?

        this.time_map = CreteWetherTimeMap()

        this.weather.put("Geometry", geometry)
        this.weather.put("Meta", meta)
        this.weather.put("timeseries", time_map)
    }


    private fun CreteWetherTimeMap(): JSONObject {
        val result = JSONObject()

        for (i in 0 until this.timeseries!!.length()) {
            val elem = this.timeseries!!.getJSONObject(i)
            val date_time = elem.getString("time").split("Z")[0]
            val (day, time) = date_time.split("T")

            val wdata = JSONObject()


            var temperature: Double?
            var humidity: Double?
            var wind_speed: Double?
            var wind_direction: Double?
            var pressure: Double?
            var cloud_cover: Double?
            var symbol: String?

            temperature = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("air_temperature")
            wdata.put("temperature", temperature)

            humidity = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("relative_humidity")
            wdata.put("humidity", humidity)

            wind_speed = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("wind_speed")
            wdata.put("wind_speed", wind_speed)

            wind_direction = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("wind_from_direction")
            wdata.put("wind_direction", wind_direction)

            pressure = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("air_pressure_at_sea_level")
            wdata.put("pressure", pressure)

            cloud_cover = elem.getJSONObject("data").getJSONObject("instant").getJSONObject("details").getDouble("cloud_area_fraction")
            wdata.put("cloud_cover", cloud_cover)

            symbol = try {
                elem.getJSONObject("data").getJSONObject("next_1_hours").getJSONObject("summary").getString("symbol_code")
            } catch (e: JSONException){
                " "
            }
            wdata.put("symbol", symbol)


            if (!result.has(day)) {
                result.put(day, JSONObject())
            }
            result.getJSONObject(day).put(time, wdata)
        }
        return result
    }

    fun GetWeather(): JSONObject {
        return weather
    }
}


