package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "vouchers_account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoucherAccountEntity {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voucher_id")
    private Long voucherId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;
}
