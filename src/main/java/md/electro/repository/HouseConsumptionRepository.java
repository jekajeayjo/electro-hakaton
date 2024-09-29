package md.electro.repository;

import md.electro.model.entity.CreationElectricityEntity;
import md.electro.model.entity.HouseConsumptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseConsumptionRepository extends JpaRepository<HouseConsumptionEntity, Long> {

}
