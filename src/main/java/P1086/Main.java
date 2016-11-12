package P1086;

import java.io.IOException;
import java.util.Arrays;
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
	String lastLine = r.nextLine();
		do{

			String[] dimensoes = lastLine.split(" ");

			// primeira linha
			dimensaoX = Integer.parseInt(dimensoes[0]);
			dimensaoY = Integer.parseInt(dimensoes[1]);

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
			Arrays.sort(tamanhoTabuasDoadas);
			int r1 = calcQtdTabuas(tabuasDoadas, tamanhoTabuasDoadas,
					larguraTabuasMetro, dimensaoX, dimensaoY);
			int r2 = calcQtdTabuas(tabuasDoadas, tamanhoTabuasDoadas, larguraTabuasMetro, dimensaoY, dimensaoX);
			if(r1 > -1 && r2 > -1){
				System.out.println(r1 < r2 ? r1 : r2);
			}else if(r1 > -1 || r2 > -1){
				System.out.println(r1 > r2 ? r1 : r2);
			}else{
				System.out.println(IMPOSSIVEL);
			}

		}while(!(lastLine = r.nextLine()).equals("0 0"));
	}

	static int calcQtdTabuas(int tabuasDoadas, Integer[] tamanhoTabuasDoadas, float larguraTabuasMetro, int dimensaoX, int dimensaoY){

		if(dimensaoX * 100 % (int)(larguraTabuasMetro * 100) != 0){
			return -1;
		}

		int qtdTabuas = 0, qtdTabuasLargura = 0, qtdTabuasNecessariasLargura = (int) (dimensaoX / larguraTabuasMetro),
		lastIndex = 0;
		for(int i=tabuasDoadas-1; i >= 0; i--){
			int tabua = tamanhoTabuasDoadas[i], resto = dimensaoY - tabua;
			if(resto > 0 && lastIndex <= i){
				int index = Arrays.binarySearch(tamanhoTabuasDoadas, lastIndex, i, resto);
				if(index >= 0){
					lastIndex = index+1;
					qtdTabuas += 2;
					qtdTabuasLargura++;
				}
			}else if(resto == 0){
				qtdTabuas++;
				qtdTabuasLargura++;
			}
			if(qtdTabuasLargura == qtdTabuasNecessariasLargura)return qtdTabuas;
		}
		return -1;
	}
}
