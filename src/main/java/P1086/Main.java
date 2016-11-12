package P1086;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by elvis on 12/11/16.
 */
public class Main {

	public static final String IMPOSSIVEL = "impossivel";

	public static void main(String[] args) throws IOException {

		final Scanner r = new Scanner(System.in);

	/*
		dimensao do salao em metros  (1 ≤ N,M ≤ 104)
	*/
		int dimensaoX, dimensaoY;

	/*
		em cm (1 ≤ L ≤ 100)
	*/
		int larguraTabuas;

	/*
		(1 ≤ K ≤ 105)
	*/
		int tabuasDoadas;

	/*
		tamanho de cada tabua doada (1 ≤ Xi ≤ 104 para 1 ≤ i ≤ K)
	*/
	Integer[] tamanhoTabuasDoadas;

		do{

			// primeira linha
			dimensaoX = r.nextInt();


			dimensaoY = r.nextInt();

			// segunda linha
			larguraTabuas = r.nextInt();


			// terceira linha
			tabuasDoadas = r.nextInt();

			// quarta linha
			tamanhoTabuasDoadas = new Integer[tabuasDoadas];

			int i=0;
			for(; i < tabuasDoadas; i++){
				tamanhoTabuasDoadas[i] = r.nextInt();
			}
			r.nextLine();

			float larguraTabuasMetro = larguraTabuas / 100.0f;


			Arrays.sort(tamanhoTabuasDoadas, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return b - a;
				}
			});

			int r1 = calcQtdTabuas(tabuasDoadas, Arrays.copyOf(tamanhoTabuasDoadas, tamanhoTabuasDoadas.length),
					larguraTabuasMetro, dimensaoY, dimensaoX);
			int r2 = calcQtdTabuas(tabuasDoadas, tamanhoTabuasDoadas, larguraTabuasMetro, dimensaoX, dimensaoY);
			if(r1 > -1 && r2 > -1){
				System.out.println(r1 < r2 ? r1 : r2);
			}else if(r1 > -1 || r2 > -1){
				System.out.println(r1 > r2 ? r1 : r2);
			}else{
				System.out.println(IMPOSSIVEL);
			}


		}while(!r.nextLine().equals("0 0"));
	}

	static int calcQtdTabuas(int tabuasDoadas, Integer[] tamanhoTabuasDoadas, float larguraTabuasMetro, int dimensaoY, int dimensaoX){

		if(dimensaoX * 100 % (int)(larguraTabuasMetro * 100) != 0){
			return -1;
		}

		int qtdTabuas = 0, qtdTabuasLargura = 0, qtdTabuasNecessariasLargura = (int) (dimensaoX / larguraTabuasMetro);
		int[] resultado = new int[qtdTabuasNecessariasLargura];



		for (int j = 0; j < tabuasDoadas; j++) {
			if(qtdTabuasLargura == qtdTabuasNecessariasLargura)return qtdTabuas;
			int primeiraTabua = tamanhoTabuasDoadas[j];
			if(primeiraTabua == dimensaoY){
				qtdTabuas++;
				qtdTabuasLargura++;
			}else if(primeiraTabua < dimensaoY){
				int diferenca = dimensaoY - primeiraTabua;
//				for (int k = tabuasDoadas-1; k > j+1; k--) {
				for (int k = j+1; k < tabuasDoadas; k++) {
					int segundaTabua = tamanhoTabuasDoadas[k];
					if(diferenca == segundaTabua){
						qtdTabuas += 2;
						tamanhoTabuasDoadas[j] = -1;
						tamanhoTabuasDoadas[k] = -1;
						qtdTabuasLargura++;
						break;
					}
				}
			}
		}
		return qtdTabuasLargura == qtdTabuasNecessariasLargura ? qtdTabuas : -1;
	}
}
