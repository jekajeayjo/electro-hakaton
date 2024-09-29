package md.electro.service.impl;

import lombok.RequiredArgsConstructor;
import md.electro.model.entity.*;
import md.electro.model.entity.view.AnaliseViewEntity;
import md.electro.repository.*;
import md.electro.repository.view.AnaliseViewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricityService {
    private final CreationElectricityRepository creationElectricityRepository;
    private final HouseConsumptionRepository houseConsumptionRepository;
    private final PriceElectricityRepository priceElectricityRepository;
    private final AccountHouseRepository accountHouseRepository;
    private final AnaliseViewRepository analiseViewRepository;
    private final PromotionRepository promotionRepository;
    private final PromotionAccountRepository promotionAccountRepository;


    public void generateElectricity() {
        CreationElectricityEntity creationElectricityEntity = new CreationElectricityEntity();

        creationElectricityEntity.setRegisteredDate(getLocalDateTime());
        creationElectricityEntity.setFactCount(generateDouble(50));
        creationElectricityEntity.setForecastCount(generateDouble(50));
        creationElectricityRepository.save(creationElectricityEntity);
    }

    public void generateHouseConsumption() {

        List<AccountHouseEntity> accountHouseEntities = accountHouseRepository.findAll();
        accountHouseEntities.forEach(accountHouseEntity -> {
            HouseConsumptionEntity houseConsumptionEntity = new HouseConsumptionEntity();
            houseConsumptionEntity.setPriceElectricityId(priceElectricityRepository.findTopByOrderById().getId());
            houseConsumptionEntity.setHouseId(accountHouseEntity.getHouseId());
            houseConsumptionEntity.setCounter(generateDouble(3));
            houseConsumptionEntity.setRegisteredDate(getLocalDateTime());
            houseConsumptionRepository.save(houseConsumptionEntity);
        });

    }

    public void generatePriceElectricity() {
        PriceElictricityEntity priceElictricityEntity = new PriceElictricityEntity();
        priceElictricityEntity.setBuyAmount(generateDouble(3));
        priceElictricityEntity.setSellAmount(generateDouble(4));
        priceElictricityEntity.setRegisteredDate(getLocalDateTime());
        priceElectricityRepository.save(priceElictricityEntity);
    }

    public void getFreshAnalise() {
        AnaliseViewEntity analiseViewEntity = analiseViewRepository.findTopByOrderByRegisteredDate();
        if (analiseViewEntity.getConsume() > analiseViewEntity.getGenerate()) {
            PromotionEntity promotionEntity = new PromotionEntity();
            promotionEntity.setPromotionName("Fire ball " + LocalDateTime.now());
            promotionEntity.setPromotionCoin(10d);
            promotionEntity.setRegisteredDate(getLocalDateTime());
            promotionEntity.setUntilTime(getLocalDateTime().plusHours(3));
            promotionRepository.save(promotionEntity);

        }
    }

    private Double generateDouble(double limit) {
        double leftLimit = 1L;
        return leftLimit + (Math.random() * (limit - leftLimit));
    }

    private LocalDateTime getLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.truncatedTo(ChronoUnit.MINUTES);
        return localDateTime;
    }
}
