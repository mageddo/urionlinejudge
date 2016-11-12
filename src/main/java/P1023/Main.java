package P1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	static class Consumo {
		public int pessoas;
		public int consumo;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder bf = new StringBuilder();
		List<Consumo> consumos;
		int c=0, qtd, i,j , pessoas, consumoGeral, tmp;
		
		// pegando a cidade
		qtd = Integer.parseInt(r.readLine());
		if(qtd <= 0)
			System.exit(0);
		for(;;){
			pessoas = 0; consumoGeral = 0;
			consumos = new ArrayList<>();
			// lendo as pessoas da cidade
			for(i=0; i < qtd; i++){
				String[] valores = r.readLine().split("\\ ");
				Consumo consumo = new Consumo();
				consumo.pessoas = Integer.parseInt(valores[0]);
				if(consumo.pessoas <= 0)System.exit(-1);
				else if(consumo.pessoas > 10)System.exit(-1);
				tmp = Integer.parseInt(valores[1]);
				if(tmp <= 0)System.exit(-1);
				else if(tmp > 200)System.exit(-1);
				consumo.consumo = tmp / consumo.pessoas;
				pessoas += consumo.pessoas;
				consumoGeral += tmp;
				consumos.add(consumo);
			}
			// sorteando
			Collections.sort(consumos, new Comparator<Consumo>(){

				@Override
				public int compare(Consumo o1, Consumo o2) {
					return Integer.compare(o1.consumo, o2.consumo);
				}
				
			});
			
			bf.append(String.format("Cidade# %d:\n", ++c));	
		
			for(i=0; i < qtd; i++){
				bf.append(String.format("%d-%d", consumos.get(i).pessoas, consumos.get(i).consumo));
				if(i+1 != qtd){
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
