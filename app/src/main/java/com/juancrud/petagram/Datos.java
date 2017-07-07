package com.juancrud.petagram;

import com.juancrud.petagram.pojo.Foto;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Datos {

    public static ArrayList<Mascota> Top5Mascotas;

    public static ArrayList<Foto> Fotos;

    public static void initDatos(){
        Top5Mascotas = new ArrayList<>();
        Top5Mascotas.add(new Mascota("Beto", R.drawable.beto));
        Top5Mascotas.add(new Mascota("Ximun", R.drawable.ximun));
        Top5Mascotas.add(new Mascota("Silvestre", R.drawable.silvestre));
        Top5Mascotas.add(new Mascota("Doggy", R.drawable.doggy));
        Top5Mascotas.add(new Mascota("Chanchito", R.drawable.chanchito));

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
