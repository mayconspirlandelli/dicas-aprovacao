package com.udacity.android.dicasaprovacao;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.udacity.android.dicasaprovacao.utils.Utilitario;

public class SegundaDicaActivity extends ActionBarActivity {

    Button btnOpcaoUm;
    Button btnOpcaoDois;
    Button btnOpcaoTres;
    TextView txtCorreto;
    TextView txtIncorreto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_dica);

        btnOpcaoUm = (Button) findViewById(R.id.btn_opcao_um);
        btnOpcaoDois = (Button) findViewById(R.id.btn_opcao_dois);
        btnOpcaoTres = (Button) findViewById(R.id.btn_opcao_tres);
        txtCorreto = (TextView) findViewById(R.id.lbl_correto);
        txtIncorreto = (TextView) findViewById(R.id.lbl_incorreto);

        TextView txtPlacar = (TextView) findViewById(R.id.lbl_pontuacao_valor);
        txtPlacar.setText(String.valueOf(Utilitario.obterPlacar(this)));
    }

    public void mtdOpcaoUm(View v) {
        btnOpcaoUm.setBackgroundColor(Color.RED);
        btnOpcaoUm.setTextColor(Color.WHITE);

        marcarOpcaoCorreta();
        desabilitarOpcoes();

        //Exibir o texto CORRRETO ou INCORRETO.
        txtIncorreto.setVisibility(View.VISIBLE);
        RotateAnimation animation = new RotateAnimation(0, -45);
        animation.setDuration(100);
        animation.setFillAfter(true);
        txtIncorreto.startAnimation(animation);
    }

    public void mtdOpcaoDois(View v) {
        btnOpcaoDois.setBackgroundColor(Color.RED);
        btnOpcaoDois.setTextColor(Color.WHITE);

        marcarOpcaoCorreta();
        desabilitarOpcoes();

        //Exibir o texto CORRRETO ou INCORRETO.
        txtIncorreto.setVisibility(View.VISIBLE);
        RotateAnimation animation = new RotateAnimation(0, -45);
        animation.setDuration(100);
        animation.setFillAfter(true);
        txtIncorreto.startAnimation(animation);
    }

    public void mtdOpcaoTres(View v) {
        marcarOpcaoCorreta();
        desabilitarOpcoes();

        //Exibir o texto CORRRETO ou INCORRETO.
        txtCorreto.setVisibility(View.VISIBLE);
        RotateAnimation animation = new RotateAnimation(0, -45);
        animation.setDuration(100);
        animation.setFillAfter(true);
        txtCorreto.startAnimation(animation);

        //Atualiza placar
        Utilitario.atualizarPlacar(this);
    }

    private void marcarOpcaoCorreta() {
        btnOpcaoTres.setBackgroundColor(Color.parseColor("#4CAF50"));
        btnOpcaoTres.setTextColor(Color.WHITE);
    }

    private void desabilitarOpcoes() {
        btnOpcaoUm.setClickable(false);
        btnOpcaoDois.setClickable(false);
        btnOpcaoTres.setClickable(false);
    }

    public void mtdContinuar(View view) {
        Intent intent = new Intent(this, TerceiraDicaActivity.class);
        finish();
        startActivity(intent);
    }
}
