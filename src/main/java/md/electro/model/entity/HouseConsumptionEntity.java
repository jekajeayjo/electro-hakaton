package md.electro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "house_consumption", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HouseConsumptionEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;

    @Column(name = "counter")
    private Double counter;

    @Column(name = "price_electricity_id")
    private Long priceElectricityId;
}
