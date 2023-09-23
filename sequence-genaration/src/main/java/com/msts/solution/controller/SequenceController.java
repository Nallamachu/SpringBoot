package com.msts.solution.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msts.solution.model.SequenceDTO;
import com.msts.solution.service.SequenceService;

@RestController
public class SequenceController {

	@Autowired
	private SequenceService sequenceService;

	@GetMapping(value = "/generate-sequence")
	public List<String> generateSequence() throws Exception {
		List<String> sequences = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String orderType = "AB";
			String[] channelTypes = { "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR", "ST", "UN" };
			for (int j = 0; j < 10; j++) {
				String sequence = sequenceService.generateSequence(new SequenceDTO(orderType, channelTypes[j]));
				sequences.add(sequence);
			}
		}
		return sequences;
	}

}
