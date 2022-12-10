package com.inventory.controller;

import com.inventory.common.ResponseMessages;
import com.inventory.entity.Battery;
import com.inventory.model.ResponseDto;
import com.inventory.model.StatisticsDto;
import com.inventory.service.BatteryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
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
    @Operation(summary = "Save a battery")
    @PostMapping
    public ResponseEntity<ResponseDto<?>> save(@ParameterObject @RequestBody Battery battery){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.save(battery))
                        .build()
        );
    }
    @Operation(summary = "Get list of battery with pagination")
    @GetMapping("/all")
    public ResponseEntity<ResponseDto<?>> findAll(@Parameter @RequestParam("size") Optional<Integer> size,@Parameter @RequestParam("page") Optional<Integer> pageNumber){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.findAll(size, pageNumber))
                        .build()
        );
    }

    @Operation(summary = "Get Battery by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Battery",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Battery.class)) }),
            @ApiResponse(responseCode = "400", description = "Object doesn't exist",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<?>> getOne(@PathVariable("id") Long identifier){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.getOne(identifier))
                        .build()
        );
    }

    @Operation(summary = "Update Battery")
    @PutMapping
    public ResponseEntity<ResponseDto<?>> update(@ParameterObject @RequestBody Battery battery){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.updateBattery(battery))
                        .message(ResponseMessages.UPDATED_SUCCESSFULLY)
                        .build()
        );
    }

    @Operation(summary = "Delete Battery with id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<?>> delete(@PathVariable("id") Long identifier){
        batteryService.deleteBattery(identifier);
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .message(ResponseMessages.DELETED_SUCCESSFUL_MESSAGE)
                        .build()
        );
    }

    @Operation(summary = "Bulkstore Batteries")
    @PostMapping("/all")
    public ResponseEntity<ResponseDto<?>> bulkStore(@ParameterObject @RequestBody List<Battery> batteries){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.bulkStore(batteries))
                        .message(ResponseMessages.ADDED_SUCCESSFULLY)
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
                            .result(StatisticsDto.statistics(batteryService.getAll()))
                            .build()
        );
    }
}
