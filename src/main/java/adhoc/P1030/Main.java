package adhoc.P1030;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by elvis on 14/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()), a, b, i, j, k=1;

		StringTokenizer tokenizer;
		for(; k <= n; k++){

			tokenizer = new StringTokenizer(in.readLine());
			a = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());

			if(b == 1){
				out.write(String.format("Case %d: %d\n", k, a).getBytes());
				continue;
			}

			Soldier head = new Soldier(1), token, last = head;
			for(i=2; i <= a; i++){
					last = last.next = new Soldier(i);
			}
			last.next = head;
			last = head;

			for(i=1, token=head; token.next != token; i++, token = token.next){

				if(i % b == 0){
					last.next = token.next;
				}else if(i > 1){
					last = last.next;
				}
			}

			out.write(String.format("Case %d: %d\n", k, token.n).getBytes());
		}
		out.flush();
	}

	static class Soldier {
		int n;
		Soldier next;

		public Soldier(int i) {
			this.n = i;
		}

		@Override
		public String toString() {
			return Integer.toString(n);
		}
	}
}
