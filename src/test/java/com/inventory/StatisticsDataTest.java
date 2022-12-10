package com.inventory;

import com.inventory.common.AbstractWebTestWrapper;
import com.inventory.common.TestData;
import com.inventory.model.util.Response;
import com.inventory.model.util.Statistics;
import com.inventory.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * This class is a part of the package com.inventory and the package
 * is a part of the project BatteryInventory.
 * <p>
 * Connecting Creations Pvt. Ltd. Lalitpur, Nepal.
 * https://c2.my/
 * <p>
 * Created by sagar on 2022-12-09.
 */

@SpringBootTest
@WebAppConfiguration
@RequiredArgsConstructor
public class StatisticsDataTest extends AbstractWebTestWrapper {

    private final WebApplicationContext webApplicationContext;

    @MockBean
    private BatteryService batteryService;

    @Test
    void statisticsDataTest() throws Exception {
        String uri = "/api/v1/battery/statistics";
        given(batteryService.getAll()).willReturn(TestData.batteries());
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                                 .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Response response=super.mapFromJson(content, Response.class);
        Statistics statistics= super.mapFromJson(super.mapToJson( response.getResult()),Statistics.class);
        assertEquals(5,statistics.getTotalBattery());
        assertEquals(1132.2,statistics.getAverageCapacity());
        assertEquals(129,statistics.getMinCapacity());
        assertEquals(1998,statistics.getMaxCapacity());
    }
}
