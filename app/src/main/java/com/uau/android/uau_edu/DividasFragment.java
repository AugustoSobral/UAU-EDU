package com.uau.android.uau_edu;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uau.android.uau_edu.Objects.Divida;
import com.uau.android.uau_edu.RecyclerAdapters.DividasAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DividasFragment extends Fragment {

    private DividasAdapter dividasAdapter;
    private List<Divida> dividasList = new ArrayList<>();


    public DividasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dividas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_dividas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        dividasAdapter = new DividasAdapter();
        recyclerView.setAdapter(dividasAdapter);

        Divida divida1 = new Divida("BANCO DO BRASIL", "10928949", "02/01/2020", "R$1200");
        dividasList.add(divida1);
        Divida divida2 = new Divida("TELEFÔNICA S/A", "112328947", "01/01/2020", "R$700");
        dividasList.add(divida2);

        dividasAdapter.setDividasList(dividasList);

    }
}
