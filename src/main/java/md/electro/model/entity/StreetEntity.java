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
public class StreetEntity {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "region_id")
    private Long town_id;
}
