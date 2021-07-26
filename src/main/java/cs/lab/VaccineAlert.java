package cs.lab;
import java.util.ArrayList;
import java.util.List;

public final class VaccineAlert {

    private static VaccineAlert instance;
    private String info = "";
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

    public void subscribe(User user) {
        this.users.add(user);
    }

    public void unsubscribe(User user) {
        this.users.remove(user);
    }

    public void notifyUsers() {

        for(Center center:this.centers) {
            for (User user : this.users) {
                user.update(this.info, center);
            }
        }
    }

    public void setInfo(String info) {
        this.info = info;
        notifyUsers();
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