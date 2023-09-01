package com.example.demoJPA.controller;
import com.example.demoJPA.dto.CarDTO;
import com.example.demoJPA.dto.DarkModeDTO;
import com.example.demoJPA.model.Car;
import com.example.demoJPA.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CookieValue;
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<Object> getCars(@CookieValue(value = "darkmode", defaultValue = "false") boolean darkMode) {
        List<Car> cars = carService.getAllCars();
        CarDTO[] carDTOs = cars.stream()
                .map(car -> {
                    CarDTO dto = new CarDTO();
                    dto.setName(car.getName());
                    dto.setModel(car.getModel());
                    return dto;
                })
                .toArray(CarDTO[]::new);

        DarkModeDTO darkModeDTO = new DarkModeDTO();
        darkModeDTO.setDarkMode(darkMode);

        Map<String, Object> response = new HashMap<>();
        response.put("darkMode", darkModeDTO);
        response.put("cars", carDTOs);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<Void> setDarkMode(@RequestBody DarkModeDTO darkModeDTO) {
        boolean darkMode = darkModeDTO.isDarkMode();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Set-Cookie", "darkmode=" + darkMode);

        return ResponseEntity.noContent().headers(responseHeaders).build();
    }
}
