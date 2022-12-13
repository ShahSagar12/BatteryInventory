package com.inventory.facade;

import com.inventory.entity.Battery;
import com.inventory.model.BatteryDto;
import com.inventory.model.BatteryStatisticsDto;
import com.inventory.model.util.BatteryUtils;
import com.inventory.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is a part of the package com.inventory.facade and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-13.
 */
@RequiredArgsConstructor
@Component
public class BatteryFacade {

    private final BatteryService batteryService;

    /**
     * Save multiple battery
     *
     * @param batteries
     * @return List
     */
    public List<BatteryDto> saveMultipleBatteries(List<Battery> batteries) {

        return batteryService.saveMultipleBatteries(batteries).stream().map(BatteryDto::convertToDto).collect(Collectors.toList());
    }

    /**
     * Filter Battery list by postcode range
     *
     * @param from
     * @param to
     * @return BatteryStatisticsDto
     */
    public BatteryStatisticsDto findBatteryListByPostCodeRange(int from, int to) {

        return BatteryStatisticsDto.statistics(
                        BatteryUtils.builder().batteries(batteryService.getAll())
                                .from(from)
                                .to(to)
                                .build()
                                .selectedBattery()
        );
    }
}
