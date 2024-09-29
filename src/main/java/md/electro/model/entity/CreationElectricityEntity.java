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
@Table(name = "creation_electricity", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreationElectricityEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count_forecast")
    private Double forecastCount;

    @Column(name = "fact_count")
    private Double factCount;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;
}
