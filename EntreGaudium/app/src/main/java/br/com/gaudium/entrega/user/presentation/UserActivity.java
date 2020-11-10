package br.com.gaudium.entrega.user.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import br.com.gaudium.entrega.R;
import br.com.gaudium.entrega.model.EntregadorJsonObj;
import br.com.gaudium.entrega.user.datasource.UserRemoteDataSource;

public class UserActivity extends Activity implements UserView{

    private UserPresenter presenter;
    private UserRemoteDataSource dataSource;
    private TextView nome, descricao, cargo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        nome = findViewById(R.id.txtNome);
        descricao = findViewById(R.id.txtDescription);
        cargo = findViewById(R.id.txtCargo);


        dataSource = new UserRemoteDataSource();
        presenter = new UserPresenter(this, dataSource);

        presenter.run();

    }


    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEntregador(EntregadorJsonObj obj) {
        nome.setText(obj.getResponse().getNome());
        cargo.setText(obj.getResponse().getCargo());
        descricao.setText(obj.getResponse().getDescricao());

    }
}
