package com.juancrud.petagram.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.juancrud.petagram.R;
import com.juancrud.petagram.db.DatabaseManager;
import com.juancrud.petagram.db.MascotaLikeDbHelper;
import com.juancrud.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private DatabaseManager dbManager;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Context context){
        this.mascotas = mascotas;
        dbManager = new DatabaseManager(context);
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    private void initListeners(final MascotaViewHolder holder, final Mascota mascota){
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.insertLike(mascota);
                mascota.setRating(dbManager.getLikes(mascota));
                holder.tvRating.setText(""+mascota.getRating());
            }
        });
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRating.setText(""+mascota.getRating());
        initListeners(holder, mascota);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
