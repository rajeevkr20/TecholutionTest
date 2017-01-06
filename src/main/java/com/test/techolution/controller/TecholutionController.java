package com.test.techolution.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.techolution.comperator.SatisfactionComperator;
import com.test.techolution.comperator.TimeTakenComperator;
import com.test.techolution.util.SatisfactionTime;


@RestController
@RequestMapping("/techolution")
public class TecholutionController {

	
	/**
	 * @param request
	 * @param model
	 * @param haveTime
	 * @param noOfiItem
	 * @return maximum satisfaction score
	 * @throws Exception
	 */
	@RequestMapping( value = "/findSatisfaction/{haveTime}/{noOfiItem}")
	public int searchUserUsage( HttpServletRequest request,Model model, @PathVariable Integer haveTime, @PathVariable Integer noOfiItem) throws Exception
	{
		
		
		List<SatisfactionTime> satsfactionTimeList = readInputFile();
		int satisfactionScore = getMaxSatisfaction(satsfactionTimeList, haveTime, noOfiItem );
		Collections.sort(satsfactionTimeList, new TimeTakenComperator());
		System.out.println(satsfactionTimeList);
		
		Collections.sort(satsfactionTimeList, new SatisfactionComperator());
		System.out.println(satsfactionTimeList);
		return satisfactionScore;
	}
	
	/**
	 * @param satsfactionTimeList
	 * @param haveTime
	 * @param noOfiItem
	 * @return maximum satisfaction score
	 */
	private int getMaxSatisfaction(List<SatisfactionTime> satisfactionTimeList, int haveTime, int noOfiItem) {
		
		Collections.sort(satisfactionTimeList, new TimeTakenComperator());

		int satisfactionScore = 0;
		for(int i = 0; (i+noOfiItem)<satisfactionTimeList.size(); i++){
			
			List<SatisfactionTime> listSliceNo = satisfactionTimeList.subList(i, i+noOfiItem);
			int satisfaction = getSatisfaction(listSliceNo, haveTime, noOfiItem );
			
			if(satisfactionScore < satisfaction){
				satisfactionScore = satisfaction;
			}
		
		}
		return satisfactionScore;
	}

	/**
	 * @param satisfactionTimeList
	 * @param haveTime
	 * @param noOfiItem
	 * @return current satisfaction scores
	 */
	private int getSatisfaction(List<SatisfactionTime> satisfactionTimeList, int haveTime, int noOfiItem) {
		
		int score = 0;
		int time = 0;
		for(SatisfactionTime st : satisfactionTimeList){
			score = score+ st.getSatisfactionAmount();
			time = time + st.getTimeTaken();
		}
		if(time > haveTime)
		{
			score = 0;
		}
		return score;
		
	}
	/**
	 * @return
	 */
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
