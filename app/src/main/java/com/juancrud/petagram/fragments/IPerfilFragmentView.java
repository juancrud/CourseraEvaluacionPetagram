package com.juancrud.petagram.fragments;

import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.pojo.Foto;

import java.util.ArrayList;

public interface IPerfilFragmentView {
    void setLayoutManager();
    FotosAdapter createAdapter(ArrayList<Foto> fotos);
    void initAdapter(FotosAdapter adapter);
}
