package com.pma.controller;

import com.pma.model.OccupancyStatus;
import com.pma.model.Property;
import com.pma.model.PropertyDTO;
import com.pma.model.PropertyType;
import com.pma.service.PropertyService;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PropertyManagementControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    private String examplePropertyJson = "{\n" +
            "        \"id\": 4,\n" +
            "        \"name\": \"Naveen's Hell\",\n" +
            "        \"propertyType\": \"BUILDER\",\n" +
            "        \"occupancyStatus\": \"VACANT\",\n" +
            "        \"address\": \"calgary\"\n" +
            "}";

    PropertyDTO mockProperty = PropertyDTO.builder().name("Naveen's Hell")
            .propertyType(PropertyType.BUILDER)
            .occupancyStatus(OccupancyStatus.VACANT)
            .address("calgary").build();


    @WithMockUser(username = "jwtusername", password = "password", roles = "USER")
    @Test
    public void testAdd() throws Exception {//http://localhost:8080/pma/api/v1/property/add
        final String baseUrl = "http://localhost:"+randomServerPort+"/pma/api/v1/property/add";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqd3R1c2VybmFtZSIsImV4cCI6MTgwMDE2MTgwNDgwMzgsImlhdCI6MTYxODA0ODAzOH0.je76qDG5JpHLRNo5WHoOT-C8NSeD0AqeTX1pj_nbWOBkOKHCyIfoYHDb4HoJbgwpwO1iA6bkXcvRETnF3mre-Q");
        HttpEntity<PropertyDTO> request = new HttpEntity<>(mockProperty, headers);
        ResponseEntity<String> result = this.restTemplate/*.withBasicAuth("jwtusername","password")*/
                                        .postForEntity(uri, request, String.class);

        //Verify request succeed
        Assert.assertEquals(401, result.getStatusCodeValue());
    }


}
