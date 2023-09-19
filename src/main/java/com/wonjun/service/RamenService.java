package com.wonjun.service;

import com.wonjun.model.entity.Ramen;
import com.wonjun.repository.RamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RamenService {
    @Autowired
    RamenRepository ramenRepository;

    public Ramen getContent(int no) throws DataAccessException {
        Optional<Ramen> oRamen = ramenRepository.findById(no);
        Ramen ramen = null;
        if (oRamen.isPresent()) {
            ramen = oRamen.get();
        }
        return ramen;
    }
}
