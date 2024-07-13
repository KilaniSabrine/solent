import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MavenTemplateRepositoryTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain() throws IOException {
        // Simuler le contenu du fichier data.txt
        String inputData = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n";

        // Créer un fichier temporaire avec les données d'entrée
        File tempFile = File.createTempFile("data", ".txt");
        tempFile.deleteOnExit();
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(inputData.getBytes());
        }

        // Utiliser le chemin absolu du fichier temporaire pour le test
        System.setProperty("filename", tempFile.getAbsolutePath());
        MavenTemplateRepository.main(new String[]{});

        // Vérifier la sortie console
        String output = outContent.toString();
        assertThat(output, containsString("1 3 N"));
        assertThat(output, containsString("5 1 E"));
    }
}
