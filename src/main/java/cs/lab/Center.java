package cs.lab;
import java.util.logging.Logger;

class Center {
    private String name;
    int avance;
    int cobertura;
    int vacunadosP;
    int vacunadosC;
    static final Logger logger = Logger.getLogger(Center.class.getName());

    public Center(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        logger.info(() -> "Nombre del centro: " + name);
        logger.info(() -> "Avance: " + avance);
        logger.info(() -> "Cobertura: " + cobertura);
        logger.info(() -> "Vacunados completos:" + vacunadosC);
        logger.info(() -> "Vacunados parciales: " + vacunadosP);
    }
}