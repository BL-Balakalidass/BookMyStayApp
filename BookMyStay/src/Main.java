import model.Service;
import service.ServiceManager;

public class Main {

    public static void main(String[] args) {

        ServiceManager serviceManager =
                new ServiceManager();

        serviceManager.addService(

                "R101",

                new Service(
                        "Breakfast",
                        500));

        serviceManager.addService(

                "R101",

                new Service(
                        "Spa",
                        2000));

        serviceManager.addService(

                "R101",

                new Service(
                        "Airport Pickup",
                        1000));

        serviceManager.displayServices(
                "R101");

    }

}