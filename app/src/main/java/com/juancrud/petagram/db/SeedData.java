package com.juancrud.petagram.db;

import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class SeedData {

    public static ArrayList<Mascota> Mascotas;

    static {
        Mascotas = new ArrayList<>();
        Mascotas.add(new Mascota("Ximun", R.drawable.ximun, 9));
        Mascotas.add(new Mascota("Beto", R.drawable.beto, 10));
        Mascotas.add(new Mascota("Chanchito", R.drawable.chanchito, 7));
        Mascotas.add(new Mascota("Silvestre", R.drawable.silvestre, 9));
        Mascotas.add(new Mascota("Ronny", R.drawable.ronny, 6));
        Mascotas.add(new Mascota("Catty", R.drawable.catty, 7));
        Mascotas.add(new Mascota("Birdy", R.drawable.birdy, 1));
        Mascotas.add(new Mascota("Fishy", R.drawable.fishy, 4));
        Mascotas.add(new Mascota("Doggy", R.drawable.doggy, 8));
        Mascotas.add(new Mascota("Test", R.drawable.test, 3));
    }

}
