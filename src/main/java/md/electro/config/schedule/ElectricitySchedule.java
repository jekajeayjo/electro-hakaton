package md.electro.config.schedule;

import lombok.RequiredArgsConstructor;
import md.electro.service.impl.ElectricityService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ElectricitySchedule {
    private final ElectricityService electricityService;

    @Scheduled(fixedRate = 60 * 15 * 1000)
    public void generateCreationElectricity() {
        System.out.println("Get creation electricity action every 15 minute");
        electricityService.generateElectricity();
    }

    @Scheduled(fixedRate = 60 * 15 * 1000)
    public void generateHouseConsumption() {
        System.out.println("Get houses consumption action every 15 minute");
        electricityService.generateHouseConsumption();
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void generatePriceElectricity() {
        System.out.println("Get houses consumption action every 60 minute");
        electricityService.generatePriceElectricity();
    }

    @Scheduled(fixedRate = 60 * 180 * 1000 )
    public void getFreshAnalise() {
        System.out.println("Get analises every 180 minutes");
        electricityService.getFreshAnalise();
    }
}
