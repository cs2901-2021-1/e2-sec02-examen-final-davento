package cs.lab;
import java.util.logging.Logger;

class User{

    String username;
    String password;
    static final Logger logger = Logger.getLogger(User.class.getName());

    public void update(Center centro) {
        var response = "Se actualizó la siguiente información para el centro " + centro.getName() + "!\n > ";
        centro.printInfo();
        logger.info(response);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}