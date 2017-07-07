package com.juancrud.petagram.db;

import com.juancrud.petagram.R;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class SeedData {

    public static ArrayList<Mascota> Mascotas;

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
    }

}
