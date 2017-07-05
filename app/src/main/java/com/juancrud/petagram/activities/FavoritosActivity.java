package com.juancrud.petagram.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.juancrud.petagram.Datos;
import com.juancrud.petagram.MascotaAdapter;
import com.juancrud.petagram.R;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView rvFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        rvFavoritos = (RecyclerView)findViewById(R.id.rvFavoritos);

        initRecyclerView();
        initAdapter();
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritos.setLayoutManager(llm);
    }

    private void initAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(Datos.Top5Mascotas);
        rvFavoritos.setAdapter(adapter);
    }
}
