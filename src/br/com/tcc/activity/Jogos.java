package br.com.tcc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import br.com.tcc.libras.R;

public class Jogos extends Activity {

	private static final String LIBRAS = "LIBRAS";

	private Button btn1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_jogos);
		
		btn1 = (Button) findViewById(R.id.btnJogo1);
		
		btn1.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent(Jogos.this, JogoMemoria.class);
				startActivity(i);
				Log.i(LIBRAS, "INICIANDO JOGO DA MEMÓRIA");		
			}
		});
	}

}