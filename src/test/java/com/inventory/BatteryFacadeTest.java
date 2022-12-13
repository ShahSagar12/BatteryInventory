package com.inventory;

import com.inventory.common.TestData;
import com.inventory.facade.BatteryFacade;
import com.inventory.model.BatteryStatisticsDto;
import com.inventory.model.util.BatteryUtils;
import com.inventory.repository.BatteryRepository;
import com.inventory.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * This class is a part of the package com.inventory and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-13.
 */
@SpringBootTest
@RequiredArgsConstructor
class BatteryFacadeTest {

    private final BatteryFacade batteryFacade;
    @MockBean
    private final BatteryService batteryService;

    @Test
    public void findBatteryListByPostCodeRangeTest(){
        given(batteryService.getAll()).willReturn(TestData.batteries());
        BatteryStatisticsDto statisticsDto =batteryFacade.findBatteryListByPostCodeRange(1,2);
        assertEquals(5,statisticsDto.getTotalBattery());
        assertEquals(15000,statisticsDto.getTotalBatteryCapacity());
        assertEquals(3000,statisticsDto.getAverageCapacity());
        assertEquals(1000,statisticsDto.getMinCapacity());
        assertEquals(5000,statisticsDto.getMaxCapacity());
    }

}
