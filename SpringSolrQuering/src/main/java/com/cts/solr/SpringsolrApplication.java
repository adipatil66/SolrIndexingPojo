package com.cts.solr;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringsolrApplication {

	public static void main(String[] args) throws SolrServerException, IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringsolrApplication.class, args);
		
	}
	
}
