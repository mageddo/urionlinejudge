package adhoc.P1090;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by elvis on 14/11/16.
 */
public class Main {

	static int UM_QUADRADO = 114, DOIS_QUADRADOS = 115, TRES_QUADRADOS = 116,
						UM_CIRCULO = 100, DOIS_CIRCULOS = 101, TRES_CIRCULOS = 102,
						UM_TRIANGULO = 117, DOIS_TRIANGULOS = 118, TRES_TRIANGULOS = 119;

	static int[][] validSets = new int[][]{

		{UM_QUADRADO, DOIS_QUADRADOS, TRES_QUADRADOS},
		{UM_CIRCULO, DOIS_CIRCULOS, TRES_CIRCULOS},
		{UM_TRIANGULO, DOIS_TRIANGULOS, TRES_TRIANGULOS},

		{UM_TRIANGULO, DOIS_QUADRADOS, TRES_CIRCULOS},
		{UM_TRIANGULO, TRES_QUADRADOS, DOIS_CIRCULOS},

		{DOIS_TRIANGULOS, UM_QUADRADO, TRES_CIRCULOS},
		{DOIS_TRIANGULOS, TRES_QUADRADOS, UM_CIRCULO},

		{TRES_TRIANGULOS, UM_QUADRADO, DOIS_CIRCULOS},
		{TRES_TRIANGULOS, DOIS_QUADRADOS, UM_CIRCULO},

		{UM_QUADRADO, UM_QUADRADO, UM_QUADRADO},
		{UM_CIRCULO, UM_CIRCULO, UM_CIRCULO},
		{UM_TRIANGULO, UM_TRIANGULO, UM_TRIANGULO},

		{DOIS_QUADRADOS, DOIS_QUADRADOS, DOIS_QUADRADOS},
		{DOIS_CIRCULOS, DOIS_CIRCULOS, DOIS_CIRCULOS},
		{DOIS_TRIANGULOS, DOIS_TRIANGULOS, DOIS_TRIANGULOS},

		{TRES_QUADRADOS, TRES_QUADRADOS, TRES_QUADRADOS},
		{TRES_CIRCULOS, TRES_CIRCULOS, TRES_CIRCULOS},
		{TRES_TRIANGULOS, TRES_TRIANGULOS, TRES_TRIANGULOS},


	};

	public static void main(String[] args) throws IOException {

		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n;
		StringTokenizer tokenizer;
		for (; (n=Integer.parseInt(in.readLine())) != 0;){
//			System.out.println(n);
			int sets = 0;
			MultiValueMap<Integer, Node> map = new MultiValueMap<>();
			for(; n > 0;n--){
				final String str = in.readLine();
				tokenizer = new StringTokenizer(str);
//				System.out.println(str);
				Node node = new Node(getQtd(tokenizer.nextToken().charAt(0)), tokenizer.nextToken().charAt(0));
				map.put(node.hashCode(), node);
			}

			// contando as set formadas por 1 carta de quantidades diferentes e do mesmo naipe

			for(int i=0; i < validSets.length; i++){
				int[] validSet = validSets[i];

				while(true) {

					if(validSet[0] == validSet[1] && validSet[0] == validSet[2]){
						if(map.get(validSet[0]) != null && map.get(validSet[0]).size() >= 3){
							map.pop(validSet[0]);
							map.pop(validSet[1]);
							map.pop(validSet[2]);
							sets++;
							continue;
						}
						break;
					}else if (!map.isKeyEmpty(validSet[0]) && !map.isKeyEmpty(validSet[1]) && !map.isKeyEmpty(validSet[2])){
						map.pop(validSet[0]);
						map.pop(validSet[1]);
						map.pop(validSet[2]);
						sets++;
					} else {
						break;
					}
				}
			}
//			System.out.println("sets=" + sets + ", map=" + map);
			System.out.println(sets);
		}



	}

	private static int getQtd(char c) {
		switch (c){
			case 'u':
				return 1;
			case 'd':
				return 2;
			case 't':
				return 3;
		}
		return -1;
	}

	static class Node {

		int qtd;
		char symbol;

		public Node(int qtd, char symbol) {
			this.qtd = qtd;
			this.symbol = symbol;
		}

		@Override
		public int hashCode() {
			return qtd + symbol;
		}

		@Override
		public String toString() {
			return "{qtd=" + qtd + ", smbl=" + symbol + "}";
		}
	}

	static class MultiValueMap<K,V>  {

		private Map<K,List<V>> map = new HashMap<>();

		public V put(K key, V value) {

			if(!map.containsKey(key)){
				map.put(key, new ArrayList<V>());
			}
			map.get(key).add(value);
			return value;
		}

		public int size() {
			return map.size();
		}

		public boolean isEmpty() {
			return map.isEmpty();
		}

		public boolean containsKey(K key) {
			return map.containsKey(key);
		}

		public boolean isKeyEmpty(K key){
			final List<V> vs = map.get(key);
			return vs == null || vs.isEmpty();
		}

		public List<V> get(K key) {
			return this.map.get(key);
		}

		public Object remove(K key) {
			return map.remove(key);
		}

		public Collection<List<V>> values() {
			return map.values();
		}

		public Set<Map.Entry<K, List<V>>> entrySet() {
			return map.entrySet();
		}

		public V pop(K key){
			return map.get(key).remove(0);
		}

		@Override
		public String toString() {
			return map.toString();
		}
	}

}
