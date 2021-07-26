package cs.lab;
import java.util.ArrayList;
import java.util.List;

public final class VaccineAlert {

    private static VaccineAlert instance;
    private List<User> users = new ArrayList<>();
    private List<Center> centers = new ArrayList<>();

    private VaccineAlert() {

    }

    public void addCenter(Center center) {
        this.centers.add(center);
    }

    public void removeCenter(String name) {
        this.centers.removeIf(center -> center.getName().equals(name));
    }

    public void subscribe(String username, String pass) {
        User u = new User(username, pass);
        this.users.add(u);
    }

    public void unsubscribe(String username) {
        this.users.removeIf(user -> user.username.equals(username));
    }

    public void notifyUsers(String name) {

        for(Center center:this.centers) {
            if(center.getName().equals(name)) {
                for (User user : this.users) {
                    user.update(center);
                }
            }
        }
    }

    public void setInfo(String name, float avance, float cobertura, int vacunadosP, int vacunadosC) {
        for(Center center:this.centers) {
            if(center.getName().equals(name)) {
                center.avance = avance;
                center.cobertura = cobertura;
                center.vacunadosP = vacunadosP;
                center.vacunadosC = vacunadosC;
            }
        }
        notifyUsers(name);
    }

    public static VaccineAlert getInstance() {
        VaccineAlert result = instance;
        if (result != null) {
            return result;
        }
        synchronized (VaccineAlert.class) {
            if(instance == null) {
                instance = new VaccineAlert();
            }
        }
        return instance;
    }
}