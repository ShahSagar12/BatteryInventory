package com.inventory.common;

import com.inventory.entity.Battery;

import java.util.Arrays;
import java.util.List;

/**
 * This class is a part of the package com.inventory.common and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-09.
 */
public class TestData {

    /**
     * Test Data Single  Battery
     * @return
     */
    public static Battery battery() {

        return new Battery("Battery1","12347",1234);
    }

    /**
     * Test Data List of Battery
     *
     * @return
     */
    public static List<Battery> batteries() {

        return Arrays.asList(
                new Battery("Battery1","12347",1234),
                new Battery("Battery2","12345",1200),
                new Battery("Battery3","12342",1998),
                new Battery("Battery4","72347",129),
                new Battery("Battery5","92347",1100)
        );
    }
}
