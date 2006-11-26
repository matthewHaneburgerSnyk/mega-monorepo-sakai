package org.sakaiproject.portal.render.portlet.services.state.encode;

import junit.framework.TestCase;
import org.sakaiproject.portal.render.portlet.services.state.BasicWebRecoder;

public class BasicWebRecoderTest extends TestCase {

    private BasicWebRecoder encoder;

    public void setUp() {
        encoder = new BasicWebRecoder();
    }

    public void testEncodeDecode() {
        String testString = "abcdefg, :!?+_-^%$\n";

        String uriSafe = encoder.encode(testString.getBytes());
        assertNotNull(uriSafe);
        assertEquals(-1, uriSafe.indexOf(" "));
        assertEquals(-1, uriSafe.indexOf("/"));
        assertEquals(-1, uriSafe.indexOf(":"));
        assertEquals(-1, uriSafe.indexOf("="));
        assertEquals(-1, uriSafe.indexOf("?"));
        assertEquals(-1, uriSafe.indexOf("&"));
        byte[] bits = encoder.decode(uriSafe);

        assertEquals(testString, new String(bits));
    }


}
