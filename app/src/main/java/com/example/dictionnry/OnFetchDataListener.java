package com.example.dictionnry;

import com.example.dictionnry.Models.APIRespone;

public interface OnFetchDataListener {
    //Fetch the date
    void onFetchData(APIRespone apiRespone,String message);
    //Showing an error
    void onError(String message);

}
