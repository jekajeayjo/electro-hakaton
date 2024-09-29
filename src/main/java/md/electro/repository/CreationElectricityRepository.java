package md.electro.repository;

import md.electro.model.entity.CreationElectricityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationElectricityRepository extends JpaRepository<CreationElectricityEntity, Long> {

}
