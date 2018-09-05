package br.com.tcc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

public class OrientacaoUtils {
	// Verifica qual orienta��o da tela
	public static int getOrientation(Context context) {
		int orientacao = context.getResources().getConfiguration().orientation;
		return orientacao;
	}
	
	// Verifica se a orienta��o da tela est� na vertical
	public static boolean isVertical(Context context) {
		int orientacao = context.getResources().getConfiguration().orientation;
		boolean vertical = orientacao == Configuration.ORIENTATION_PORTRAIT;
		return vertical;
	}
	
	// Verifica se a orienta��o da tela esta na horizontal
	public static boolean isHorizontal(Context context) {
		int orientacao = context.getResources().getConfiguration().orientation;
		boolean horizontal = orientacao == Configuration.ORIENTATION_LANDSCAPE;
		return horizontal;
	}
	
	// Solicita a execu��o da activity na vertical
	public static void setOrientacaoVertical(Activity context){
		context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);		
	}
	
	// Solicita a execu��o da activity na horizontal
	public static void setOrientacaohorizontal(Activity context){
		context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);		
	}

}
