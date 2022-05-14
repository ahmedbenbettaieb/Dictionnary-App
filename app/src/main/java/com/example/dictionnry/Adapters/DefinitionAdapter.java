package com.example.dictionnry.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.Models.Definitions;
import com.example.dictionnry.R;
import com.example.dictionnry.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textView_definition.setText("Definition:" +definitionsList.get(position).getDefinition());
        holder.textView_example.setText("Definition:" +definitionsList.get(position).getExample());
        //create  mutable strings
        StringBuilder synonyms=new StringBuilder();
        StringBuilder antonyms=new StringBuilder();
        synonyms.append(definitionsList.get(position).getSynonym());
        antonyms.append(definitionsList.get(position).getAntonym());
        holder.textView_synonyms.setText(synonyms);
        holder.textView_antonyms.setText(antonyms);
        //make the text  view selectors
        holder.textView_synonyms.setSelected(true);
        holder.textView_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
