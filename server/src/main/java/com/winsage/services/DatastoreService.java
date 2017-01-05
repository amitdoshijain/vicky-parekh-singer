package com.winsage.services;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
/*
import com.google.cloud.AuthCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.Filter;
import com.winsage.configuration.Configuration;*/

public class DatastoreService 
{
	/*private static final String kind = "catalog";
	
	public static void getStatus() throws DatastoreServiceException
	{
		try
		{
			DatastoreOptions options = DatastoreOptions.builder().projectId(Configuration.getParam("gcp.projectid")).namespace(Configuration.getParam("gcp.datastore.namespace")).authCredentials(AuthCredentials.createForJson(new ByteArrayInputStream(Configuration.getParam("gcp.authdata").getBytes(StandardCharsets.UTF_8)))).build();
			Datastore datastore = options.service();
			
			// Has a process succeeded in the last 25 hours
			
			Query<Entity> query = Query.gqlQueryBuilder(Query.ResultType.ENTITY, "select * from catalog order by started desc").build();
			QueryResults<Entity> results = datastore.run(query);
	
			while (results.hasNext()) 
			{
				Entity result = results.next();
				
				String name = result.key().name();
				DateTime completed = result.getDateTime("completed");
				DateTime started = result.getDateTime("started");
				Boolean status = result.getBoolean("status");
		    }
		}
		catch(Exception e)
		{
			throw new DatastoreServiceException("Status Unavailable", e);
		}
	}*/
}
