package md.electro.repository;

import md.electro.model.entity.AccountEntity;
import md.electro.model.entity.DeviceAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceAccountRepository extends JpaRepository<DeviceAccountEntity,Long>, JpaSpecificationExecutor<DeviceAccountEntity> {
}
