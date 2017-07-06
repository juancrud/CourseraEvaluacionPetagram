package com.juancrud.petagram.pojo;

public class Mascota {

    private int id;
    private String nombre;
    private int imagen;
    private int rating;

    public Mascota(){}

    public Mascota(String nombre, int imagen, int rating){
        setNombre(nombre);
        setImagen(imagen);
        setRating(rating);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
