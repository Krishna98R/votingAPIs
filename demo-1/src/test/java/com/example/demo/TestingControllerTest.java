package com.example.demo;

import static org.assertj.core.api.Assertions.assertThatObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.el.util.ReflectionUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.demo.controller.Testing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestingControllerTest {

	Testing testing = new Testing();

	
	@ParameterizedTest
	@ValueSource(strings  = {"Ravi",""})
	public void enterCandidateDetailsTest(String name) {
		
		Map<String,Integer> map = new HashMap<>();
		map.put(name, 0);
		map=testing.enterCandidateDetails(name);
		assertThatObject(map);
	}
	
 
	
	@Test
	public void voteCount() {
		String name = "Ravi";
		Map<String,Integer> map1 = new HashMap<>();
	
		Map<String,Integer> map2 = new HashMap<>();
		
		map1.put(name, 1);
		String count1 = null;
		
		ReflectionTestUtils.setField(testing, "map", map1);
		count1 = testing.voteCount(name);
		 assertEquals("Vote count is 2", count1);
		ReflectionTestUtils.setField(testing, "map", map2);
		count1 = testing.voteCount(name);
		 assertEquals("Invalid candidate name", count1);
	}

	
	@Test
	public void countVote() {
		String name = "Ravi";
		String output = "";
		Map<String,Integer> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		map1.put(name, 1);
		Integer count = map1.get(name);
		ReflectionTestUtils.setField(testing, "map", map1);
		 output = testing.countVote(name);
		 assertEquals("Vote count is 1", output);
		ReflectionTestUtils.setField(testing, "map", map2);
		 output = testing.countVote(name);
		 assertEquals("Invalid candidate name", output);
	}
	
	@Test
	public void voteListTest() {
		String name = "Ravi";
		Map<String,Integer> map = new HashMap<>();
		map.put(name, 1);
		map = testing.VoteList();
		assertThatObject(map);
	}
	
	@Test
	public void getWinnerTest()
	{
		Map<String,Integer> map = new HashMap<>();
		map.put("Ravi", 1);
		map.put("Rohit", 5);
		ReflectionTestUtils.setField(testing, "map", map);
		String winner = testing.getWinner();
		assertEquals("Winner is Rohit", winner);
	}
	

}
