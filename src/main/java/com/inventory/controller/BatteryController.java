package com.inventory.controller;

import com.inventory.common.ResponseMessages;
import com.inventory.entity.Battery;
import com.inventory.facade.BatteryFacade;
import com.inventory.model.BatteryDto;
import com.inventory.model.BatteryStatisticsDto;
import com.inventory.model.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private final BatteryFacade batteryFacade;

    @Operation(summary = "Bulkstore Batteries")
    @PostMapping("/all")
    public ResponseEntity<ResponseDto<List<BatteryDto>>> saveMultipleBatteries(@ParameterObject @RequestBody List<Battery> batteries){
        return  ResponseEntity.ok(
                ResponseDto.<List<BatteryDto>>builder()
                        .status(true)
                        .result(batteryFacade.saveMultipleBatteries(batteries))
                        .message(ResponseMessages.ADDED_SUCCESSFULLY)
                        .build()
        );
    }

    @Operation(summary = "Statistics of Batteries for range of postcodes")
    @GetMapping("/statistics/postcodes")
    public ResponseEntity<ResponseDto<BatteryStatisticsDto>> getStatisticsOfPostCodes(@ParameterObject @RequestParam("from") int from, @ParameterObject @RequestParam("to") int to){
        return  ResponseEntity.ok(
                ResponseDto.<BatteryStatisticsDto>builder()
                        .status(true)
                        .message(ResponseMessages.STATISTICS_DATA)
                        .result(batteryFacade.findBatteryListByPostCodeRange(from,to))
                        .build()
        );
    }

}
