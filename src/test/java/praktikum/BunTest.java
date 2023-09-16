package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;


public class BunTest {
    Bun bun = new Bun("test bun", 666);

    @Test
    public void getNameTest() {
        assertEquals("test bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(666, bun.getPrice(),1e-15);
    }
}