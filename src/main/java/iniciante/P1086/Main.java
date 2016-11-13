package iniciante.P1086;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by elvis on 12/11/16.
 */
public class Main {

	private static final byte[] IMPOSSIVEL = "impossivel".getBytes();
	private static long START = System.nanoTime();

	static class Calc {
		Calc next;

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
	}

	public static void main(String[] args) throws IOException {

		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final Calc head = new Calc();
		Calc curr = head;

	String lastLine = in.readLine();
		do{

//			printEnd("start");

			final StringTokenizer dimensoes = new StringTokenizer(lastLine);


			// primeira linha
			curr.dimensaoX = Integer.parseInt(dimensoes.nextToken());
			curr.dimensaoY = Integer.parseInt(dimensoes.nextToken());

			// segunda linha
			curr.larguraTabuas = Integer.parseInt(in.readLine());


			// terceira linha
			curr.tabuasDoadas = Integer.parseInt(in.readLine());

			// quarta linha
			curr.tamanhoTabuasDoadas = new Integer[curr.tabuasDoadas];

			StringTokenizer boards = new StringTokenizer(in.readLine());
			int i=0, countTokens = boards.countTokens();
			for(; i < countTokens; i++){
				curr.tamanhoTabuasDoadas[i] = Integer.parseInt(boards.nextToken());
			}

//			printEnd("in");

		}while(!(lastLine = in.readLine()).equals("0 0") && (curr = curr.next = new Calc())!= null);

		for(curr = head; curr != null; curr = curr.next){

//			float larguraTabuasMetro = curr.larguraTabuas / 100.0f;

			Arrays.sort(curr.tamanhoTabuasDoadas, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

//			printEnd("sort");

			int r1 = calcQtdTabuas(curr.tamanhoTabuasDoadas,
				curr.larguraTabuas, curr.dimensaoX, curr.dimensaoY);
			int r2 = calcQtdTabuas(curr.tamanhoTabuasDoadas, curr.larguraTabuas, curr.dimensaoY, curr.dimensaoX);

//			printEnd("calc");

			if(r1 > -1 && r2 > -1){
				out.write(Integer.toString(r1 < r2 ? r1 : r2).getBytes());
				out.write('\n');
			}else if(r1 > -1 || r2 > -1){
				out.write(Integer.toString(r1 > r2 ? r1 : r2).getBytes());
				out.write('\n');
			}else{
				out.write(IMPOSSIVEL);
				out.write('\n');
			}

//			printEnd("out");
		}

		out.flush();
	}

	static int calcQtdTabuas(Integer[] tamanhoTabuasDoadas, int larguraTabuas, int dimensaoX, int dimensaoY){

		if(dimensaoX * 100 % larguraTabuas != 0){
			return -1;
		}
		int begin, end, vertical_boards, boards_used,  boards_to_complete = (dimensaoX * 100 / larguraTabuas);
		begin = 0;
		end = tamanhoTabuasDoadas.length - 1;
		vertical_boards = 0;
		boards_used = 0;

		while (true) {
			if (vertical_boards == boards_to_complete) break;
			if (begin > end) return -1;

			if (tamanhoTabuasDoadas[begin] > dimensaoY) {
				begin++;
			} else if (tamanhoTabuasDoadas[begin] == dimensaoY) {
				begin++;
				vertical_boards++;
				boards_used++;
			} else {
				if (begin != end) {
					while (true) {
						if(end < 0 || begin < 0){
							end--;
						}
						if (tamanhoTabuasDoadas[begin] + tamanhoTabuasDoadas[end] == dimensaoY) {
							end--;
							vertical_boards++;
							boards_used += 2;
							break;
						}
						if (tamanhoTabuasDoadas[begin] + tamanhoTabuasDoadas[end] > dimensaoY) {
							break;
						}
					}
				}
				begin++;
			}
		}

		return boards_used;
	}

//	static void printEnd(String msg){
//		System.out.printf("\t\t%s=%d\n", msg, System.nanoTime() - START);
//		START = System.nanoTime();
//	}
}
