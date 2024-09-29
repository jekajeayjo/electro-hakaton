package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "promotion_account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromotionAccountEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "promotion_id")
    private Long promotionId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "status")
    private String status;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;
}
