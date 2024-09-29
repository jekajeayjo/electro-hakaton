package md.electro.controller;

import lombok.AllArgsConstructor;
import md.electro.service.impl.ElectricityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "creation-electricity")
@RequestMapping("api/v1/creation-electricity")
@AllArgsConstructor
@CrossOrigin
public class CreationElectricityController {

    private final ElectricityService electricityService;

}
