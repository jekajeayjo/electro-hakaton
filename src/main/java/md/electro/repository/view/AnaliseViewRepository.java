package md.electro.repository.view;

import md.electro.model.entity.ids.AnaliseIds;
import md.electro.model.entity.view.AnaliseViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseViewRepository extends JpaRepository<AnaliseViewEntity, AnaliseIds>, JpaSpecificationExecutor<AnaliseViewEntity> {
    AnaliseViewEntity findTopByOrderByRegisteredDate();
}
