package br.com.gaudium.entrega.user.presentation;

import br.com.gaudium.entrega.model.EntregadorJsonObj;

public interface UserView {

    void showError(String msg);

    void showEntregador(EntregadorJsonObj obj);

}
