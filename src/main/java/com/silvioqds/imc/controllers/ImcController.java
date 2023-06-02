package com.silvioqds.imc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.silvioqds.models.Person;

@RestController
@RequestMapping("/imc")
public class ImcController {
    @Autowired(required = false)

    @PostMapping("/calculate")
    public Person calculateImc(@RequestBody Person person) {
        var imc = person.getWeight() / Math.pow(person.getHeight(), 2);
        person.setImc(imc);
        person.setDescription(GetDescription(imc));
        return person;
    }

    public String GetDescription(double imc) {
        var description = "Obesidade";
        if (imc < 18.5)
            description = "Magreza";
        else if (imc < 24.9)
            description = "Normal";
        else if (imc < 30)
            description = "Sobrepeso";

        return description;
    }
}
