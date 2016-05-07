package com.udacity.android.dicasaprovacao.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.udacity.android.dicasaprovacao.R;

/**
 * Created by Maycon on 07/05/2016.
 */
public class Utilitario {

    public static void placar(Context context, int pontuacao) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.shared_pontuacao), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Limpar as configurações anteriores.
        editor.clear();
        editor.commit();

        // Salva as novas configurações.
        editor.putInt(context.getString(R.string.shared_pontuacao), pontuacao);
        editor.commit();
    }

    public static int obterPlacar(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.shared_pontuacao), Context.MODE_PRIVATE);
        int valor = sharedPref.getInt(context.getString(R.string.shared_pontuacao), 0);
        Log.d("Dicas", "Metodo Obter Pontuação: " + valor);
        return valor;
    }

    public static void atualizarPlacar(Context context) {
        int valor = obterPlacar(context);
        Log.d("Dicas", "Metodo Atualizar Pontuação: " + valor);
        valor = valor + 1;
        placar(context, valor);
    }
}
