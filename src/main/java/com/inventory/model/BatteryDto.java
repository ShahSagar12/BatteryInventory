package com.inventory.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.entity.Battery;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.DozerBeanMapper;

/**
 * This class is a part of the package com.inventory.model and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-12.
 */
@Data
@NoArgsConstructor
public class BatteryDto {

    private String name;
    private String postcode;
    private long capacity;

    public static BatteryDto convertToDto(Battery battery){

        return new DozerBeanMapper().map(battery,BatteryDto.class);
    }
}
