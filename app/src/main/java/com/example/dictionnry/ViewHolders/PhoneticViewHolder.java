package com.example.dictionnry.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.R;
//Class handling the Phonetic list items.xml
public class PhoneticViewHolder  extends RecyclerView.ViewHolder {
    //defining the items that are in the phonetic list items;
    public TextView text_View_phonetic;
    public ImageButton imageButton_audio;

    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        //Finds a view that was identified by the android:id XML

        text_View_phonetic=itemView.findViewById(R.id.text_View_phonetic);
        imageButton_audio=itemView.findViewById(R.id.imageButton_audio);

    }
}
