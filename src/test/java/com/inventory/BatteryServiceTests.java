package com.inventory;

import com.inventory.common.ResponseMessages;
import com.inventory.common.TestData;
import com.inventory.entity.Battery;
import com.inventory.repository.BatteryRepository;
import com.inventory.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@RequiredArgsConstructor
class BatteryServiceTests {

	@MockBean
	private BatteryRepository batteryRepository;

	private final BatteryService batteryService;

	/**
	 * Test The Save Battery
	 */
	@Test
	void saveTest(){
		given(batteryRepository.save(TestData.battery())).willReturn(TestData.battery());
		Battery battery=batteryService.save(TestData.battery());
		assertTrue(battery.getId()!=0, ResponseMessages.ADDED_SUCCESSFULLY);
	}

	/**
	 * Test FindAllData
	 */
	@Test
	void findAllDataTest() {
		given(batteryRepository.findAll()).willReturn(TestData.batteries());
		assertTrue(batteryService.getAll().size()==5);
	}



}
