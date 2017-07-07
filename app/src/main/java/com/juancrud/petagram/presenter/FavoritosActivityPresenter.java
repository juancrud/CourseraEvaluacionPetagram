package com.juancrud.petagram.presenter;

import android.content.Context;

import com.juancrud.petagram.adapter.MascotaAdapter;
import com.juancrud.petagram.db.DatabaseManager;
import com.juancrud.petagram.pojo.Mascota;
import com.juancrud.petagram.view.IListaMascotasView;

import java.util.ArrayList;

public class FavoritosActivityPresenter implements IListaMascotasPresenter {

    private Context context;
    private IListaMascotasView iListaMascotasView;
    private ArrayList<Mascota> mascotas;

    public FavoritosActivityPresenter(IListaMascotasView iListaMascotasView, Context context) {
        this.iListaMascotasView = iListaMascotasView;
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
        MascotaAdapter adapter = iListaMascotasView.createAdapter(mascotas);
        iListaMascotasView.initAdapter(adapter);
        iListaMascotasView.setLayoutManager();
    }
}
