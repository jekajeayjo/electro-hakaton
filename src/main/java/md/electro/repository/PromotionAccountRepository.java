package md.electro.repository;

import md.electro.model.entity.PromotionAccountEntity;
import md.electro.model.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionAccountRepository extends JpaRepository<PromotionAccountEntity,Long>, JpaSpecificationExecutor<PromotionAccountEntity> {
}
