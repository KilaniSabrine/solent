import lombok.Getter;

public class Tondeuse {

    // Getters et setters pour les propriétés de la tondeuse
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private String orientation;
    @Getter
    private String instructions;
    private int currentInstructionIndex;

    // Constructeur de la tondeuse
    public Tondeuse(int x, int y, String orientation, String instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
        this.currentInstructionIndex = 0;
    }

    // Exécuter les instructions de la tondeuse sur la pelouse donnée
    public void executeInstructions(Pelouse pelouse) {
        while (currentInstructionIndex < instructions.length()) {
            char instruction = instructions.charAt(currentInstructionIndex);
            currentInstructionIndex++;
            switch (instruction) {
                case 'A':
                    moveForward(pelouse);
                    break;
                case 'G':
                    rotateLeft();
                    break;
                case 'D':
                    rotateRight();
                    break;
            }
        }
    }

    // Déplacer la tondeuse d'une case dans la direction actuelle
    private void moveForward(Pelouse pelouse) {
        int newX = x;
        int newY = y;
        switch (orientation) {
            case "N":
                newY++;
                break;
            case "E":
                newX++;
                break;
            case "S":
                newY--;
                break;
            case "W":
                newX--;
                break;
        }
        if (pelouse.isInBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    // Tourner la tondeuse de 90 degrés vers la gauche
    protected void rotateLeft() {
        switch (orientation) {
            case "N":
                orientation = "W";
                break;
            case "W":
                orientation = "S";
                break;
            case "S":
                orientation = "E";
                break;
            case "E":
                orientation = "N";
                break;
        }
    }

    // Tourner la tondeuse de 90 degrés vers la droite
    protected void rotateRight() {
        switch (orientation) {
            case "N":
                orientation = "E";
                break;
            case "E":
                orientation = "S";
                break;
            case "S":
                orientation = "W";
                break;
            case "W":
                orientation = "N";
                break;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}