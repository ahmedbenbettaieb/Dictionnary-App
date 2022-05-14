package com.example.dictionnry.Models;

public class Phonetics {
    //phonetics is an array of text and audio
    // in the reade me file  i'm gonna give you the link for the database
    String text="";
    String audio="";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
