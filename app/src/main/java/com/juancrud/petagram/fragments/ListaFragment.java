package com.juancrud.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juancrud.petagram.adapter.MascotaAdapter;
import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Mascota;
import com.juancrud.petagram.presenter.IListaFragmentPresenter;
import com.juancrud.petagram.presenter.ListaFragmentPresenter;
import com.juancrud.petagram.view.IListaFragmentView;

import java.util.ArrayList;

public class ListaFragment extends Fragment implements IListaFragmentView {

    private RecyclerView rvMascotas;
    private IListaFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        rvMascotas = (RecyclerView)view.findViewById(R.id.rvMascotas);
        presenter = new ListaFragmentPresenter(this, getActivity());
        return view;
    }

    @Override
    public void setLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotas) {
        return new MascotaAdapter(mascotas, getActivity());
    }

    @Override
    public void initAdapter(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}
