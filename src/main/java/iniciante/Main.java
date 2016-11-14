package iniciante;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 13/11/16.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		final BufferedOutputStream out = new BufferedOutputStream(System.out);
		final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[20];

		for(int i=0; i<20; i++){
			arr[i] = Integer.parseInt(in.readLine());
		}
		for(int i=19; i>=0; i--){
			out.write(String.format("N[%d] = %d\n", 20 - i - 1, arr[i]).getBytes());
		}
		out.flush();

	}
}
