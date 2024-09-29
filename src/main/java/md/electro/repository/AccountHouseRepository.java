package md.electro.repository;

import md.electro.model.entity.AccountEntity;
import md.electro.model.entity.AccountHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountHouseRepository extends JpaRepository<AccountHouseEntity,Long>, JpaSpecificationExecutor<AccountHouseEntity> {
}
