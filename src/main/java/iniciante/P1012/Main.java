package iniciante.P1012;



import java.io.IOException;

/**
 *
 * @author elvis
 */
public class Main {

	private static final int POW10[] = {1, 10, 100, 1000, 10000, 100000, 1000000};
	private static final char[][] data = {
				{
					'\0','\0','\0','\0','\0','\0','\0','\0'
				},
				{
					'\0','\0','\0','\0','\0','\0','\0','\0'
				},
				{
					'\0','\0','\0','\0','\0','\0','\0','\0'
				}
			};
	private static int x,y=0, z = 0;
	private static double a, b, c;
	private static StringBuilder bf = new StringBuilder();

	public static void main(String[] args) throws IOException {

			for(;(x = System.in.read()) != '\n'; ){
				if(x == ' '){
					data[y][z] = '\0';
					y++;z=0;
				}else{
					data[y][z++] = (char)x;
				}
			}

		bf.append("TRIANGULO: ");
		format(bf, a * c / 2.0, 3);
		bf.append("\nCIRCULO: ");
		format(bf, 3.14159 * c * c, 3);
		bf.append("\nTRAPEZIO: ");
		format(bf, ((a + b) * c) / 2.0, 3);
		bf.append("\nQUADRADO: ");
		format(bf, b * b, 3);
		bf.append("\nRETANGULO: ");
		format(bf, a * b, 3);

		String tos = bf.toString();
		System.out.println(tos);

	}


	public static boolean isdigit (int c)
	{
					return((c>='0') && (c<='9'));
	}

	public static double atof(char[] s)
	{

		double a = 0.0;
		int e = 0;
		int c = 0, xi=0;
		while ((c = s[xi++]) != '\0' && isdigit(c)) {
			a = a*10.0 + (c - '0');
		}
		if (c == '.') {

			while ((c = s[xi++]) != '\0' && isdigit(c)) {
				a = a*10.0 + (c - '0');
				e = e-1;
			}
		}
		if (c == 'e' || c == 'E') {
			int sign = 1;
			int i = 0;
			c = s[xi++];
			if (c == '+')
				c = s[xi++];
			else if (c == '-') {
				c = s[xi++];
				sign = -1;
			}
			while (isdigit(c)) {
				i = i*10 + (c - '0');
				c = s[xi++];
			}
			e += i*sign;
		}
		while (e > 0) {
			a *= 10.0;
			e--;
		}
		while (e < 0) {
			a *= 0.1;
			e++;
		}
		return a;
	}

	public static void format(StringBuilder sb, double val, int precision) {
		 if (val < 0) {
				 sb.append('-');
				 val = -val;
		 }
		 int exp = POW10[precision];
		 long lval = (long)(val * exp + 0.5);
		 sb.append(lval / exp).append('.');
		 long fval = lval % exp;
		 for (int p = precision - 1; p > 0 && fval < POW10[p]; p--) {
				 sb.append('0');
		 }
		 sb.append(fval);

 }
}
