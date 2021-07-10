package com.example.autocare2021.adaptere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Km;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class KmAdapter extends BaseAdapter {
    private List<Km> kmList;
    private Context context;

    public KmAdapter(List<Km> kmList, Context context) {
        this.kmList = kmList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return kmList.size();
    }

    @Override
    public Object getItem(int position) {
        return kmList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
//
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View generatedView = layoutInflater.inflate(R.layout.adapter_km,
                null,
                true);
//
        Km km = kmList.get(position);
//
        TextView tvTitlu = generatedView.findViewById(R.id.tvNumeAdapterKm);
        TextView tvData = generatedView.findViewById(R.id.tvAdapterDataKm1);
        TextView tvOra = generatedView.findViewById(R.id.tvAdapterOraKm1);
        TextView tvIndex = generatedView.findViewById(R.id.tvAdapterIndexKm1);
        TextView tvObservatii = generatedView.findViewById(R.id.tvAdapterObsKm1);
//
        tvTitlu.setText("Activitatea");
//
        tvData.setText(km.getData());
        tvOra.setText(String.valueOf(km.getOra()));
        tvIndex.setText(String.valueOf(km.getIndex()));
        tvObservatii.setText(km.getObservatii());
//
        return generatedView;
    }
}
