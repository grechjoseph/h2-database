package com.jg.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillionaireRepository extends JpaRepository<Billionaire, Integer> {
}
