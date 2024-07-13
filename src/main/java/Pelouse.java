public class Pelouse {
    // Largeur et hauteur de la pelouse
    private int width;
    private int height;

    // Constructeur de la pelouse
    public Pelouse(int width, int height) {
        // Ajouter 1 à la largeur et à la hauteur pour inclure les limites
        this.width = width + 1;
        this.height = height + 1;
    }

    // Vérifier si les coordonnées sont dans les limites de la pelouse
    public boolean isInBounds(int x, int y) {
        // Les coordonnées sont valides si elles sont supérieures ou égales à 0
        // et strictement inférieures à la largeur et à la hauteur de la pelouse
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}