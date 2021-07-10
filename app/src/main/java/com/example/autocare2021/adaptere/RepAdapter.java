package com.example.autocare2021.adaptere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Reparatii;

import java.util.List;

public class RepAdapter extends BaseAdapter {
    private List<Reparatii> repList;
    private Context context;

    public RepAdapter(List<Reparatii> repList, Context context) {
        this.repList = repList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return repList.size();
    }

    @Override
    public Object getItem(int position) {
        return repList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
//
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View generatedView = layoutInflater.inflate(R.layout.adapter_reparatii,
                null,
                true);
//
        Reparatii reparatii = repList.get(position);
//
        TextView tvTitlu = generatedView.findViewById(R.id.tvNumeAdapterRep);
        TextView tvMasina = generatedView.findViewById(R.id.tvAdapterMasinaRep1);
        TextView tvData = generatedView.findViewById(R.id.tvAdapterDataRep1);
        TextView tvService = generatedView.findViewById(R.id.tvAdapterServRep1);
        TextView tvObservatii = generatedView.findViewById(R.id.tvAdapterObsRep1);
        TextView tvValoare = generatedView.findViewById(R.id.tvAdapterValoareRep1);
//
        tvTitlu.setText("Reparatie");
//
        tvMasina.setText(reparatii.getMasina());
        tvData.setText(reparatii.getData());
        tvService.setText(String.valueOf(reparatii.getService()));
        tvObservatii.setText(reparatii.getReparatii());
        tvValoare.setText(String.valueOf(reparatii.getValoare()));
//
        return generatedView;
    }
}
