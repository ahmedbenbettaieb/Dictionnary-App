package com.example.dictionnry.Models;

import java.util.List;

public class APIRespone {
    //definition of elements  from the api base
    String word="";
    List<Phonetics> phonetics=null;
    List<Meanings> meanings=null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
