package br.com.tcc.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import br.com.tcc.libras.R;

public class JogoMemoria extends Activity {

	private static final String LIBRAS = "LIBRAS";

	private ImageButton imageButton1 = null;
	private ImageButton imageButton2 = null;
	private ImageButton imageButton3 = null;
	private ImageButton imageButton4 = null;
	private ImageButton imageButton5 = null;
	private ImageButton imageButton6 = null;
	private ImageButton imageButton7 = null;
	private ImageButton imageButton8 = null;
	private ImageButton imageButton9 = null;
	private ImageButton imageButton10 = null;
	private ImageButton imageButton11 = null;
	private ImageButton imageButton12 = null;
	private ImageButton imageButton13 = null;
	private ImageButton imageButton14 = null;
	private ImageButton imageButton15 = null;
	private ImageButton imageButton16 = null;

	int pontos = 0;

	private Map<ImageButton, Drawable> botoesImagens = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_jogomemoria);

		inicializaButtons();

		inicializarJogo();

	}

	private void inicializarJogo() {

		botoesImagens = new HashMap<ImageButton, Drawable>();

		List<Drawable> alfa = new ArrayList<Drawable>();
		alfa.add(getResources().getDrawable(R.drawable.a));
		alfa.add(getResources().getDrawable(R.drawable.b));
		alfa.add(getResources().getDrawable(R.drawable.c));
		alfa.add(getResources().getDrawable(R.drawable.d));
		alfa.add(getResources().getDrawable(R.drawable.e));
		alfa.add(getResources().getDrawable(R.drawable.f));
		alfa.add(getResources().getDrawable(R.drawable.g));
		alfa.add(getResources().getDrawable(R.drawable.h));
		alfa.add(getResources().getDrawable(R.drawable.i));
		alfa.add(getResources().getDrawable(R.drawable.j));
		alfa.add(getResources().getDrawable(R.drawable.l));
		alfa.add(getResources().getDrawable(R.drawable.k));
		alfa.add(getResources().getDrawable(R.drawable.m));
		alfa.add(getResources().getDrawable(R.drawable.n));
		alfa.add(getResources().getDrawable(R.drawable.o));
		alfa.add(getResources().getDrawable(R.drawable.p));
		alfa.add(getResources().getDrawable(R.drawable.q));
		alfa.add(getResources().getDrawable(R.drawable.r));
		alfa.add(getResources().getDrawable(R.drawable.s));
		alfa.add(getResources().getDrawable(R.drawable.t));
		alfa.add(getResources().getDrawable(R.drawable.u));
		alfa.add(getResources().getDrawable(R.drawable.v));
		alfa.add(getResources().getDrawable(R.drawable.x));
		alfa.add(getResources().getDrawable(R.drawable.z));

		List<ImageButton> imgButton = new ArrayList<ImageButton>();
		imgButton.add(imageButton1);
		imgButton.add(imageButton2);
		imgButton.add(imageButton3);
		imgButton.add(imageButton4);
		imgButton.add(imageButton5);
		imgButton.add(imageButton6);
		imgButton.add(imageButton7);
		imgButton.add(imageButton8);
		imgButton.add(imageButton9);
		imgButton.add(imageButton10);
		imgButton.add(imageButton11);
		imgButton.add(imageButton12);
		imgButton.add(imageButton13);
		imgButton.add(imageButton14);
		imgButton.add(imageButton15);
		imgButton.add(imageButton16);

		Collections.shuffle(imgButton);
		Collections.shuffle(alfa);
		int imgB = 0, j = 0;
		for (int i = 0; i < 8; i++) {
			j = 0;
			while (j < 2) {
				botoesImagens.put(imgButton.get(imgB), alfa.get(i));
				j++;
				imgB++;
			}
		}

		// botoesImagens.put(imgButton.get(0), alfa.get(0));
		// botoesImagens.put(imgButton.get(1), alfa.get(1));
		// botoesImagens.put(imgButton.get(2), alfa.get(2));
		// botoesImagens.put(imgButton.get(3), alfa.get(3));
		// botoesImagens.put(imgButton.get(4), alfa.get(4));
		// botoesImagens.put(imgButton.get(5), alfa.get(5));
		// botoesImagens.put(imgButton.get(6), alfa.get(6));
		// botoesImagens.put(imgButton.get(7), alfa.get(7));
		//
		// botoesImagens.put(imgButton.get(8), alfa.get(0));
		// botoesImagens.put(imgButton.get(9), alfa.get(1));
		// botoesImagens.put(imgButton.get(10), alfa.get(2));
		// botoesImagens.put(imgButton.get(11), alfa.get(3));
		// botoesImagens.put(imgButton.get(12), alfa.get(4));
		// botoesImagens.put(imgButton.get(13), alfa.get(5));
		// botoesImagens.put(imgButton.get(14), alfa.get(6));
		// botoesImagens.put(imgButton.get(15), alfa.get(7));

		configurarBotoes(imageButton1, imageButton2, imageButton3,
				imageButton4, imageButton5, imageButton6, imageButton7,
				imageButton8, imageButton9, imageButton10, imageButton11,
				imageButton12, imageButton13, imageButton14, imageButton15,
				imageButton16);

	}

	private void configurarBotoes(ImageButton... botoes) {
		if (botoes != null && botoes.length > 0) {
			for (final ImageButton botao : botoes) {
				botao.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						clicarBotao(botao);
					}
				});
			}
		}
	}

	private int indexCliques = 0;
	private List<ImageButton> botoesClicados = new ArrayList<ImageButton>();

	private void clicarBotao(final ImageButton botao) {
		indexCliques++;

		botoesClicados.add(botao);

//		if (indexCliques > 1) {
//			if (botoesClicados.get(0).getId() == botoesClicados.get(1).getId()) {
//				indexCliques = 0;
//				Log.i(LIBRAS, "Valor index: " + indexCliques);
//			}
//		}
		
		Drawable imagem = botoesImagens.get(botao);

		int width = botao.getWidth();
		int height = botao.getHeight();

		botao.setImageDrawable(imagem);

		botao.setMinimumWidth(width);
		botao.setMaxWidth(width);

		botao.setMinimumHeight(height);
		botao.setMaxHeight(height);

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(999);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				botao.post(new Runnable() {

					@Override
					public void run() {

						if (indexCliques > 1) {
							indexCliques = 0;

							boolean isCorrect = botoesClicados
									.get(0)
									.getDrawable()
									.equals(botoesClicados.get(1).getDrawable());

							if (!isCorrect) {
								for (ImageButton botaoClicado : botoesClicados) {
									botaoClicado
											.setImageDrawable(getResources()
													.getDrawable(
															R.drawable.ic_launcher));
								}
							}

							if (isCorrect) {
								pontos++;
								finalizar();
							}
							botoesClicados = new ArrayList<ImageButton>();
						}
					}

				});
			}
		}).start();

	}

	public void finalizar() {

		if (pontos == 8) {
			Toast.makeText(this,
					"Parabéns você completou com o tempo de: " + pontos,
					Toast.LENGTH_LONG).show();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finish();
		}
	}

	private void inicializaButtons() {

		imageButton1 = (ImageButton) findViewById(R.id.btn1);
		imageButton2 = (ImageButton) findViewById(R.id.btn2);
		imageButton3 = (ImageButton) findViewById(R.id.btn3);
		imageButton4 = (ImageButton) findViewById(R.id.btn4);
		imageButton5 = (ImageButton) findViewById(R.id.btn5);
		imageButton6 = (ImageButton) findViewById(R.id.btn6);
		imageButton7 = (ImageButton) findViewById(R.id.btn7);
		imageButton8 = (ImageButton) findViewById(R.id.btn8);
		imageButton9 = (ImageButton) findViewById(R.id.btn9);
		imageButton10 = (ImageButton) findViewById(R.id.btn10);
		imageButton11 = (ImageButton) findViewById(R.id.btn11);
		imageButton12 = (ImageButton) findViewById(R.id.btn12);
		imageButton13 = (ImageButton) findViewById(R.id.btn13);
		imageButton14 = (ImageButton) findViewById(R.id.btn14);
		imageButton15 = (ImageButton) findViewById(R.id.btn15);
		imageButton16 = (ImageButton) findViewById(R.id.btn16);
	}

}
