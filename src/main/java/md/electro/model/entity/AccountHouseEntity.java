package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import md.electro.model.enums.AccountStatusEnum;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "account_house", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountHouseEntity {


    public AccountHouseEntity(Long accountId) {
        this.accountId = accountId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "nlc")
    private String nlc;

}
