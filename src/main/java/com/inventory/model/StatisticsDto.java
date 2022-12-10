package com.inventory.model;

import com.inventory.entity.Battery;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

    /**
     * Total number of Battery
     */
    private  long totalBattery;
    /**
     * Average capacity of Battery
     */
    private double averageCapacity;
    /**
     * Minimum capacity of Battery
     */
    private long minCapacity;
    /**
     * Maximum capacity of Battery
     */
    private long maxCapacity;

    /**
     * Statistics computation
     *
     * @param batteries
     * @return StatisticsDto
     */
    public static StatisticsDto statistics(List<Battery> batteries){

        return  StatisticsDto.builder()
                .totalBattery(batteries.stream().count())
                .minCapacity(batteries.stream().mapToLong(Battery::getCapacity).min().getAsLong())
                .maxCapacity(batteries.stream().mapToLong(Battery::getCapacity).max().getAsLong())
                .averageCapacity(batteries.stream().mapToLong(Battery::getCapacity).average().getAsDouble())
                .build();
    }
}
