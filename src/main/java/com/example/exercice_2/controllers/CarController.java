package com.example.exercice_2.controllers;


import com.example.exercice_2.exceptions.RessourcesNotFoundException;
import com.example.exercice_2.models.CarDTO;
import com.example.exercice_2.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("list")
    public String getCars(Model model) {

        List<CarDTO> cars = carService.getCars();

        model.addAttribute("cars", cars);

        return "car/list";
    }

    @GetMapping("details/{carId}")
    public String getCarById(Model model, @PathVariable("carId") UUID id) {

        CarDTO found = carService.getCarById(id);

        if (found != null) {
            model.addAttribute("car", found);
            return "car/details";
        }
        else {
            throw new RessourcesNotFoundException();
        }

    }


}
