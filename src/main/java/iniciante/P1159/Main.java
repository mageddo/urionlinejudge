package iniciante.P1159;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		int x, y;
		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(;(x = Integer.parseInt(in.readLine())) != 0;){

			int sum=0;
			for(y=5;y > 0;x++){
				if(Math.abs(x % 2) == 0){
					y--;
					sum += x;
				}
			}
			out.write(Integer.toString(sum).getBytes());
			out.write('\n');

		}
		out.flush();
	}
}
