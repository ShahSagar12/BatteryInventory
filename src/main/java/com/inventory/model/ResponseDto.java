package com.inventory.model;

import lombok.Builder;
import lombok.Data;

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
public class ResponseDto<T> {
    private String error;
    private String message;
    private boolean status;
    private T result;
}
