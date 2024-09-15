package com.example.umpostgresqleummongodb.domainjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositoryJpa extends JpaRepository<AlunoJpa, Long> {
}
