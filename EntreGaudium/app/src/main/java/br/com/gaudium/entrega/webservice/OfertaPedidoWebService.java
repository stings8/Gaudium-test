package br.com.gaudium.entrega.webservice;

import android.content.Context;

import br.com.gaudium.entrega.model.PedidoJsonObj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfertaPedidoWebService {
    String URL = "https://dbgapi-desenv.taximachine.com.br/ps/ofertaPedido.php";

    public void obterPedido(Context ctx, OfertaPedidoCallback callback) {
        HttpClient.retrofit().create(PedidoService.class)
                .getPedidos()
                .enqueue(new Callback<PedidoJsonObj>() {
                    @Override
                    public void onResponse(Call<PedidoJsonObj> call, Response<PedidoJsonObj> response) {
                        callback.run(response.body().getResponse());
                    }

                    @Override
                    public void onFailure(Call<PedidoJsonObj> call, Throwable t) {

                    }
                });

    }


    public interface OfertaPedidoCallback {
        void run(PedidoJsonObj.PedidoObj ofertaPedido);
    }
}
