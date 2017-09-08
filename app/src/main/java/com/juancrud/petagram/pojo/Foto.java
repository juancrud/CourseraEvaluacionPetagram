package com.juancrud.petagram.pojo;

public class Foto {

    private int imagen;
    private int rating;
    private String imagenUrl;

    public Foto(){
    }

    public Foto(int imagen, int rating) {
        setImagen(imagen);
        setRating(rating);
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

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
