package br.com.tcc.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import br.com.tcc.libras.R;

public class Tradutor extends Activity {

	private static final String LIBRAS = "LIBRAS";
	private static final int REQUEST_CODE = 1234;
	private ImageView img = null;
	private Gallery galeria = null;

	String[] alfabeto = { "a", "à", "ã", "b", "c", "ç", "d", "e", "é", "ê",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "ô", "õ", "p",
			"q", "r", "s", "t", "u", "v", "x", "y", "z", "w", "?", "!", " ",
			".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_reconhecimento_voz);

		Button speakButton = (Button) findViewById(R.id.speakButton);
		img = (ImageView) findViewById(R.id.imagem);
		galeria = (Gallery) findViewById(R.id.galeria);

		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() == 0) {
			speakButton.setEnabled(false);
			speakButton
					.setText("O dispositivo não possui reconhecimento de voz");
		}

	}

	public void speakButtonClicked(View v) {
		startVoiceRecognitionActivity();
		Log.i(LIBRAS, "INICIANDO RECONHECIMENTO");
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;
		private Integer[] imagens = null;

		public ImageAdapter(Context context, Integer... imagens) {
			this.context = context;
			this.imagens = imagens;
		}

		@Override
		public int getCount() {
			return imagens.length;
		}

		@Override
		public Object getItem(int position) {
			return imagens[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			ImageView iv = new ImageView(context);

			iv.setImageResource(imagens[position]);
			iv.setScaleType(ImageView.ScaleType.FIT_START);
			iv.setLayoutParams(new Gallery.LayoutParams(120, 120));

			return iv;
		}
	}

	private void startVoiceRecognitionActivity() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "reconhecendo a voz...");
		startActivityForResult(intent, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
			// PREENCHENDO A LISTA COM TEXTO
			ArrayList<String> matches = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

			String texto = matches.get(0);
			separaLetras(texto);
		}
	}

	private void mudarImagem(final Integer... imagens) {
		// img.setImageResource(novaImagem);
		// Log.i("ANDROID", getResources().getResourceEntryName(novaImagem));
		// Thread t = new Thread(new ResimCek(R.drawable.c, R.drawable.a,
		// R.drawable.s, R.drawable.a));

		galeria.setAdapter(new ImageAdapter(this, imagens));

		galeria.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				img.setImageResource(imagens[position]);
			}
		});

		Thread t = new Thread(new ImageViewRunnable(imagens));

		t.start();
	}

	public class ImageViewRunnable implements Runnable {
		private Integer[] imagens = null;
		private int novaImagem = 0;

		public ImageViewRunnable(Integer... imagens) {
			this.imagens = imagens;
		}

		public void run() {
			for (int i = 0; i < imagens.length; i++) {
				novaImagem = imagens[i];

				runOnUiThread(new Runnable() {
					public void run() {
						img.setImageResource(novaImagem);
					}
				});

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void separaLetras(String txt) {
		int alfaNumerico = 0;

		txt = txt.toLowerCase();

		Integer[] imagens = new Integer[txt.length()];
		int posicaoImagens = 0;

		try {
			for (int j = 1; j <= txt.length(); j++) {
				String a = txt.substring(j - 1, j);

				Log.i("ANDROID", a);

				for (int i = 0; i < alfabeto.length; i++) {
					String b = alfabeto[i];
					if (a.equals(b)) {
						alfaNumerico = i;
						// Log.i(LIBRAS, "ACHEI UMA LETRA " + txt.substring(j -
						// 1, j) + " posicao[ " + cont + " ]");
						// i = 36;
						break;
					}
				}

				Log.i("ANDROID", Integer.toString(alfaNumerico));

				if (alfaNumerico == 0 || alfaNumerico == 1 || alfaNumerico == 2) {
					imagens[posicaoImagens++] = R.drawable.a;
					Log.i(LIBRAS, "LETRA A");
				}

				if (alfaNumerico == 3) {
					imagens[posicaoImagens++] = R.drawable.b;
					Log.i(LIBRAS, "LETRA B");
				}

				if (alfaNumerico == 4) {
					imagens[posicaoImagens++] = R.drawable.c;
					Log.i(LIBRAS, "LETRA C");
				}

				if (alfaNumerico == 5) {
					imagens[posicaoImagens++] = R.drawable.c2;
					Log.i(LIBRAS, "LETRA Ç");
				}

				if (alfaNumerico == 6) {
					imagens[posicaoImagens++] = R.drawable.d;
					Log.i(LIBRAS, "LETRA D");
				}

				if (alfaNumerico == 7 || alfaNumerico == 8 || alfaNumerico == 9) {
					imagens[posicaoImagens++] = R.drawable.e;
					Log.i(LIBRAS, "LETRA E");
				}

				if (alfaNumerico == 10) {
					imagens[posicaoImagens++] = R.drawable.f;
					Log.i(LIBRAS, "LETRA F");
				}

				if (alfaNumerico == 11) {
					imagens[posicaoImagens++] = R.drawable.g;
					Log.i(LIBRAS, "LETRA G");
				}

				if (alfaNumerico == 12) {
					imagens[posicaoImagens++] = R.drawable.h;
					Log.i(LIBRAS, "LETRA H");
				}

				if (alfaNumerico == 13) {
					imagens[posicaoImagens++] = R.drawable.i;
					Log.i(LIBRAS, "LETRA I");
				}

				if (alfaNumerico == 14) {
					imagens[posicaoImagens++] = R.drawable.j;
					Log.i(LIBRAS, "LETRA J");
				}

				if (alfaNumerico == 15) {
					imagens[posicaoImagens++] = R.drawable.k;
					Log.i(LIBRAS, "LETRA K");
				}

				if (alfaNumerico == 16) {
					imagens[posicaoImagens++] = R.drawable.l;
					Log.i(LIBRAS, "LETRA L");
				}

				if (alfaNumerico == 17) {
					imagens[posicaoImagens++] = R.drawable.m;
					Log.i(LIBRAS, "LETRA M");
				}

				if (alfaNumerico == 18) {
					imagens[posicaoImagens++] = R.drawable.n;
					Log.i(LIBRAS, "LETRA N");
				}

				if (alfaNumerico == 19 || alfaNumerico == 20
						|| alfaNumerico == 21) {
					imagens[posicaoImagens++] = R.drawable.o;
					Log.i(LIBRAS, "LETRA O");
				}

				if (alfaNumerico == 22) {
					imagens[posicaoImagens++] = R.drawable.p;
					Log.i(LIBRAS, "LETRA P");
				}

				if (alfaNumerico == 23) {
					imagens[posicaoImagens++] = R.drawable.q;
					Log.i(LIBRAS, "LETRA Q");
				}

				if (alfaNumerico == 24) {
					imagens[posicaoImagens++] = R.drawable.r;
					Log.i(LIBRAS, "LETRA R");
				}

				if (alfaNumerico == 25) {
					imagens[posicaoImagens++] = R.drawable.s;
					Log.i(LIBRAS, "LETRA S");
				}

				if (alfaNumerico == 26) {
					imagens[posicaoImagens++] = R.drawable.t;
					Log.i(LIBRAS, "LETRA T");
				}

				if (alfaNumerico == 27) {
					imagens[posicaoImagens++] = R.drawable.u;
					Log.i(LIBRAS, "LETRA U");
				}

				if (alfaNumerico == 28) {
					imagens[posicaoImagens++] = R.drawable.v;
					Log.i(LIBRAS, "LETRA V");
				}

				if (alfaNumerico == 29) {
					imagens[posicaoImagens++] = R.drawable.x;
					Log.i(LIBRAS, "LETRA X");
				}

				if (alfaNumerico == 30) {
					imagens[posicaoImagens++] = R.drawable.y;
					Log.i(LIBRAS, "LETRA Y");
				}

				if (alfaNumerico == 31) {
					imagens[posicaoImagens++] = R.drawable.z;
					Log.i(LIBRAS, "LETRA Z");
				}

				if (alfaNumerico == 32) {
					imagens[posicaoImagens++] = R.drawable.w;
					Log.i(LIBRAS, "LETRA W");
				}

				if (alfaNumerico == 33) {
					imagens[posicaoImagens++] = R.drawable.interrogacao;
					Log.i(LIBRAS, "LETRA ?");
				}

				if (alfaNumerico == 34) {
					imagens[posicaoImagens++] = R.drawable.exclamacao;
					Log.i(LIBRAS, "LETRA !");
				}

				if (alfaNumerico == 35) {
					imagens[posicaoImagens++] = R.drawable.espaco;
					Log.i(LIBRAS, "ESPAÇO");
				}

				if (alfaNumerico == 36) {
					imagens[posicaoImagens++] = R.drawable.ponto;
					Log.i(LIBRAS, "LETRA .");
				}

				if (alfaNumerico == 37) {
					imagens[posicaoImagens++] = R.drawable.um;
					Log.i(LIBRAS, "NÚMERO 1");
				}

				if (alfaNumerico == 38) {
					imagens[posicaoImagens++] = R.drawable.dois;
					Log.i(LIBRAS, "NÚMERO 2");
				}

				if (alfaNumerico == 39) {
					imagens[posicaoImagens++] = R.drawable.tres;
					Log.i(LIBRAS, "NÚMERO 3");
				}

				if (alfaNumerico == 40) {
					imagens[posicaoImagens++] = R.drawable.quatro;
					Log.i(LIBRAS, "NÚMERO 4");
				}

				if (alfaNumerico == 41) {
					imagens[posicaoImagens++] = R.drawable.cinco;
					Log.i(LIBRAS, "NÚMERO 5");
				}

				if (alfaNumerico == 42) {
					imagens[posicaoImagens++] = R.drawable.seis;
					Log.i(LIBRAS, "NÚMERO 6");
				}

				if (alfaNumerico == 43) {
					imagens[posicaoImagens++] = R.drawable.sete;
					Log.i(LIBRAS, "NÚMERO 7");
				}

				if (alfaNumerico == 44) {
					imagens[posicaoImagens++] = R.drawable.oito;
					Log.i(LIBRAS, "NÚMERO 8");
				}

				if (alfaNumerico == 45) {
					imagens[posicaoImagens++] = R.drawable.nove;
					Log.i(LIBRAS, "NÚMERO 9");
				}

				if (alfaNumerico == 46) {
					imagens[posicaoImagens++] = R.drawable.zero;
					Log.i(LIBRAS, "NÚMERO 0");
				}

			}
			mudarImagem(imagens);

		} catch (Exception e) {
		}
	}

}
