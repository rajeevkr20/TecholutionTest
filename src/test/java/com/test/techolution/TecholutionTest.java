package com.test.techolution;


import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( classes = ApplicationContext.class )
public class TecholutionTest {

	private Logger log = Logger.getLogger(TecholutionTest.class);
	
	final String BASE_URL = "http://localhost:8080/";

  
  
    
     @Test
     public void testFindSatisfaction() throws Exception {
        
    	 String url = BASE_URL+"/techolution/findSatisfaction/1000/2";
    	 RestTemplate restTemplate = new RestTemplate();
		 String str = (String) restTemplate.getForObject(url, String.class);
  
		// System.out.println(str);
		 assertEquals("197191", str);    
         
     }
     
     @Test
     public void testFindSatisfaction1() throws Exception {
        
    	 String url = BASE_URL+"/techolution/findSatisfaction/1000/20";
    	 RestTemplate restTemplate = new RestTemplate();
		 String str = (String) restTemplate.getForObject(url, String.class);
  
		// System.out.println(str);
		 assertEquals("You dont have much time to test 20 item.", str);    
         
     }
     
     @Test
     public void testFindSatisfaction2() throws Exception {
        
    	 String url = BASE_URL+"/techolution/findSatisfaction/400/1";
    	 RestTemplate restTemplate = new RestTemplate();
		 String str = (String) restTemplate.getForObject(url, String.class);
  
		 System.out.println(str);
		 assertEquals("99248", str);    
         
     }

}
