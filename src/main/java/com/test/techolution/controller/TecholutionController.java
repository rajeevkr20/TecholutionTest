package com.test.techolution.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.techolution.comperator.SatisfactionComperator;
import com.test.techolution.comperator.TimeTakenComperator;
import com.test.techolution.util.SatisfactionTime;


@RestController
@RequestMapping("/techolution")
public class TecholutionController {

	
	@RequestMapping( value = "/searchUserUsage")
	public List<SatisfactionTime> searchUserUsage( HttpServletRequest request,Model model) throws Exception
	{
		
		List<String> strList= new ArrayList<String>();
		
		strList.add("add");
		List<SatisfactionTime> satsfactionTimeList = readInputFile();
		Collections.sort(satsfactionTimeList, new TimeTakenComperator());
		System.out.println(satsfactionTimeList);
		
		Collections.sort(satsfactionTimeList, new SatisfactionComperator());
		System.out.println(satsfactionTimeList);
		return satsfactionTimeList;
	}
	
	private List<SatisfactionTime> readInputFile(){
		BufferedReader br = null;
		List<SatisfactionTime> satsfactionTimeList = new ArrayList<SatisfactionTime>();
		
		try {
			br = new BufferedReader(new FileReader("data.txt"));
		
		    String line = br.readLine();
		    int i=1;
		    while (line != null) {
		       String [] strLine = line.split(" ");
		       SatisfactionTime st = new SatisfactionTime();
		       st.setSatisfactionAmount(strLine[0] != null ? Integer.parseInt(strLine[0]) : null);
		       st.setTimeTaken(strLine[1] != null ? Integer.parseInt(strLine[1]) : null);
		       st.setIndex(i++);
		       satsfactionTimeList.add(st);
		       System.out.println(st.toString());
		       line = br.readLine();
		    }
		   
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return satsfactionTimeList;
	}
}
