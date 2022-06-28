package com.tugasaplikasi.kaloriku.penghitungkalori.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tugasaplikasi.kaloriku.penghitungkalori.R;

import java.util.ArrayList;

/**
 * Created by aryani on 21/09/2017.
 */

public class CardViewMakananAdapter extends RecyclerView.Adapter<CardViewMakananAdapter.CardViewViewHolder> {

    private ArrayList<MakananModel> listMakanan;
    private Context context;

    public ArrayList<MakananModel> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<MakananModel> listMakanan) {
        this.listMakanan = listMakanan;
    }

    @Override
    public CardViewMakananAdapter.CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_makanan, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CardViewMakananAdapter.CardViewViewHolder holder, int position) {
        MakananModel makananModel = getListMakanan().get(position);
        holder.tvNama.setText(makananModel.getNama_makanan());
        holder.tvJenisMakanan.setText(makananModel.getUkuran_saji());
        holder.tvKaloriMakanan.setText(makananModel.getKalori_makanan() + " kal");
    }

    @Override
    public int getItemCount() {
        return getListMakanan().size();
    }

    public static class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvJenisMakanan, tvKaloriMakanan;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama_makanan);
            tvJenisMakanan = itemView.findViewById(R.id.tv_item_jenis_makanan);
            tvKaloriMakanan = itemView.findViewById(R.id.tv_item_kalori_makanan);
        }
    }
}
