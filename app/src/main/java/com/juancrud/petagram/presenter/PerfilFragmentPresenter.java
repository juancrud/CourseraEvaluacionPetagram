package com.juancrud.petagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.db.SeedData;
import com.juancrud.petagram.restApi.InstagramApi;
import com.juancrud.petagram.restApi.adapter.InstagramApiAdapter;
import com.juancrud.petagram.restApi.model.RecentMediaResponse;
import com.juancrud.petagram.view.IPerfilFragmentView;
import com.juancrud.petagram.pojo.Foto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private Context context;
    private IPerfilFragmentView iPerfilFragmentView;
    private ArrayList<Foto> fotos;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;

        getFotos(5713483640L);
    }

    @Override
    public void getFotos(long userId) {
        //fotos = SeedData.Fotos;

        InstagramApiAdapter instagramApiAdapter = new InstagramApiAdapter();
        Gson deserializer = instagramApiAdapter.buildRecentMediaResponseDeserializer();
        InstagramApi instagramApi =  instagramApiAdapter.getApiConnection(deserializer);
        Call<RecentMediaResponse> recentMediaResponseCall = instagramApi.getRecentMedia(userId);

        recentMediaResponseCall.enqueue(new Callback<RecentMediaResponse>() {
            @Override
            public void onResponse(Call<RecentMediaResponse> call, Response<RecentMediaResponse> response) {
                RecentMediaResponse recentMediaResponse = response.body();
                fotos = recentMediaResponse.getFotos();
                showFotos();
            }

            @Override
            public void onFailure(Call<RecentMediaResponse> call, Throwable t) {
                Toast.makeText(context, "Error en la conexion con Instagram", Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }

    @Override
    public void showFotos() {
        FotosAdapter adapter = iPerfilFragmentView.createAdapter(fotos);
        iPerfilFragmentView.initAdapter(adapter);
        iPerfilFragmentView.setLayoutManager();
    }
}
