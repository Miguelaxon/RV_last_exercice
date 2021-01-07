package com.crisspian.recyclerMiguel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerMiguel.databinding.ItemListDataBinding;
import com.crisspian.recyclerMiguel.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ImageViewHolder> {
    private List<Item> lista;
    private PasarElemento pasarElemento;

    public ItemAdapter(List<Item> returnItemList, PasarElemento pasarElemento) {
        this.lista = returnItemList;
        this.pasarElemento = pasarElemento;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;
        private ImageView imageView;

        public ImageViewHolder(@NonNull ItemListDataBinding itemBinding){
            super(itemBinding.getRoot());
            textView = itemBinding.tvItem;
            imageView = itemBinding.ivItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            pasarElemento.passElement(lista.get(getLayoutPosition()));
        }
    }

    public interface PasarElemento{
        void passElement(Item elemento);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding itemBinding = ItemListDataBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ImageViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Item item = lista.get(position);
        holder.textView.setText(item.getItemDescription());
        Glide.with(holder.imageView.getContext()).load(item.getUrlImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
