package com.juancrud.petagram.view;

import com.juancrud.petagram.adapter.MascotaAdapter;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IListaFragmentView {
    void setLayoutManager();
    MascotaAdapter createAdapter(ArrayList<Mascota> mascotas);
    void initAdapter(MascotaAdapter adapter);
}
