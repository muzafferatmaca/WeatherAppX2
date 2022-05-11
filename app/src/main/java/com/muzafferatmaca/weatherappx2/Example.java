package com.muzafferatmaca.weatherappx2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Muzaffer Atmaca on 30.10.2020.
 */
public class Example {

    @SerializedName("main")
    Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
