package br.com.gaudium.entrega.user.presentation;

import br.com.gaudium.entrega.model.EntregadorJsonObj;
import br.com.gaudium.entrega.user.datasource.UserRemoteDataSource;

public class UserPresenter {

    UserView view;
    UserRemoteDataSource dataSource;

    public UserPresenter(UserView view, UserRemoteDataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;

    }

    public void run () {
        this.dataSource.getEntregador(this);
    }

    public void onSuccess(EntregadorJsonObj obj) {
        this.view.showEntregador(obj);
    }

    public void onError(String msg) {
        this.view.showError(msg);
    }


}
