package br.com.gaudium.entrega.user.datasource;

import br.com.gaudium.entrega.model.EntregadorJsonObj;
import br.com.gaudium.entrega.user.presentation.UserPresenter;
import br.com.gaudium.entrega.webservice.HttpClient;
import br.com.gaudium.entrega.webservice.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserDataSource {

    @Override
    public void getEntregador(UserPresenter presenter) {
        HttpClient.retrofit().create(UserService.class)
                .getEntregador()
                .enqueue(new Callback<EntregadorJsonObj>() {
                    @Override
                    public void onResponse(Call<EntregadorJsonObj> call, Response<EntregadorJsonObj> response) {
                        presenter.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<EntregadorJsonObj> call, Throwable t) {
                        presenter.onError("Erro ao trazer usuário: " + t.getMessage());

                    }
                });


    }
}
