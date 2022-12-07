package com.inventory.service;

import com.inventory.common.DefaultConfiguation;
import com.inventory.common.StringLiterals;
import com.inventory.entity.Battery;
import com.inventory.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    private BatteryRepository batteryRepository;

    /**
     * Store Single Battery on the Database
     *
     * @param battery
     * @return
     */
    public Battery save(Battery battery){

        return batteryRepository.save(battery);
    }

    /**
     * Store the List of Battery in to Database
     *
     * @param batteries
     * @return
     */
    public List<Battery> bulkStore(List<Battery> batteries){

        return batteryRepository.saveAll(batteries);
    }

    /**
     * Get Battery by Reference Id
     * @param id
     * @return
     */
    public Battery getOne(String id){
        return batteryRepository.getReferenceById(id);
    }

    /**
     * List Of All Batteries for Statistics Data
     *
     * @return
     */
    public List<Battery> getAll(){

        return batteryRepository.findAll();
    }

    /**
     * List Of Battery with pagination property included
     *
     * @param size
     * @param pageNumber
     * @param sortProperty
     * @return
     */
     public List<Battery> findAll(Optional<Integer> size,Optional<Integer> pageNumber,Optional<String> sortProperty){

        return batteryRepository.findAll(
                Pageable.ofSize(size.orElse(DefaultConfiguation.DEFAULT_PAGE_SIZE))
                        .withPage(pageNumber.orElse(DefaultConfiguation.DEFAULT_PAGE_NUMBER))
                        .getSortOr(Sort.unsorted())
        );


    }
}
