package com.wonjun.repository;

import com.wonjun.model.entity.Ramen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamenRepository extends JpaRepository<Ramen, Integer> {

}
