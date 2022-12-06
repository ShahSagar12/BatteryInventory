package com.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class is a part of the package com.inventory.model and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-06.
 */
@Entity
@NoArgsConstructor
@Data
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String postcode;
    private String capacity;

    public Battery(String name, String postcode, String capacity) {
        this.name = name;
        this.postcode = postcode;
        this.capacity = capacity;
    }
}
