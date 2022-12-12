package com.inventory.controller;

import com.inventory.common.ResponseMessages;
import com.inventory.entity.Battery;
import com.inventory.model.ResponseDto;
import com.inventory.model.BatteryStatisticsDto;
import com.inventory.service.BatteryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @Operation(summary = "Bulkstore Batteries")
    @PostMapping("/all")
    public ResponseEntity<ResponseDto<?>> saveMultipleBatteries(@ParameterObject @RequestBody List<Battery> batteries){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.saveMultipleBatteries(batteries))
                        .message(ResponseMessages.ADDED_SUCCESSFULLY)
                        .build()
        );
    }

    @Operation(summary = "Statistics of Batteries for range of postcodes")
    @GetMapping("/statistics/postcodes")
    public ResponseEntity<ResponseDto<?>> getStatisticsOfPostCodes(@ParameterObject @RequestParam("from") int from,@ParameterObject @RequestParam("to") int to){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .message(ResponseMessages.STATISTICS_DATA)
                        .result(batteryService.getStatisticsForPostCodes(from,to))
                        .build()
        );
    }

    @Operation(summary = "Statistics of Battery like averageCapacity,Max capacity, Min capacity,total capcity")
    @GetMapping("/statistics")
    public ResponseEntity<ResponseDto<?>> getStatistics(){
        return  ResponseEntity.ok(
                    ResponseDto.builder()
                            .status(true)
                            .message(ResponseMessages.STATISTICS_DATA)
                            .result(BatteryStatisticsDto.statistics(batteryService.getAll()))
                            .build()
        );
    }
}
