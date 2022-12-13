package com.inventory.model.util;

import com.inventory.entity.Battery;
import lombok.Builder;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class is a part of the package com.inventory.model.util and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-12.
 */

@Builder
public class BatteryUtils {

    /**
     * List Of Batteries
     */
    private List<Battery> batteries;
    /**
     * Lower Bound for the postcode
     */
    private int from;

    /**
     * Upper Bound for the postcode
     */
    private int to;

    /**
     * Create a Set of postcodes from stored in the batteries
     * @return
     */
    private  Set<Integer> postCodes(){

        return batteries.stream()
                .map(Battery::getPostcode)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    /**
     * Create Set Of Intersection between the postcodes present on the batteries and range of elements
     *
     * @return Set
     */
    private Set<String> getRangeOfBattery(){

        return IntStream.rangeClosed(from,to)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .filter(postCodes()::contains)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }

    /**
     * BatteryList whose postcodes lies within the range
     *
     * @return List
     */
    public List<Battery> selectedBattery() {

        return batteries.stream()
                .filter(battery -> getRangeOfBattery().contains(battery.getPostcode()))
                .collect(Collectors.toList());
    }
}
