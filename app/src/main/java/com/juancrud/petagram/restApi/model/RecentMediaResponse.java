package com.juancrud.petagram.restApi.model;

import com.juancrud.petagram.pojo.Foto;

import java.util.ArrayList;

public class RecentMediaResponse {

    private ArrayList<Foto> fotos;

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

}
