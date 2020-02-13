package com.uau.android.uau_edu.RecyclerAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uau.android.uau_edu.Objects.Divida;
import com.uau.android.uau_edu.R;

import java.util.ArrayList;
import java.util.List;

public class DividasAdapter extends RecyclerView.Adapter<DividasAdapter.Holder> {

    private List<Divida> dividasList = new ArrayList<>();

    @NonNull
    @Override
    public DividasAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_dividas, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DividasAdapter.Holder holder, int position) {
        Divida divida = dividasList.get(position);

        int number = position+1;
        holder.numero.setText(""+number);
        holder.titulo.setText(divida.getTitulo());
        holder.contrato.setText(divida.getContrato());
        holder.data.setText(divida.getData());
        holder.valor.setText(divida.getValor());

    }

    @Override
    public int getItemCount() {
        return dividasList.size();
    }

    public void setDividasList(List<Divida> dividasList){
        this.dividasList = dividasList;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder{

        private TextView numero;
        private TextView titulo;
        private TextView contrato;
        private TextView data;
        private TextView valor;

        public Holder(@NonNull View itemView) {
            super(itemView);

            numero = itemView.findViewById(R.id.list_item_divida_numero);
            titulo = itemView.findViewById(R.id.list_item_divida_titulo);
            contrato = itemView.findViewById(R.id.list_item_divida_contrato);
            data = itemView.findViewById(R.id.list_item_divida_data);
            valor = itemView.findViewById(R.id.list_item_divida_valor);

        }
    }
}
