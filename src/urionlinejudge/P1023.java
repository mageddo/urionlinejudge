package urionlinejudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P1023 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder bf = new StringBuilder();
		int[][] consumos;
		int c=0, qtd, i,j , pessoas, consumoGeral, tmp;
		
		// pegando a cidade
		qtd = Integer.parseInt(r.readLine());
		if(qtd <= 0)
			System.exit(0);
		for(;;){
			consumos = new int[qtd][2];
			pessoas = 0; consumoGeral = 0;
			
			// lendo as pessoas da cidade
			for(i=0; i < qtd; i++){
				String[] valores = r.readLine().split("\\ ");
				consumos[i][0] = Integer.parseInt(valores[0]);
				if(consumos[i][0] <= 0)System.exit(-1);
				else if(consumos[i][0] > 10)System.exit(-1);
				tmp = Integer.parseInt(valores[1]);
				if(tmp <= 0)System.exit(-1);
				else if(tmp > 200)System.exit(-1);
				consumos[i][1] = tmp / consumos[i][0];
				pessoas += consumos[i][0];
				consumoGeral += tmp;
			}
			Collections.sort(Arrays.asList(consumos), new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
				}
			});
			// sorteando
			for(i=0; i < consumos.length; i++){
				for(j=i; j < consumos.length; j++){
					tmp = consumos[i][1];
					if(tmp > consumos[j][1]){
						consumos[i][1] = consumos[j][1];
						consumos[j][1] = tmp;
						tmp = consumos[i][0];
						consumos[i][0] = consumos[j][0];
						consumos[j][0] = tmp;
					}
				}
			}
			
			bf.append(String.format("Cidade# %d:\n", ++c));	
			for(i=0; i < consumos.length; i++){
				bf.append(String.format("%d-%d", consumos[i][0], consumos[i][1]));
				if(i+1 != consumos.length){
					bf.append(" ");
				}
			}
			bf.append(String.format(
				"\nConsumo medio: %.2f m3.", ((double)consumoGeral / (double)pessoas)
			));
			
			if((qtd = Integer.parseInt(r.readLine())) > 0)
				bf.append("\n\n");
			else{
				System.out.println(bf.toString());
				System.exit(0);
			}
		}
	}
}
