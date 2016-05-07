package com.udacity.android.dicasaprovacao;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.android.dicasaprovacao.utils.Utilitario;


public class PrimeiraDicaActivity extends ActionBarActivity {

    Button btnOpcaoUm;
    Button btnOpcaoDois;
    Button btnOpcaoTres;
    ImageView imageView;
    TextView txtCorreto;
    TextView txtIncorreto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_dica);
        btnOpcaoUm = (Button) findViewById(R.id.btn_opcao_um);
        btnOpcaoDois = (Button) findViewById(R.id.btn_opcao_dois);
        btnOpcaoTres = (Button) findViewById(R.id.btn_opcao_tres);
        imageView = (ImageView) findViewById(R.id.image_dica);
        txtCorreto = (TextView) findViewById(R.id.lbl_correto);
        txtIncorreto = (TextView) findViewById(R.id.lbl_incorreto);

        //Zera a pontuação.
        Utilitario.placar(this, 0);

    }

    public void mtdOpcaoUm(View v) {
        btnOpcaoUm.setBackgroundColor(Color.RED);
        btnOpcaoUm.setTextColor(Color.WHITE);

        marcarOpcaoCorreta();
        desabilitarOpcoes();

        //Colocar a imagem tranparente.
        //http://stackoverflow.com/questions/16755551/alternative-to-setalpha-in-api-level-8
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
    }

    public void mtdOpcaoDois(View v) {
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

        //Marca o placar com valor 1.
        Utilitario.atualizarPlacar(this);


        //TODO: incrementar a pontuação
        //TODO: customizar os botoes
        //http://angrytools.com/android/button/
        //http://belencruz.com/2012/12/rounded-button-with-shadow-in-android/
        // http://mrbool.com/how-to-customize-different-buttons-in-android/27747
        //https://romannurik.github.io/AndroidAssetStudio/index.html

        //TODO: tamanho da font de acordo com tamanho da tela.
        //http://stackoverflow.com/questions/9877946/text-size-and-different-android-screen-sizes
    }

    public void mtdOpcaoTres(View v) {
        btnOpcaoTres.setBackgroundColor(Color.RED);
        btnOpcaoTres.setTextColor(Color.WHITE);

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
    }

    private void marcarOpcaoCorreta() {
        btnOpcaoDois.setBackgroundColor(Color.parseColor("#4CAF50"));
        btnOpcaoDois.setTextColor(Color.WHITE);
    }

    public void desabilitarOpcoes() {
        btnOpcaoUm.setClickable(false);
        btnOpcaoDois.setClickable(false);
        btnOpcaoTres.setClickable(false);
    }

    public void mtdContinuar(View view) {
        Intent intent = new Intent(this, SegundaDicaActivity.class);
        //recreate();
//        finish();
        startActivity(intent);
    }

//    @Override
//    public void recreate() {
//        if (Build.VERSION.SDK_INT <= 11) {
//            startActivity(getIntent());
//            finish();
//        } else {
//            super.recreate();
//        }
//    }
}
