package com.ds.strangerThings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ds.strangerThings.client.ApiCharacterClient;

@SpringBootTest
class StrangerThingsApplicationTests {

	@MockBean
    private ApiCharacterClient apiCharacterClient;
	
	@Test
	void contextLoads() {
	}

}
