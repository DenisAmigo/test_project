import static org.junit.Assert.assertEquals;

public class Test {
    @org.junit.Test
    public void testIpToLong() throws Exception {
        assertEquals(Long.parseLong("3232235521"), Main.ipToLong("192.168.0.1"));
        assertEquals(Long.parseLong("4294967040"), Main.ipToLong("255.255.255.0"));
        assertEquals(Long.parseLong("2147483649"), Main.ipToLong("128.0.0.1"));
    }

    @org.junit.Test
    public void testLongToIp() throws Exception {
        assertEquals("192.168.0.1", Main.longToIp(Long.parseLong("3232235521")));
        assertEquals("255.255.255.0", Main.longToIp(Long.parseLong("4294967040")));
        assertEquals("128.0.0.1", Main.longToIp(Long.parseLong("2147483649")));
    }

    @org.junit.Test(expected=NumberFormatException.class)
    public void testIncorrectIP() {
        Main.ipToLong("w");
    }
}
