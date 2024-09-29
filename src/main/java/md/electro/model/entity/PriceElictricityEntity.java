package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "price_electricity", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceElictricityEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buy_amount")
    private Double buyAmount;

    @Column(name = "sell_amount")
    private Double sellAmount;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;
}
