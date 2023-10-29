package dev.ashish.ratingmanagementservice;

import dev.ashish.ratingmanagementservice.models.Rating;
import dev.ashish.ratingmanagementservice.repositories.RatingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.time.Instant;
@SpringBootApplication
public class Application{ //implements CommandLineRunner{

//    private final RatingRepository ratingRepository;
//
//    public Application(RatingRepository ratingRepository) {
//        this.ratingRepository = ratingRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Rating rating = new Rating();
//        rating.setRating((float)5);
//        rating.setComment("Nice service");
//        rating.setService_id((long)2);
//        rating.setUser_id((long)2);
//        //rating.setCreatedDate(Instant.);
//        ratingRepository.save(rating);
//    }
}
