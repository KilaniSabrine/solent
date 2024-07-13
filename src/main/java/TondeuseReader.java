import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TondeuseReader {

    // Lire un fichier et renvoyer une liste de tondeuses
    public static List<Tondeuse> readFile(String filename) throws IOException {
        // Utiliser un BufferedReader pour lire le fichier
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return readFromBufferedReader(br);
        }
    }

    // Lire un flux d'entrée et renvoyer une liste de tondeuses
    public static List<Tondeuse> readFile(InputStream inputStream) throws IOException {
        // Utiliser un BufferedReader pour lire le flux d'entrée
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            return readFromBufferedReader(br);
        }
    }

    // Lire à partir d'un BufferedReader et renvoyer une liste de tondeuses
    private static List<Tondeuse> readFromBufferedReader(BufferedReader br) throws IOException {
        // Créer une liste de tondeuses
        List<Tondeuse> mowers = new ArrayList<>();
        // Lire la première ligne pour obtenir les dimensions de la pelouse
        String line = br.readLine();
        String[] dimensions = line.split(" ");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        Pelouse pelouse = new Pelouse(width, height);
        String instructions;
        // Lire les lignes suivantes pour créer les tondeuses et exécuter leurs instructions
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            String orientation = parts[2];
            line = br.readLine();
            instructions = line;
            Tondeuse mower = new Tondeuse(x, y, orientation, instructions);
            mower.executeInstructions(pelouse);
            mowers.add(mower);
        }
        // Renvoi de la liste de tondeuses
        return mowers;
    }
}