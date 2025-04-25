import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ModelTest {

    @Test
    public void testCrearCoche() {
        Model m = new Model();
        Coche c = m.crearCoche("Mercedes", "SBC 1234");
        assertNotNull(c);
        assertEquals("Mercedes", c.modelo);
        assertEquals("SBC 1234", c.matricula);
    }

    @Test
    public void testGetCoche() {
        Model m = new Model();
        Coche c1 = m.crearCoche("Audi", "BOR 1234");
        Coche c2 = m.getCoche("BOR 1234");
        assertNotNull(c2);
        assertEquals(c1, c2);
    }

    @Test
    public void testCambiarVelocidad() {
        Model m = new Model();
        m.crearCoche("Renault", "MAN 1234");
        int nuevaVelocidad = m.cambiarVelocidad("MAN 1234", 250);
        assertEquals(250, nuevaVelocidad);
        assertEquals(250, m.getVelocidad("MAN 1234"));
    }

    @Test
    public void testGetVelocidad() {
        Model m = new Model();
        m.crearCoche("Ford", "MCC 1234");
        m.cambiarVelocidad("MCC 1234", 50);
        assertEquals(50, m.getVelocidad("MCC 1234"));
    }
}
