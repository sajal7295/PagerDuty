package com.acko.PagerDuty.repository;

import com.acko.PagerDuty.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
