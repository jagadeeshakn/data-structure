package com.ds.algorithms.datastructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DataStructureServiceImpl implements DataStructureService {

	@Override
	public List<String> mergeSort(List<String> array) {
		int[] arr = new int[array.size()];
		int i = 0;
		if (!CollectionUtils.isEmpty(array)) {
			for (String a : array) {
				arr[i] = Integer.valueOf(a);
				i++;
			}
		}
		sort(arr, 0, arr.length - 1);
		List<String> sortArray = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			sortArray.add(String.valueOf(arr[j]));
		}
		return sortArray;
	}

	public void sort(int arr[], int left, int right) {
		if (left < right) {

			// Find the middle point
			int mid = left + (right - left) / 2;

			// Sort first halves
			sort(arr, left, mid);

			// Sort second halves
			sort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}

	public void merge(int arr[], int left, int mid, int right) {
		// Find sizes of two subarrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// Create temp arrays
		int LEFT[] = new int[n1];
		int RIGHT[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			LEFT[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			RIGHT[j] = arr[mid + 1 + j];

		// Merge the temp arrays

		// Initial indices of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = left;
		while (i < n1 && j < n2) {
			if (LEFT[i] <= RIGHT[j]) {
				arr[k] = LEFT[i];
				i++;
			} else {
				arr[k] = RIGHT[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = LEFT[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = RIGHT[j];
			j++;
			k++;
		}
	}
}
