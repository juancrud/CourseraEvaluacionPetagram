package com.juancrud.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juancrud.petagram.Datos;
import com.juancrud.petagram.MascotaAdapter;
import com.juancrud.petagram.R;

public class ListaFragment extends Fragment {

    private RecyclerView rvMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        rvMascotas = (RecyclerView)view.findViewById(R.id.rvMascotas);
        initRecyclerView();
        initAdapter();

        return view;
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void initAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(Datos.Mascotas);
        rvMascotas.setAdapter(adapter);
    }

}
