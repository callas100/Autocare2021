package com.example.autocare2021.adaptere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.autocare2021.R;
import com.example.autocare2021.original.Masina;

import java.util.List;

public class MasinaAdapter extends BaseAdapter {
    private List<Masina> masini;
    private Context context;

    public MasinaAdapter(List<Masina> masini, Context context) {
        this.masini = masini;
        this.context = context;
    }

    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Object getItem(int position) {
        return masini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Masina masina = (Masina) getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View generatedView = layoutInflater.inflate(R.layout.adapter_alege_masina,
                viewGroup,
                false);
//
        TextView tvNrInmatriculare = generatedView.findViewById(R.id.tvNrInmatriculare);
        TextView tvMarca = generatedView.findViewById(R.id.tvMarca);
        TextView tvData = generatedView.findViewById(R.id.tvData);
//
        tvNrInmatriculare.setText(masina.getNrInmatriculare());
        tvMarca.setText(masina.getMarca() + " " + masina.getModel());
        tvData.setText(masina.getData());
//
        return generatedView;
    }
}

