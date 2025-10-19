package com.example.restapi.controller;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.restapi.model.Comment;
import com.example.restapi.model.Score;
import com.example.restapi.repository.CommentRepository;
import com.example.restapi.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/scores")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/top")
    public List<Score> getTopScores() {

        return scoreRepository.findTop10ByOrderByScoreDesc();
    }

    @PostMapping
    public Score setScore(@RequestBody Score score) {

        Optional<Score> existing = scoreRepository.findById(score.getUserSignature());
        if(existing.isPresent()) {
            Score current = existing.get();
            if(score.getScore() > current.getScore()) {
                current.setScore(score.getScore());//override the existing score
                current.setTimeStamp(LocalDateTime.now());//set new time of score acqusition
                return scoreRepository.save(current);
            }
            return current; //return if new score is not a high score

        }
        score.setTimeStamp(LocalDateTime.now());
        return scoreRepository.save(score);
    }


    @GetMapping("/{userSignature}")
    public Score getScore(@PathVariable("userSignature") String userSignature) {
        return scoreRepository.findById(userSignature).orElse(null);
    }
}

