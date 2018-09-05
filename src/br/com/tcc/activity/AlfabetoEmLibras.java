package br.com.tcc.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import br.com.tcc.libras.R;

public class AlfabetoEmLibras extends Activity {

	private ImageButton btn1 = null;
	private ImageButton btn2 = null;
	private ImageButton btn3 = null;
	private ImageButton btn4 = null;
	private ImageButton btn5 = null;
	private ImageButton btn6 = null;
	private ImageButton btn7 = null;
	private ImageButton btn8 = null;
	private ImageButton btn9 = null;
	private ImageButton btn10 = null;
	private ImageButton btn11 = null;
	private ImageButton btn12 = null;
	private ImageButton btn13 = null;
	private ImageButton btn14 = null;
	private ImageButton btn15 = null;
	private ImageButton btn16 = null;
	private ImageButton btn17 = null;
	private ImageButton btn18 = null;
	private ImageButton btn19 = null;
	private ImageButton btn20 = null;
	private ImageButton btn21 = null;
	private ImageButton btn22 = null;
	private ImageButton btn23 = null;
	private ImageButton btn24 = null;
	private ImageButton btn25 = null;
	private ImageButton btn26 = null;
	private ImageButton btn27 = null;

	private Button btnTraduzir = null;

	private ImageView img = null;
	private Gallery galeria = null;

	private EditText edtexto = null;

	private static final String LIBRAS = "LIBRAS";

	String[] alfabeto = { "a", "à", "ã", "b", "c", "ç", "d", "e", "é", "ê",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "ô", "õ", "p",
			"q", "r", "s", "t", "u", "v", "x", "y", "z", "w", "?", "!", " ",
			".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_alfabeto_libras);

		inicializaComponentes();

		inicializaListener();

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

	private void mudarImagem(final Integer... imagens) {

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

	private void inicializaListener() {

		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("q");
				separaLetras(texto);
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("w");
				separaLetras(texto);
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("e");
				separaLetras(texto);
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("r");
				separaLetras(texto);
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("t");
				separaLetras(texto);
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("y");
				separaLetras(texto);
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("u");
				separaLetras(texto);
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("i");
				separaLetras(texto);
			}
		});
		btn9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("o");
				separaLetras(texto);
			}
		});
		btn10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("p");
				separaLetras(texto);
			}
		});
		btn11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("a");
				separaLetras(texto);
			}
		});
		btn12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("s");
				separaLetras(texto);
			}
		});
		btn13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("d");
				separaLetras(texto);
			}
		});
		btn14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("f");
				separaLetras(texto);
			}
		});
		btn15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("g");
				separaLetras(texto);
			}
		});
		btn16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("h");
				separaLetras(texto);
			}
		});
		btn17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("j");
				separaLetras(texto);
			}
		});
		btn18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("k");
				separaLetras(texto);
			}
		});
		btn19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("l");
				separaLetras(texto);
			}
		});

		btn20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("ç");
				separaLetras(texto);
			}
		});

		btn21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("z");
				separaLetras(texto);
			}
		});
		btn22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("x");
				separaLetras(texto);
			}
		});
		btn23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("c");
				separaLetras(texto);
			}
		});
		btn24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("v");
				separaLetras(texto);
			}
		});
		btn25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("b");
				separaLetras(texto);
			}
		});
		btn26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("n");
				separaLetras(texto);
			}
		});
		btn27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf("m");
				separaLetras(texto);
			}
		});

		btnTraduzir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String texto = String.valueOf(edtexto.getText());
				separaLetras(texto);
			}
		});
	}

	private void inicializaComponentes() {

		btn1 = (ImageButton) findViewById(R.id.btn1);
		btn2 = (ImageButton) findViewById(R.id.btn2);
		btn3 = (ImageButton) findViewById(R.id.btn3);
		btn4 = (ImageButton) findViewById(R.id.btn4);
		btn5 = (ImageButton) findViewById(R.id.btn5);
		btn6 = (ImageButton) findViewById(R.id.btn6);
		btn7 = (ImageButton) findViewById(R.id.btn7);
		btn8 = (ImageButton) findViewById(R.id.btn8);
		btn9 = (ImageButton) findViewById(R.id.btn9);
		btn10 = (ImageButton) findViewById(R.id.btn10);
		btn11 = (ImageButton) findViewById(R.id.btn11);
		btn12 = (ImageButton) findViewById(R.id.btn12);
		btn13 = (ImageButton) findViewById(R.id.btn13);
		btn14 = (ImageButton) findViewById(R.id.btn14);
		btn15 = (ImageButton) findViewById(R.id.btn15);
		btn16 = (ImageButton) findViewById(R.id.btn16);
		btn17 = (ImageButton) findViewById(R.id.btn17);
		btn18 = (ImageButton) findViewById(R.id.btn18);
		btn19 = (ImageButton) findViewById(R.id.btn19);
		btn20 = (ImageButton) findViewById(R.id.btn20);
		btn21 = (ImageButton) findViewById(R.id.btn21);
		btn22 = (ImageButton) findViewById(R.id.btn22);
		btn23 = (ImageButton) findViewById(R.id.btn23);
		btn24 = (ImageButton) findViewById(R.id.btn24);
		btn25 = (ImageButton) findViewById(R.id.btn25);
		btn26 = (ImageButton) findViewById(R.id.btn26);
		btn27 = (ImageButton) findViewById(R.id.btn27);

		btnTraduzir = (Button) findViewById(R.id.btnTraduzir);

		img = (ImageView) findViewById(R.id.imagem);
		galeria = (Gallery) findViewById(R.id.galeria);

		edtexto = (EditText) findViewById(R.id.edtTexto);
	}
}
