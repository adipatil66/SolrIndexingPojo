package com.cts.solr.controller;

import java.io.IOException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.solr.customexception.PathVariableMissingException;
import com.cts.solr.customexception.WrongInputFieldsException;
import com.cts.solr.services.Solr_Client;

@RestController
//@RequestMapping("/flower")
public class SolrQueryRestApi {

	@Autowired
	Solr_Client SolrCli; 
	
	public SolrQueryRestApi(Solr_Client solrCli) {
		super();
		SolrCli = solrCli;
	}

	@GetMapping("/flowers")
	@ResponseBody
	public SolrDocumentList QueryAllDocs() throws SolrServerException, IOException  { 
	      SolrClient Solr=SolrCli.CreateClient();
	      
	      //Preparing Solr query 
	      SolrQuery query = new SolrQuery();  
	      query.setQuery("*:*");  
	   
	      //Adding the field to be retrieved 
	      query.addField("*");  
	   
	      //Executing the query 
	      QueryResponse queryResponse = Solr.query(query);  
	   
	      //Storing the results of the query 
	      SolrDocumentList docs = queryResponse.getResults();    
	      System.out.println(docs.size()); 
    
//	      for(int i=0; i<docs.size(); i++) {
//	    	  System.out.println(docs.get(i));
//	      }

	      //Saving the operations 
	      Solr.commit();  
	      
	      return docs;
	   } 
	
	@GetMapping(value ={"/flower","flower/{species}"} )
	@ResponseBody
	public SolrDocumentList QueyBySpecieName(@PathVariable(value="species" ,required = false) String speciesName) throws SolrServerException, IOException  { 
		if (speciesName == null) {
			throw new PathVariableMissingException("Validation Failed","Name of flower cannot be empty");
	    }
		
		SolrClient Solr=SolrCli.CreateClient();
	      
	      //Preparing Solr query 
	      SolrQuery query = new SolrQuery(); 
	      String querystmt= "species:" + speciesName;
	      query.setQuery(querystmt);  
	   
	      //Executing the query 
	      QueryResponse queryResponse = Solr.query(query);  
	   
	      //Storing the results of the query 
	      SolrDocumentList docs = queryResponse.getResults(); 
	      
	      if (docs.size()==0) {
		    	 throw new WrongInputFieldsException("Record Not Found",speciesName);
		     }

	      //Saving the operations 
	      Solr.commit();  
	      
	      return docs;
	   } 
	
	@GetMapping("/flowers/{species}/{petelLength}")
	@ResponseBody
	public SolrDocumentList QueyByPetalLenght(@DefaultValue("0") @PathVariable(value="species",required = true) String speciesName, @PathVariable("petelLength") String PetelLength) throws Exception  { 
	      SolrClient Solr=SolrCli.CreateClient();
	      
	      //Preparing Solr query 
	      SolrQuery query = new SolrQuery(); 
	      String querystmt= "species:" + speciesName +" AND" + " petalLength:" + PetelLength;
	      query.setQuery(querystmt);  
	   
	      //Executing the query 
	      QueryResponse queryResponse = Solr.query(query);  
	   
	      //Storing the results of the query 
	      SolrDocumentList docs = queryResponse.getResults(); 
	      
	     
	      try {
	    	  if (docs.size()==0) {
			    	 throw new WrongInputFieldsException("Record Not Found",speciesName + " Invalid Petel Length" + PetelLength);
			     }
	      }catch (NullPointerException e ) {
	    	  throw new WrongInputFieldsException("Record Not Found",speciesName + " Invalid Petel Length" + PetelLength);
	      }
	      
	      System.out.println(docs.size()); 
	      //Saving the operations 
	      Solr.commit();  
	      
	      return docs;
	   } 
	}

