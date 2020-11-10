package br.com.gaudium.entrega.webservice;

import br.com.gaudium.entrega.model.EntregadorJsonObj;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("/ps/perfil.php")
    Call<EntregadorJsonObj> getEntregador();

}
