package com.app.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StockApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void mockGetStocksBySymbolTest() throws Exception {
		String param = "CC";
		mockMvc.perform(MockMvcRequestBuilders
				.get("/stocks-management/findStocks")
				.param("stockName", param))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value(param));
	}

	@Test
	public void mockAddStockTest() throws Exception {
		String jsonRequest = "    {\n" +
				"        \"quarter\": 1,\n" +
				"        \"name\": \"MBB\",\n" +
				"        \"logDate\": \"1/17/2011\",\n" +
				"        \"open\": 16.71,\n" +
				"        \"high\": 16.71,\n" +
				"        \"low\": 15.64,\n" +
				"        \"close\": 15.97,\n" +
				"        \"volume\": 242963398,\n" +
				"        \"percentChangePrice\": -4.42849,\n" +
				"        \"nextWeeksOpen\": 16.19,\n" +
				"        \"nextWeeksClose\": 15.79,\n" +
				"        \"percentChangeNextWeeksPrice\": -2.47066,\n" +
				"        \"daysToNextDividend\": 19,\n" +
				"        \"percentReturnNextDividend\": 0.187852\n" +
				"    }";
		mockMvc.perform(
				post("/stocks-management/saveStock").content(jsonRequest)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void mockUploadStocksTest() throws Exception {
		final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("sampleFile.csv");
		final MockMultipartFile sampleFile = new MockMultipartFile("file", "sampleFile.csv", "text/csv", inputStream);

		MockMultipartHttpServletRequestBuilder multipartRequest =
				MockMvcRequestBuilders.multipart("/stocks-management/uploadStocks");

		mockMvc.perform(
				multipartRequest.file(sampleFile))
				.andExpect(status().isOk()).andReturn();
	}
}
