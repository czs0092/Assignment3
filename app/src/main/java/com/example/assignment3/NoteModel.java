package com.example.assignment3;

import com.google.gson.Gson;

public class NoteModel {
    public String content;
    public String list;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static NoteModel fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, NoteModel.class);
    }
}
