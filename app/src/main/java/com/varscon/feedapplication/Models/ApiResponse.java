package com.varscon.feedapplication.Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("page")
    private Page page;

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }
}
