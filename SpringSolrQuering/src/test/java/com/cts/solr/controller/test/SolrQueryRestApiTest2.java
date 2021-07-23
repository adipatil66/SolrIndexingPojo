package com.cts.solr.controller.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.http.client.methods.RequestBuilder;
import org.apache.solr.common.SolrDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.solr.controller.SolrQueryRestApi;
import com.cts.solr.services.Solr_Client;
 
@WebMvcTest(SolrQueryRestApi.class)
class SolrQueryRestApiTest2 {

	@Autowired
	private MockMvc mvc;
	

	
	@Test
	void testQueryAllDocs() throws Exception {
		mockMvc.perform(get("/flowers"))
        .andExpect(status().isOk());
	}

//	@Test
//	void testQueyBySpecieName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testQueyByPetalLenght() {
//		fail("Not yet implemented");
//	}

}
