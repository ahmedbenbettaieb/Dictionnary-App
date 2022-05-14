package com.example.dictionnry.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.Models.Meanings;
import com.example.dictionnry.R;
import com.example.dictionnry.ViewHolders.MeaningsViewHolder;

import java.util.List;

public class MeaningAdapter  extends RecyclerView.Adapter<MeaningsViewHolder> {

    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.text_View_partsOfSpeech.setText("Parts of speech" +meaningsList.get(position).getPartOfSpeech());
        holder.recycler_defintions.setHasFixedSize(true);
        holder.recycler_defintions.setLayoutManager(new GridLayoutManager(context,1));
        DefinitionAdapter definitionAdapter=new DefinitionAdapter(context,meaningsList.get(position).getDefinitions());
        //add the last adapter to recycler view
        holder.recycler_defintions.setAdapter(definitionAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
