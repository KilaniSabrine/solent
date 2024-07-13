import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PelouseTest {

    private Pelouse pelouse;

    @Before
    public void setUp() {
        // Initialiser une pelouse de 5x5 pour les tests
        pelouse = new Pelouse(5, 5);
    }

    @Test
    public void testIsInBounds() {
        // Vérifier que les coordonnées à l'intérieur des limites sont valides
        assertThat(pelouse.isInBounds(0, 0), is(true));
        assertThat(pelouse.isInBounds(2, 2), is(true));
        assertThat(pelouse.isInBounds(5, 5), is(true));
    }

    @Test
    public void testIsOutOfBounds() {
        // Vérifier que les coordonnées en dehors des limites ne sont pas valides
        assertThat(pelouse.isInBounds(-1, 0), is(false));
        assertThat(pelouse.isInBounds(0, -1), is(false));
        assertThat(pelouse.isInBounds(6, 5), is(false));
        assertThat(pelouse.isInBounds(5, 6), is(false));
    }

    @Test
    public void testBoundaryValues() {
        // Vérifier que les coordonnées sur les bords sont valides
        assertThat(pelouse.isInBounds(0, 5), is(true));
        assertThat(pelouse.isInBounds(5, 0), is(true));

        // Vérifier que les coordonnées juste à l'extérieur des bords ne sont pas valides
        assertThat(pelouse.isInBounds(5, 6), is(false));
        assertThat(pelouse.isInBounds(6, 5), is(false));
        assertThat(pelouse.isInBounds(-1, 5), is(false));
        assertThat(pelouse.isInBounds(5, -1), is(false));
    }
}
