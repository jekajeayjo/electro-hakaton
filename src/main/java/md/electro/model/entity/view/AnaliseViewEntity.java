package md.electro.model.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import md.electro.model.entity.ids.AnaliseIds;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sum_analise", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(AnaliseIds.class)
public class AnaliseViewEntity implements Serializable {

    @Id
    @Column(name = "generate")
    private Double generate;

    @Id
    @Column(name = "consume")
    private Double consume;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;


}
