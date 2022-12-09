package com.inventory.controller;

import com.inventory.common.ResponseMessages;
import com.inventory.entity.Battery;
import com.inventory.model.ResponseDto;
import com.inventory.model.StatisticsDto;
import com.inventory.service.BatteryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<ResponseDto<?>> save(@RequestBody Battery battery){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.save(battery))
                        .build()
        );
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<?>> findAll(@RequestParam("size") Optional<Integer> size, @RequestParam("page") Optional<Integer> pageNumber){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.findAll(size, pageNumber))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<?>> getOne(@PathVariable("id") Long identifier){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.getOne(identifier))
                        .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseDto<?>> update(@RequestBody Battery battery){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.updateBattery(battery))
                        .message(ResponseMessages.UPDATED_SUCCESSFULLY)
                        .build()
        );
    }

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


    @PostMapping("/all")
    public ResponseEntity<ResponseDto<?>> bulkStore(@RequestBody List<Battery> batteries){
        return  ResponseEntity.ok(
                ResponseDto.builder()
                        .status(true)
                        .result(batteryService.bulkStore(batteries))
                        .message(ResponseMessages.ADDED_SUCCESSFULLY)
                        .build()
        );
    }

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
