package com.ds.algorithms.datastructure.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.algorithms.datastructure.service.DataStructureService;
import com.ds.algorithms.datastructure.service.RobotCleanService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = { "/v1/datastructure" })
public class DataStructureAlgorithamController {

	@Autowired
	DataStructureService dataStructureService;
	
	@Autowired
	RobotCleanService robotCleanService;
	
	@Operation(tags = "Merge sort algorithm implementation")
	@PostMapping(value = { "/mergesort" })
	public List<String> mergeSort(@RequestBody List<String> array) {
		System.out.println("Reading the input values for merge sort" + array);
		List<String> mergeList = this.dataStructureService.mergeSort(array);
		return mergeList;

	}
	
	@Operation(tags = "Robot clean algorithm implementation")
	@PostMapping(value = { "/robot" })
	public List<String> robotClean(@RequestBody List<String> array) {
		System.out.println("Reading the input values for merge sort" + array);
		List<String> mergeList = this.robotCleanService.robotClean(array);
		return mergeList;

	}
}
