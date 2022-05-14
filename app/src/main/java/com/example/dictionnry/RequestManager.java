package com.example.dictionnry;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionnry.Models.APIRespone;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class RequestManager {
    //Manage the request to retrieve data from the URL
Context context;
//the baseURL is the Url we will work for , of course we will change him a little sometimes to adapt the request
Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void getWordMeaning(OnFetchDataListener listener,String word){
        //function for getting the word meanings
        CallDictionary callDictionary=retrofit.create(CallDictionary.class);
        Call<List<APIRespone>> call =callDictionary.callMeanings(word);
        //trying to get the response , if an error occured we will show a toasr
        try {
            call.enqueue(new Callback<List<APIRespone>>() {
                @Override
                public void onResponse(Call<List<APIRespone>> call, Response<List<APIRespone>> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(context," error !!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //get first object of api response
                        listener.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<APIRespone>> call, Throwable t) {
                    listener.onError("Request Failed");

                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context,"An error Occured",Toast.LENGTH_SHORT).show();

        }
    }
    public  interface  CallDictionary{
        //Get method
        @GET("entries/en/{word}")
        //Receive the meanings
        Call<List<APIRespone>> callMeanings(
                @Path("word")String word

        );
    }
}
