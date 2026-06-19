package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Service;

public class ServiceManager {

    // Reservation ID -> List of Services

    private Map<String, List<Service>> reservationServices;

    public ServiceManager() {

        reservationServices = new HashMap<>();

    }

    // Attach a service

    public void addService(String reservationId,
                           Service service) {

        reservationServices

                .computeIfAbsent(
                        reservationId,
                        key -> new ArrayList<>())

                .add(service);

        System.out.println(

                service.getServiceName()

                        + " added for Reservation "

                        + reservationId);

    }

    // Display services

    public void displayServices(String reservationId) {

        System.out.println();

        System.out.println(

                "===== ADD-ON SERVICES =====");

        List<Service> services =

                reservationServices.get(reservationId);

        if (services == null || services.isEmpty()) {

            System.out.println("No services selected.");

            return;

        }

        double total = 0;

        for (Service service : services) {

            System.out.println(service);

            total += service.getServiceCost();

        }

        System.out.println();

        System.out.println(

                "Additional Cost : ₹"

                        + total);

    }

}