import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TondeuseTest {

    private Pelouse pelouse;

    @Before
    public void setUp() {
        // Initialiser une pelouse de 5x5 pour les tests
        pelouse = new Pelouse(5, 5);
    }

    @Test
    public void testMoveForward() {
        // Créer une tondeuse initialisée à la position (1, 2) orientée au nord avec des instructions "A"
        Tondeuse tondeuse = new Tondeuse(1, 2, "N", "A");
        tondeuse.executeInstructions(pelouse);

        // Vérifier que la tondeuse a bougé à la position correcte
        assertThat(tondeuse.getX(), is(1));
        assertThat(tondeuse.getY(), is(3));  // Note: Moving north increases Y
        assertThat(tondeuse.getOrientation(), is("N"));
    }

    @Test
    public void testRotateLeft() {
        // Créer une tondeuse initialisée à la position (1, 2) orientée au nord avec des instructions "G"
        Tondeuse tondeuse = new Tondeuse(1, 2, "N", "G");
        tondeuse.executeInstructions(pelouse);

        // Vérifier que la tondeuse a tourné à gauche (ouest)
        assertThat(tondeuse.getX(), is(1));
        assertThat(tondeuse.getY(), is(2));
        assertThat(tondeuse.getOrientation(), is("W"));
    }

    @Test
    public void testRotateRight() {
        // Créer une tondeuse initialisée à la position (1, 2) orientée au nord avec des instructions "D"
        Tondeuse tondeuse = new Tondeuse(1, 2, "N", "D");
        tondeuse.executeInstructions(pelouse);

        // Vérifier que la tondeuse a tourné à droite (est)
        assertThat(tondeuse.getX(), is(1));
        assertThat(tondeuse.getY(), is(2));
        assertThat(tondeuse.getOrientation(), is("E"));
    }

    @Test
    public void testMultipleInstructions() {
        // Créer une tondeuse initialisée à la position (1, 2) orientée au nord avec des instructions "GAGAGAGAA"
        Tondeuse tondeuse = new Tondeuse(1, 2, "N", "GAGAGAGAA");
        tondeuse.executeInstructions(pelouse);

        // Vérifier la position finale et l'orientation de la tondeuse
        assertThat(tondeuse.getX(), is(1));
        assertThat(tondeuse.getY(), is(3));
        assertThat(tondeuse.getOrientation(), is("N"));
    }

    @Test
    public void testOutOfBoundsMove() {
        // Créer une tondeuse initialisée à la position (0, 0) orientée au sud avec des instructions "A"
        Tondeuse tondeuse = new Tondeuse(0, 0, "S", "A");
        tondeuse.executeInstructions(pelouse);

        // Vérifier que la tondeuse n'a pas bougé car elle essaie de sortir de la pelouse
        assertThat(tondeuse.getX(), is(0));
        assertThat(tondeuse.getY(), is(0));
        assertThat(tondeuse.getOrientation(), is("S"));
    }
}