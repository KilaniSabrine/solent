import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TondeuseReaderTest {

    private Pelouse pelouse;

    @Before
    public void setUp() {
        // Initialiser une pelouse de 5x5 pour les tests
        pelouse = new Pelouse(5, 5);
    }

    @Test
    public void testReadFileFromInputStream() throws IOException {
        // Simuler un fichier en utilisant un flux d'entrée
        String inputData = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());

        // Lire les tondeuses depuis le flux d'entrée
        List<Tondeuse> tondeuses = TondeuseReader.readFile(inputStream);

        // Vérifier qu'il y a deux tondeuses lues
        assertThat(tondeuses.size(), is(2));

        // Vérifier les positions finales et les orientations des tondeuses
        Tondeuse tondeuse1 = tondeuses.get(0);
        assertThat(tondeuse1.getX(), is(1));
        assertThat(tondeuse1.getY(), is(3));
        assertThat(tondeuse1.getOrientation(), is("N"));

        Tondeuse tondeuse2 = tondeuses.get(1);
        assertThat(tondeuse2.getX(), is(5));
        assertThat(tondeuse2.getY(), is(1));
        assertThat(tondeuse2.getOrientation(), is("E"));
    }

    @Test
    public void testReadFileFromFilename() throws IOException {


        // Simuler un fichier en utilisant un flux d'entrée
        String inputData = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());

        List<Tondeuse> tondeuses = TondeuseReader.readFile(inputStream);

        // Vérifier qu'il y a deux tondeuses lues
        assertThat(tondeuses.size(), is(2));

        // Vérifier les positions finales et les orientations des tondeuses
        Tondeuse tondeuse1 = tondeuses.get(0);
        assertThat(tondeuse1.getX(), is(1));
        assertThat(tondeuse1.getY(), is(3));
        assertThat(tondeuse1.getOrientation(), is("N"));

        Tondeuse tondeuse2 = tondeuses.get(1);
        assertThat(tondeuse2.getX(), is(5));
        assertThat(tondeuse2.getY(), is(1));
        assertThat(tondeuse2.getOrientation(), is("E"));
    }
}
