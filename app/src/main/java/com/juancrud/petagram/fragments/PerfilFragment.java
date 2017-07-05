package com.juancrud.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.juancrud.petagram.Datos;
import com.juancrud.petagram.FotosAdapter;
import com.juancrud.petagram.R;

public class PerfilFragment extends Fragment {

    private ImageView ivFoto;
    private TextView tvNombre;
    private RecyclerView rvFotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ivFoto = (ImageView)view.findViewById(R.id.ivFoto);
        tvNombre = (TextView)view.findViewById(R.id.tvNombre);
        rvFotos = (RecyclerView)view.findViewById(R.id.rvFotos);

        initRecyclerView();
        initAdapter();

        return view;
    }

    private void initRecyclerView() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotos.setLayoutManager(glm);
    }

    private void initAdapter() {
        FotosAdapter adapter = new FotosAdapter(Datos.Fotos);
        rvFotos.setAdapter(adapter);
    }

}
