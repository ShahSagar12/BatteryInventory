package com.inventory.model;

import com.inventory.entity.Battery;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class BatteryStatisticsDto {

    /**
     * Total number of Battery
     */
    private  long totalBattery;

    /**
     * Total number of Battery Capacity
     */
    private  long totalBatteryCapacity;
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
     * Sorted Battery within the Range
     */
    private List<BatteryDto> batteries;

    /**
     * Statistics computation
     *
     * @param batteries
     * @return StatisticsDto
     */
    public static BatteryStatisticsDto statistics(List<Battery> batteries){

        return  BatteryStatisticsDto.builder()
                .batteries(batteries.stream().sorted().map(BatteryDto::convertToDto).collect(Collectors.toList()))
                .totalBattery(batteries.size())
                .totalBatteryCapacity(getTotalCapacity(batteries))
                .minCapacity(getMinCapacity(batteries))
                .maxCapacity(getMaxCapacity(batteries))
                .averageCapacity(getAverageCapacity(batteries))
                .build();
    }

    /**
     * Total Battery Capacity
     *
     * @param batteries
     * @return List
     */
    private static long getTotalCapacity(List<Battery> batteries) {

        return batteries.stream().mapToLong(Battery::getCapacity).sum();
    }

    /**
     * Get min Capacity
     *
     * @param batteries
     * @return long
     */
    private static long getMinCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).min().orElse(0L);
    }

    /**
     * Get max Capacity
     *
     * @param batteries
     * @return long
     */
    private static long getMaxCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).max().orElse(0L);
    }

    /**
     * Compute average Capacity
     *
     * @param batteries
     * @return double
     */
    private static double getAverageCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).average().orElse(0.0);
    }
}
