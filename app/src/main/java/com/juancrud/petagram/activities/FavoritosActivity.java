package com.juancrud.petagram.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.juancrud.petagram.adapter.MascotaAdapter;
import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Mascota;
import com.juancrud.petagram.presenter.FavoritosActivityPresenter;
import com.juancrud.petagram.presenter.IListaFragmentPresenter;
import com.juancrud.petagram.presenter.ListaFragmentPresenter;
import com.juancrud.petagram.view.IListaFragmentView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IListaFragmentView {

    private RecyclerView rvFavoritos;
    private IListaFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        rvFavoritos = (RecyclerView)findViewById(R.id.rvFavoritos);
        presenter = new FavoritosActivityPresenter(this, this);
    }

    @Override
    public void setLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritos.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter createAdapter(ArrayList<Mascota> mascotas) {
        return new MascotaAdapter(mascotas, this);
    }

    @Override
    public void initAdapter(MascotaAdapter adapter) {
        rvFavoritos.setAdapter(adapter);
    }
}
