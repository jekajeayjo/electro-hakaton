package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import md.electro.model.enums.AccountStatusEnum;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "device_account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeviceAccountEntity {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "status")
    private String status;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;

}
