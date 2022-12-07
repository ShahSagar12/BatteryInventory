package com.inventory.controller;

import com.inventory.model.ResponseDto;
import com.inventory.model.StatisticsDto;
import com.inventory.service.BatteryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is a part of the package com.inventory.controller and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-07.
 */
@RestController
@RequestMapping("/api/v1/battery")
@RequiredArgsConstructor
public class BatteryController {
    private final BatteryService batteryService;

    @GetMapping("/statistics")
    public ResponseEntity<ResponseDto<?>> getStatistics(){
        return  ResponseEntity.ok(
                    ResponseDto.builder()
                            .status(true)
                            .result(StatisticsDto.statistics(batteryService.getAll()))
                            .build()
        );
    }
}
