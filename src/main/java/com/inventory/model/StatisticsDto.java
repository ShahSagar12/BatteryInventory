package com.inventory.model;

import com.inventory.entity.Battery;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * This class is a part of the package com.inventory.model and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-06.
 */
@Data
@Builder
public class StatisticsDto {

    private String name;
    private long totalBattery;
    private double averageCapacity;

    private long minCapacity;

    private long maxCapacity;

    private StatisticsDto statistics(List<Battery> batteries){
        minCapacity=batteries.stream().mapToLong(Battery::getCapacity).min().getAsLong();
        minCapacity=batteries.stream().mapToLong(Battery::getCapacity).max().getAsLong();
        totalBattery=batteries.stream().count();
        averageCapacity=batteries.stream().mapToLong(Battery::getCapacity).average().getAsDouble();
        return  this;
    }
}
