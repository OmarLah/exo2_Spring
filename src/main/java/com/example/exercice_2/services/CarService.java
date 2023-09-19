package com.example.exercice_2.services;

import com.example.exercice_2.models.CarDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class CarService {

    private final Map<UUID, CarDTO> cars;

    public CarService() {
        cars =  new HashMap<>();

        CarDTO carA = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand("Renault")
                .model("clio")
                .color("blue")
                .year(2020)
                .build();

        CarDTO carB = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand("Peugeot")
                .model("208")
                .color("black")
                .year(2022)
                .build();

        CarDTO carC = CarDTO.builder()
                .id(UUID.randomUUID())
                .brand("Citroen")
                .model("C4")
                .color("white")
                .year(2018)
                .build();


        cars.put(carA.getId(), carA);
        cars.put(carB.getId(), carB);
        cars.put(carC.getId(), carC);
    }


    public List<CarDTO> getCars() {
        return cars.values().stream().toList();
    }

    public CarDTO getCarById(UUID id) {
        return cars.values().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }


}
