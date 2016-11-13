package iniciante.P1158;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by elvis on 12/11/16.
 */
public class MainTest {

	@Test
	public void main1() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1158/1.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("21\n24\n", new String(out.toByteArray()));

	}

	@Test
	public void main2() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1158/2.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("45\n40\n", new String(out.toByteArray()));

	}

	@Test
	public void main3() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(this.getClass().getResourceAsStream("/1158/3.in"));
		System.setOut(new PrintStream(out));
		getInstance().main(new String[]{});
		Assert.assertEquals("-3\n-20\n", new String(out.toByteArray()));


	}

	private Main getInstance() {
		return new Main();
	}


}