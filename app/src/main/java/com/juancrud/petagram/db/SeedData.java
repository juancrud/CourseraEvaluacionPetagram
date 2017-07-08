package com.juancrud.petagram.db;

import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class SeedData {

    public static ArrayList<Mascota> Mascotas;

    public static ArrayList<Foto> Fotos;

    static {
        Mascotas = new ArrayList<>();
        Mascotas.add(new Mascota("Ximun", R.drawable.ximun));
        Mascotas.add(new Mascota("Beto", R.drawable.beto));
        Mascotas.add(new Mascota("Chanchito", R.drawable.chanchito));
        Mascotas.add(new Mascota("Silvestre", R.drawable.silvestre));
        Mascotas.add(new Mascota("Ronny", R.drawable.ronny));
        Mascotas.add(new Mascota("Catty", R.drawable.catty));
        Mascotas.add(new Mascota("Birdy", R.drawable.birdy));
        Mascotas.add(new Mascota("Fishy", R.drawable.fishy));
        Mascotas.add(new Mascota("Doggy", R.drawable.doggy));
        Mascotas.add(new Mascota("Test", R.drawable.test));

        Fotos = new ArrayList<>();
        Fotos.add(new Foto(R.drawable.beto, 3));
        Fotos.add(new Foto(R.drawable.beto, 2));
        Fotos.add(new Foto(R.drawable.beto, 6));
        Fotos.add(new Foto(R.drawable.beto, 4));
        Fotos.add(new Foto(R.drawable.beto, 9));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 1));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 8));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 9));
        Fotos.add(new Foto(R.drawable.beto, 5));
    }

}
