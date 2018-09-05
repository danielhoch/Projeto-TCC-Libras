package br.com.tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import br.com.tcc.activity.AlfabetoEmLibras;
import br.com.tcc.activity.Jogos;
import br.com.tcc.activity.Tradutor;
import br.com.tcc.libras.R;

public class Principal extends Activity{
	
	private static final String LIBRAS = "LIBRAS";
	private Button btnTradutor = null;
	private Button btnJogos = null;
	private Button btnSobre = null;
	private Button btnAlfabeto = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_principal);
		
		btnTradutor = (Button) findViewById(R.id.btnTradutor);
		btnJogos = (Button) findViewById(R.id.btnJogos);
		btnSobre = (Button) findViewById(R.id.btnSobre);
		btnAlfabeto = (Button) findViewById(R.id.btnAlfabeto);
		
		btnAlfabeto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent(Principal.this, AlfabetoEmLibras.class );
				startActivity(i);
				Log.i(LIBRAS, "INICIANDO TELA ALFABETO EM LIBRAS");
			}
		});
		
		btnTradutor.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent(Principal.this, Tradutor.class);
				startActivity(i);
				Log.i(LIBRAS, "INICIANDO TELA DE TRADUÇÃO");				
			}
		});
		
		btnJogos.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(Principal.this, Jogos.class);
				startActivity(i);
				Log.i(LIBRAS, "INICIANDO TELA DE JOGOS");		
			}
		});
	
		
		btnSobre.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Log.i(LIBRAS, "INICIANDO TELA SOBRE");	
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.tela_principal, menu);
		return true;
	}

}
