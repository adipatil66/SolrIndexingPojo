package com.cts.solr.services;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.solr.readproperties.SolrProperties;

@Component
public class Solr_Client {

	@Autowired
	SolrProperties ep;
	
	
	public SolrClient CreateClient() {
		
		//http://localhost:7574/solr/gettingstarted
		String Url= ep.getProtocol()+ "://"+ ep.getHost()+":" + ep.getPort()+"/solr/"+ep.getCollection();
		SolrClient Solr = new HttpSolrClient.Builder(Url).build();
//		System.out.println(Solr.getClass());
		return Solr;
	}
	
}
