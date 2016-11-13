package iniciante.P1159;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by elvis on 13/11/16.
 */
public class MainTest {

	@Test
	public void main1() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1159/1.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("40\n80\n", new String(out.toByteArray()));

	}

	@Test
	public void main2() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1159/2.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("10\n-20\n100\n", new String(out.toByteArray()));

	}


	private Main getInstance() {
		return new Main();
	}

}