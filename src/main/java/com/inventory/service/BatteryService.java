package com.inventory.service;

import com.inventory.common.DefaultConfiguation;
import com.inventory.entity.Battery;
import com.inventory.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * This class is a part of the package com.inventory.service and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-07.
 */
@Service
@RequiredArgsConstructor
public class BatteryService {

    private final BatteryRepository batteryRepository;

    /**
     * Store Single Battery on the Database
     *
     * @param battery
     * @return Battery
     */
    public Battery save(Battery battery) {

        return batteryRepository.save(battery);
    }

    /**
     * Store the List of Battery in to Database
     *
     * @param batteries
     * @return List<Battery>
     */
    public List<Battery> saveMultipleBatteries(List<Battery> batteries) {

        return batteryRepository.saveAll(batteries);
    }

    /**
     * Get Battery by id
     *
     * @param id
     * @return
     */
    public Battery getOne(Long id) {
        return batteryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Object Not Found"));
    }

    /**
     * List Of All Batteries for Statistics Data
     *
     * @return List<Battery></Battery>
     */
    public List<Battery> getAll() {

        return batteryRepository.findAll();
    }

    /**
     * List Of Battery with pagination property included
     *
     * @param size
     * @param pageNumber
     * @return List<Battery>
     */
    public List<Battery> findAll(Optional<Integer> size, Optional<Integer> pageNumber) {

        return batteryRepository.findAll(
                PageRequest.of(
                        pageNumber.orElse(DefaultConfiguation.DEFAULT_PAGE_NUMBER),
                        size.orElse(DefaultConfiguation.DEFAULT_PAGE_SIZE),
                        Sort.unsorted())
        ).getContent();
    }

    /**
     * Update the battery with content of battery
     *
     * @param battery
     * @return Battery
     */
    public Battery updateBattery(@RequestBody Battery battery) {

        return batteryRepository.save(battery);
    }

    /**
     * Delete the existing battery with an identifier
     *
     * @param identifier
     */
    public void deleteBattery(Long identifier) {
        batteryRepository.deleteById(identifier);
    }
}
