package md.electro.repository;

import md.electro.model.entity.VoucherAccountEntity;
import md.electro.model.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VouchersAccountRepository extends JpaRepository<VoucherAccountEntity,Long>, JpaSpecificationExecutor<VoucherAccountEntity> {
}
