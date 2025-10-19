package com.example.restapi.repository;

import com.example.restapi.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ScoreRepository extends JpaRepository<Score,String>{
    List<Score> findTop10ByOrderByScoreDesc();

}
