package dev.ashish.ratingmanagementservice.repositories;

import dev.ashish.ratingmanagementservice.models.Rating;
//import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    //@Query(CustomQueries.FindRatingById)
    //@Query("SELECT rating FROM reviewservice.rating r where r.id=:id")
    Rating findRatingById(Long id);

   // List<Rating> findAllRatings();

}
