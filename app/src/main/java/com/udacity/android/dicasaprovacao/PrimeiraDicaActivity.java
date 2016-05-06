package com.udacity.android.dicasaprovacao;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class PrimeiraDicaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_dica);
    }


    public void mtdOpcaoOrganizacao(View v) {
        Button btnOpcao = (Button) findViewById(R.id.btn_organizacao);
//        btnOpcao.setBackground(Dr);
    }

}
