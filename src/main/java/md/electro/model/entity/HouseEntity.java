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
@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HouseEntity {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "house_id")
    private String houseId;

    @Column(name = "account_number")
    private String account_number;
}
