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
class BatteryinventoryServiceTests {

	@MockBean
	private BatteryRepository batteryRepository;

	private final BatteryService batteryService;

	@Test
	void saveTest(){
		given(batteryRepository.save(TestData.battery())).willReturn(TestData.battery());
		Battery battery=batteryService.save(TestData.battery());
		assertTrue(battery.getId()!=0, ResponseMessages.ADDED_SUCCESSFULLY);
	}

	@Test
	void findAllDataTest() {
		given(batteryRepository.findAll()).willReturn(TestData.batteries());
		assertTrue(batteryService.getAll().size()==5);
	}

	@Test
	void getOneTest(){
		given(batteryRepository.findById(1234L)).willReturn(Optional.of(TestData.battery()));
		Battery battery=batteryService.getOne(1234L);
		assertEquals(TestData.battery(),battery);
	}

}
