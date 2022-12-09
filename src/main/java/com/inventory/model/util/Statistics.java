package com.inventory.model.util;

import lombok.Data;

/**
 * This class is a part of the package com.inventory.model and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-09.
 */
@Data
public class Statistics {
    private String name;
    private  long totalBattery;
    private double averageCapacity;
    private long minCapacity;
    private long maxCapacity;
}
