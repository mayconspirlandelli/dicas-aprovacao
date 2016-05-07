package com.udacity.android.dicasaprovacao;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.udacity.android.dicasaprovacao.utils.Utilitario;

public class PontuacaoActivity extends ActionBarActivity {

    TextView txtPontuacaoFinal;
    TextView txtMensagemFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        txtPontuacaoFinal = (TextView) findViewById(R.id.lbl_pontuacao_final);
        txtMensagemFinal = (TextView) findViewById(R.id.lbl_mensagem_final);

        publicacaoResultado();
    }

    private void publicacaoResultado() {

        int resultado = Utilitario.obterPlacar(this);

        txtPontuacaoFinal.setText(String.valueOf(resultado));

        if (resultado >= 0 && resultado <= 2) {
            txtMensagemFinal.setText(getText(R.string.lbl_aviso));
        } else {
            txtMensagemFinal.setText(getText(R.string.lbl_parabens));
        }

    }

}
