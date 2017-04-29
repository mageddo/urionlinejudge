package adhoc.P1082;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by elvis on 15/11/16.
 */
public class Main {

	private static final int LINES = 5;

	public static void main(String[] args) throws IOException {
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int i, j=0, k, sum;
		final int[][] books = new int[LINES][];

		for(i = 0; i < LINES; i++){
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			j = Integer.parseInt(tokenizer.nextToken());
			books[i] = new int[j];
			for(k=0; k < j; k++){
				books[i][k] = Integer.parseInt(tokenizer.nextToken());
			}
			Arrays.sort(books[i]);
		}
		final int conjuntos = Integer.parseInt(in.readLine());
		sum = 0;
		for(i=0; i < conjuntos; i++){
			boolean first = true;
			for(j=0; j < books.length; j++){
				int[] book = books[j];
				if(first && i != 0){
					sum += book[book.length - j - 1];
					first = false;
				}else{
					sum += book[book.length -1];
				}
			}
		}
		for (int[] bt: books)
			System.out.println(Arrays.toString(bt));

		System.out.println(sum);
	}
}
