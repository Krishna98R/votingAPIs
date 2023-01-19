package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Candidate;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class Testing {
	
	
	
	Map<String,Integer> map = new HashMap<>();
	

	 
	@PostMapping("/enterCandidate")
	public Map<String,Integer> enterCandidateDetails(@RequestParam String name) {
		Candidate cand = new Candidate();
		if(StringUtils.isBlank(name)) {
			log.info("Invalid name");
		} else {
			cand.setName(name);
			cand.setCount(0);
			map.put(name, cand.getCount());
		}
		
		return map;
	}
	
	@PostMapping("/castVote")
	public String voteCount(@RequestParam String name) {
		String count1 = null;
		if(map.containsKey(name)) {
			Integer count = map.get(name);
			
			
			count1 = Integer.toString(count+1);
			map.replace(name, Integer.parseInt(count1));
			count1 = "Vote count is "+Integer.toString(count+1);
		} else {
			log.info("Invalid Candidate name");
			count1 = "Invalid candidate name";
		}
		return count1;
	}
	
	@PostMapping("/countVote")
	public String countVote(@RequestParam String name) {
		String count = null;
		if(map.containsKey(name)) {
			count = "Vote count is "+Integer.toString(map.get(name));
		} else {
			
			log.info("Invalid Candidate name");
			count = "Invalid candidate name";
		}
		return count;
	}
	
	@PostMapping("/listVote")
	public Map<String,Integer> VoteList() {
		
		return map;
	}
	
	@PostMapping("/getWinner")
	public String getWinner() {
		
		String winner=null;
		
		List<Integer> list = new ArrayList<>();
		
		for(String name :map.keySet()) {
			
			Integer count = map.get(name);
			list.add(count);
		}
		
		Integer maxVote = Collections.max(list);
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue().equals(maxVote)) {
				winner = "Winner is "+entry.getKey();
			}
		}
		
		return winner;
	}
	
	
	

}
