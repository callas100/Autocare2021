package com.example.autocare2021.adaptere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Reparatii;
import com.example.autocare2021.clase6.Revizii;

import java.util.List;

public class RevAdapter extends BaseAdapter {
    private List<Revizii> revList;
    private Context context;

    public RevAdapter(List<Revizii> revList, Context context) {
        this.revList = revList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return revList.size();
    }

    @Override
    public Object getItem(int position) {
        return revList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
//
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View generatedView = layoutInflater.inflate(R.layout.adapter_revizii,
                null,
                true);
//
        Revizii revizii = revList.get(position);
//
        TextView tvTitlu = generatedView.findViewById(R.id.tvNumeAdapterRep);
        TextView tvBujii = generatedView.findViewById(R.id.tvAdapterBujiiRev1);
        TextView tvFAer = generatedView.findViewById(R.id.tvAdapterFAerRev1);
        TextView tvFBenz = generatedView.findViewById(R.id.tvAdapterFBenzRev1);
        TextView tvRotor = generatedView.findViewById(R.id.tvAdapterRotorRev1);
        TextView tvUlei = generatedView.findViewById(R.id.tvAdapterUleiRev1);
//
        tvTitlu.setText("Revizie");
//
        tvBujii.setText(String.valueOf(revizii.getBujii()).toString());
        tvFAer.setText(String.valueOf(revizii.getFiltruAer()).toString());
        tvFBenz.setText(String.valueOf(revizii.getFiltruBenzina()).toString());
        tvRotor.setText(String.valueOf(revizii.getRotor()).toString());
        tvUlei.setText(String.valueOf(revizii.isSchimbUlei()).toString());
//
        return generatedView;
    }
}
