package com.juancrud.petagram.presenter;

import android.content.Context;

import com.juancrud.petagram.adapter.MascotaAdapter;
import com.juancrud.petagram.db.DatabaseManager;
import com.juancrud.petagram.pojo.Mascota;
import com.juancrud.petagram.view.IListaFragmentView;

import java.util.ArrayList;

public class FavoritosActivityPresenter implements IListaFragmentPresenter {

    private Context context;
    private IListaFragmentView iListaFragmentView;
    private ArrayList<Mascota> mascotas;

    public FavoritosActivityPresenter(IListaFragmentView iListaFragmentView, Context context) {
        this.iListaFragmentView = iListaFragmentView;
        this.context = context;

        getMascotas();
        showMascotas();
    }

    @Override
    public void getMascotas() {
        DatabaseManager dbManager = new DatabaseManager(context);
        mascotas = dbManager.getUltimos5Likes();
    }

    @Override
    public void showMascotas() {
        MascotaAdapter adapter = iListaFragmentView.createAdapter(mascotas);
        iListaFragmentView.initAdapter(adapter);
        iListaFragmentView.setLayoutManager();
    }
}
