package com.slate.pojo.task;

import com.google.gson.annotations.SerializedName;

public class Due {

    @SerializedName("recurring")
    private Boolean recurring;

    @SerializedName("string")
    private String string;

    @SerializedName("date")
    private String date;

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}