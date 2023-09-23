package com.msts.solution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msts.solution.document.Sequence;
import com.msts.solution.model.SequenceDTO;
import com.msts.solution.repository.SequenceRepository;

@Service
public class SequenceService {

	@Autowired
	private SequenceRepository sequenceRepository;

	public synchronized String generateSequence(SequenceDTO sequenceDTO) throws Exception{
		if (sequenceDTO != null && sequenceDTO.getChannelType() != null && sequenceDTO.getOrderType() != null) {
			Sequence sequence = sequenceRepository.findSequenceByOrderAndChannelTypes(sequenceDTO.getOrderType(),
					sequenceDTO.getChannelType());
			if (sequence != null && sequence.get_id() != null) {
				Number new_Sequence = sequence.getSequence().intValue() + 1;
				sequence.setSequence(new_Sequence);
				sequenceRepository.save(sequence);
				return sequence.getOrderType() + sequence.getChannelType() + new_Sequence;
			} else {
				Sequence sequence_new = new Sequence(null, sequenceDTO.getOrderType(), sequenceDTO.getChannelType(),
						100);
				sequenceRepository.save(sequence_new);
				return sequence_new.getOrderType() + sequence_new.getChannelType() + sequence_new.getSequence();
			}
		}
		return "";
	}
}
