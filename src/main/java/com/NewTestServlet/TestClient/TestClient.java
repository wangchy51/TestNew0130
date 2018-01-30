package com.NewTestServlet.TestClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClient {
	@Test(dataProvider="feeder")
	@Source("./data/add.csv")
	public void doGet(String a, String b, String c) throws Exception {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://192.168.52.131:8080/TestServlet/TestServlet?a=" + a + "&b=" + b);
		CloseableHttpResponse response = client.execute(request);
		String actual = EntityUtils.toString(response.getEntity());
		System.out.println(actual);
		Assert.assertEquals(actual, c);
	}
}
