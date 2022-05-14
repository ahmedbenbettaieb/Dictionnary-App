package com.example.dictionnry.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.R;

//the same thing  as definition holder and phonetic holder
public class MeaningsViewHolder  extends RecyclerView.ViewHolder {
     public TextView text_View_partsOfSpeech;
     public  RecyclerView recycler_defintions;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        text_View_partsOfSpeech=itemView.findViewById(R.id.text_View_partsOfSpeech);
        recycler_defintions=itemView.findViewById(R.id.recycler_defintions);


    }
}
