package com.msts.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.msts.solution.model.SequenceDTO;
import com.msts.solution.repository.SequenceRepository;
import com.msts.solution.service.SequenceService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SequenceTest {

	@InjectMocks
	private SequenceService sequenceService;
	
	@Mock
	private SequenceRepository sequenceRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getInvoiceRecordByInvoiceNoTest() throws Exception {
		for (int i = 0; i < 10; i++) {
			String orderType = "AB";
			String[] channelTypes = { "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR", "ST", "UN" };
			for (int j = 0; j < 10; j++) {
				String sequence = sequenceService.generateSequence(new SequenceDTO(orderType, channelTypes[j]));
				Assert.notNull(sequence, "Sequence generated successfully " + sequence);
			}
		}

	}

}