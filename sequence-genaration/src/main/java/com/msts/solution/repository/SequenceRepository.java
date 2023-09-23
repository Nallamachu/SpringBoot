package com.msts.solution.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.msts.solution.document.Sequence;

@Repository
public interface SequenceRepository extends MongoRepository<Sequence, String> {
	
	@Query(value = "{'orderType' : ?0, 'channelType':?1}")
	Sequence findSequenceByOrderAndChannelTypes(String orderType, String channelType);
	
}
