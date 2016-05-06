package com.udacity.android.dicasaprovacao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SegundaDicaActivity extends ActionBarActivity {

    Button btnOpcaoUm;
    Button btnOpcaoDois;
    Button btnOpcaoTres;
    ImageView imageView;
    TextView txtCorreto;
    TextView txtIncorreto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_dica);

        btnOpcaoUm = (Button) findViewById(R.id.btn_opcao_um);
        btnOpcaoDois = (Button) findViewById(R.id.btn_opcao_dois);
        btnOpcaoTres = (Button) findViewById(R.id.btn_opcao_tres);
        imageView = (ImageView) findViewById(R.id.image_dica);
        txtCorreto = (TextView) findViewById(R.id.lbl_correto);
        txtIncorreto = (TextView) findViewById(R.id.lbl_incorreto);

        TextView txtPlacar = (TextView) findViewById(R.id.lbl_pontuacao_valor);
        txtPlacar.setText(String.valueOf(obterPlacar()));
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
        if (Build.VERSION.SDK_INT < 11) {
            //Colocar a imagem tranparente.
            imageView.setAlpha(30);
        } else {
            imageView.setAlpha(0.3f);
        }
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
        if (Build.VERSION.SDK_INT < 11) {
            imageView.setAlpha(30);
        } else {
            imageView.setAlpha(0.3f);
        }

        //Atualiza placar
        int valorPlacar = obterPlacar();
        valorPlacar++;
        placar(valorPlacar);
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
        if (Build.VERSION.SDK_INT < 11) {
            imageView.setAlpha(30);
        } else {
            imageView.setAlpha(0.3f);
        }
    }

    private void marcarOpcaoCorreta() {
        btnOpcaoTres.setBackgroundColor(Color.parseColor("#4CAF50"));
        btnOpcaoTres.setTextColor(Color.WHITE);
    }

    private void placar(int pontuacao) {
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.shared_pontuacao), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Limpar as configurações anteriores.
        editor.clear();
        editor.commit();

        // Salva as novas configurações.
        editor.putInt(getString(R.string.shared_pontuacao), pontuacao);
        editor.commit();
    }

    private int obterPlacar() {
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.shared_pontuacao), Context.MODE_PRIVATE);
        return sharedPref.getInt(getString(R.string.shared_pontuacao), 0);
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
