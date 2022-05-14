package com.example.dictionnry.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.Models.Phonetics;
import com.example.dictionnry.R;
import com.example.dictionnry.ViewHolders.PhoneticViewHolder;

import java.util.List;

//Connecting View with data source ,for this class it will be for the phonetics
public class PhoneticsAdapter  extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    private List<Phonetics> phoneticsList;
    @NonNull
    @Override
    //creates a new view holder
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_item,parent,false));
    }

    @Override
    //updates the recycler view
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
    holder.text_View_phonetic.setText(phoneticsList.get(position).getText());
    holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
        @Override
        //trying to play audio for the word
        public void onClick(View view) {
            MediaPlayer player=new MediaPlayer();
            try{
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.setDataSource("https:"+phoneticsList.get(position).getAudio());
                player.prepare();
                player.start();

            }catch (Exception e){
                //if it does not show a toast
                e.printStackTrace();
                Toast.makeText(context,"could not play audio ,sorry",Toast.LENGTH_SHORT).show();

            }
        }
    });
    }

    @Override
    //returns the number of list items
    public int getItemCount() {
        return phoneticsList.size();
    }
}
