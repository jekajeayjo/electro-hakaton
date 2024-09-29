package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "promotion", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromotionEntity {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "promotion_name")
    private String promotionName;

    @Column(name = "promotion_coin")
    private Double promotionCoin;

    @Column(name = "until_time")
    private LocalDateTime untilTime;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;


}
