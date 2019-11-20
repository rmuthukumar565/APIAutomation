package com.aeo.server.main;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import com.aeo.beans.CartInfo;



@RunWith(SpringRunner.class)
@SpringBootTest
class CartTests {

	/*@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
 
    @Test
    public void testAddCart() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:8083/v1/cart/item/";
        URI uri = new URI(baseUrl);
        CartInfo cartInfo = new CartInfo();
        cartInfo.setProductId("12345");
        cartInfo.setQty(5);
        cartInfo.setSkuId("93183128");
        
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");     
 
        HttpEntity<CartInfo> request = new HttpEntity<>(cartInfo, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        System.out.println(result.getBody());
    }*/

}
