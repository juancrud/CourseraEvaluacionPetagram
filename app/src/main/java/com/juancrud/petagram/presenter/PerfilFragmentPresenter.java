package com.juancrud.petagram.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juancrud.petagram.R;
import com.juancrud.petagram.adapter.FotosAdapter;
import com.juancrud.petagram.db.SeedData;
import com.juancrud.petagram.pojo.UserProfile;
import com.juancrud.petagram.restApi.InstagramApi;
import com.juancrud.petagram.restApi.adapter.InstagramApiAdapter;
import com.juancrud.petagram.restApi.model.RecentMediaResponse;
import com.juancrud.petagram.restApi.model.SearchUserResponse;
import com.juancrud.petagram.view.IPerfilFragmentView;
import com.juancrud.petagram.pojo.Foto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragmentView iPerfilFragmentView;
    private Activity activity;
    InstagramApiAdapter instagramApiAdapter;

    private ArrayList<Foto> fotos;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Activity activity) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.activity = activity;
        instagramApiAdapter = new InstagramApiAdapter();

        getData();
    }

    public void getData(){
        String cuentaKey = activity.getString(R.string.CuentaKey);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String cuentaActual = preferences.getString(cuentaKey, null);

        if(cuentaActual != null){
            getProfile(cuentaActual);
        }
    }

    public void getProfile(String nombreCuenta){
        Gson deserializer = instagramApiAdapter.buildSearchUserResponseDeserializer();
        InstagramApi instagramApi =  instagramApiAdapter.getApiConnection(deserializer);
        Call<SearchUserResponse> searchUserResponseCall = instagramApi.searchUser(nombreCuenta);

        searchUserResponseCall.enqueue(new Callback<SearchUserResponse>() {
            @Override
            public void onResponse(Call<SearchUserResponse> call, Response<SearchUserResponse> response) {
                SearchUserResponse searchUserResponse = response.body();
                UserProfile userProfile = searchUserResponse.getUserProfile();
                if(userProfile == null){
                    Toast.makeText(activity, "Usuario invalido en Instagram", Toast.LENGTH_SHORT).show();
                }
                else{
                    setProfileInfo(userProfile);
                    getFotos(userProfile.getId());
                }
            }

            @Override
            public void onFailure(Call<SearchUserResponse> call, Throwable t) {
                Toast.makeText(activity, "Error en la conexion con Instagram", Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }

    @Override
    public void getFotos(long userId) {
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
                Toast.makeText(activity, "Error en la conexion con Instagram", Toast.LENGTH_SHORT).show();
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

    public void setProfileInfo(UserProfile userProfile){
        iPerfilFragmentView.setUserProfile(userProfile);
    }
}
