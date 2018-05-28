package es.alfa.centauri.springSecurity.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeSeriesRepository extends MongoRepository<Datapoint, String> {
	public Datapoint findByName(String name);

	public void deleteByName(String name);
}
