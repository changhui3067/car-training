package com.car.training.dao;

import com.car.training.bean.Trainer;

import java.util.List;
import java.util.Set;

/**
 * Created by bill on 11/10/16.
 */
public interface TrainerDAO {
    List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo);

    int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);
}
