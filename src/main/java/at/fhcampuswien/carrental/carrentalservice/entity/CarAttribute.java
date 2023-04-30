package at.fhcampuswien.carrental.carrentalservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carlist_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private int id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "cylinder")
    private String cylinder;
}
