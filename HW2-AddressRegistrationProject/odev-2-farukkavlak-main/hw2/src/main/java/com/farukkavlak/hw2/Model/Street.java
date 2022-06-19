package com.farukkavlak.hw2.Model;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "StreetTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Street {
    @Id
    @SequenceGenerator(name = "Street",sequenceName = "street_id_seq")
    @GeneratedValue(generator = "Street")
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Street(String streetName) {
        this.name = streetName;
    }
}
