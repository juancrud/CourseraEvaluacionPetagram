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

import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.presenter.IPerfilFragmentPresenter;
import com.juancrud.petagram.presenter.PerfilFragmentPresenter;
import com.juancrud.petagram.view.IPerfilFragmentView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    private ImageView ivFoto;
    private TextView tvNombre;
    private RecyclerView rvFotos;
    private IPerfilFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ivFoto = (ImageView)view.findViewById(R.id.ivFoto);
        tvNombre = (TextView)view.findViewById(R.id.tvNombre);
        rvFotos = (RecyclerView)view.findViewById(R.id.rvFotos);

        presenter = new PerfilFragmentPresenter(this, getActivity());

        return view;
    }

    @Override
    public void setLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotos.setLayoutManager(glm);
    }

    @Override
    public FotosAdapter createAdapter(ArrayList<Foto> fotos) {
        return new FotosAdapter(fotos, getActivity());
    }

    @Override
    public void initAdapter(FotosAdapter adapter) {
        rvFotos.setAdapter(adapter);
    }
}
