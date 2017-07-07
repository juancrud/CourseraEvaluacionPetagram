package com.juancrud.petagram.presenter;

import android.content.Context;

import com.juancrud.petagram.Datos;
import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.fragments.IPerfilFragmentView;
import com.juancrud.petagram.pojo.Foto;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private Context context;
    private IPerfilFragmentView iPerfilFragmentView;
    private ArrayList<Foto> fotos;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;

        getFotos();
        showFotos();
    }

    @Override
    public void getFotos() {
        fotos = Datos.Fotos;
    }

    @Override
    public void showFotos() {
        FotosAdapter adapter = iPerfilFragmentView.createAdapter(fotos);
        iPerfilFragmentView.initAdapter(adapter);
        iPerfilFragmentView.setLayoutManager();
    }
}
