package br.com.gaudium.entrega.webservice;

import br.com.gaudium.entrega.model.PedidoJsonObj;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PedidoService {

    @GET("/ps/ofertaPedido.php")
    Call<PedidoJsonObj> getPedidos();
}
