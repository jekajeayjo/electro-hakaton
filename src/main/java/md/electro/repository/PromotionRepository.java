package md.electro.repository;

import md.electro.model.entity.PromotionEntity;
import md.electro.model.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity,Long>, JpaSpecificationExecutor<PromotionEntity> {
}
