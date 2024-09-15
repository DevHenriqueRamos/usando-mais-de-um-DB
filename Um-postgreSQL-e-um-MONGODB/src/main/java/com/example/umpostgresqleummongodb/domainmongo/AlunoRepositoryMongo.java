package com.example.umpostgresqleummongodb.domainmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepositoryMongo extends MongoRepository<AlunoMongo, String> {
}
