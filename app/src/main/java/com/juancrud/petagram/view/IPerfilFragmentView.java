package com.juancrud.petagram.view;

import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.pojo.UserProfile;

import java.util.ArrayList;

public interface IPerfilFragmentView {
    void setLayoutManager();
    FotosAdapter createAdapter(ArrayList<Foto> fotos);
    void initAdapter(FotosAdapter adapter);
    void setUserProfile(UserProfile userProfile);
}
