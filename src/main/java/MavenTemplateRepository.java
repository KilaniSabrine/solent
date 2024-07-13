import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MavenTemplateRepository {

    public static void main(String[] args) {
        // Nom du fichier à lire (situé dans les ressources du projet)
        String filename = "data.txt";
        try (InputStream inputStream = MavenTemplateRepository.class.getClassLoader().getResourceAsStream(filename)) {
            // Vérifier si le fichier a été trouvé
            if (inputStream == null) {
                throw new IOException("File not found: " + filename);
            }
// Lire le contenu du fichier et créer une liste de tondeuses
            List<Tondeuse> tondeuses = TondeuseReader.readFile(inputStream);
            // Afficher les positions finales de chaque tondeuse
            for (Tondeuse tondeuse : tondeuses) {
                System.out.println(tondeuse.toString());
            }
        } catch (IOException e) {
            // Afficher un message d'erreur en cas de problème de lecture du fichier
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
