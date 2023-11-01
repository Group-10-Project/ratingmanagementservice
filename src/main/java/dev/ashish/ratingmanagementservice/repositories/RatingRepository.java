package dev.ashish.ratingmanagementservice.repositories;

import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;
//import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.random.RandomGenerator;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    Rating findRatingById(Long id);
    List<Rating> findAll();
    RatingDto deleteRatingById(Long id);


}
