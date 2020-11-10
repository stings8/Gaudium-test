package br.com.gaudium.entrega.user.presentation;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import br.com.gaudium.entrega.R;
import br.com.gaudium.entrega.model.EntregadorJsonObj;
import br.com.gaudium.entrega.user.datasource.UserRemoteDataSource;

public class UserActivity extends FragmentActivity implements UserView{

    private UserPresenter presenter;
    private UserRemoteDataSource dataSource;
    private TextView nome, descricao, cargo, txtSaldo, txtEntregas, txtNota;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        nome = findViewById(R.id.txtNome);
        descricao = findViewById(R.id.txtDescription);
        cargo = findViewById(R.id.txtCargo);

        txtSaldo = findViewById(R.id.txtSaldo);
        txtEntregas = findViewById(R.id.txtEntregas);
        txtNota = findViewById(R.id.txtNota);


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
        txtEntregas.setText(String.valueOf(obj.getResponse().getEntregas()));
        txtNota.setText(String.valueOf(obj.getResponse().getNota()));
        txtSaldo.setText(String.valueOf(obj.getResponse().getSaldo()));

    }

}
