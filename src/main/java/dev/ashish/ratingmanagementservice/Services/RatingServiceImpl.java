package dev.ashish.ratingmanagementservice.Services;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;
import dev.ashish.ratingmanagementservice.repositories.RatingRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class RatingServiceImpl implements RatingService{

    private RatingRepository ratingRepository;

    public  RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository=ratingRepository;
    }
    @Override
    public RatingDto getRatingById(Long id) throws NotFoundException {
        System.out.println("In rating service");
        Rating rating=ratingRepository.findRatingById(id);

        if(rating!=null) {
            System.out.println("In rating service");

            return convertRatingToRatingDto(rating);
        }else {
            throw new NotFoundException("Rating not found");
        }
//    return "Rating is:";
    }

//    public List<RatingDto> getAllRatings(){
//        List<Rating> ratings=ratingRepository.findAllRating();
//
//        return ratings.stream().map(this::convertRatingToRatingDto).collect(Collectors.toList());
//    }

//    public String getRatingById(@PathVariable("id") Long id){
//        return "Rating is :" + 4;
//    }


    public String createRating(Long userid, Long serviceid){
        return  ("Created rating for userid" +userid+ " and service: "+serviceid);
    }


    public String deleteRating(@PathVariable("id") Long id){
        return "deleted Rating for "+id;
    }

    public  String updateRating(@PathVariable("id") Long id){
        return "Updated Rating" + id;
    }

    private RatingDto convertRatingToRatingDto(Rating rating){
        RatingDto ratingDto=new RatingDto();
        ratingDto.setComment(rating.getComment());
        ratingDto.setCreatedId(ratingDto.getCreatedId());

        ratingDto.setCreatedDate(rating.getCreatedDate());
        ratingDto.setService_id(rating.getService_id());
        ratingDto.setIsDeleted(rating.getIsDeleted());
        ratingDto.setUser_id(rating.getUser_id());
        ratingDto.setRating(rating.getRating());
        ratingDto.setUpdatedDate(rating.getUpdatedDate());
        ratingDto.setUpdatedId(rating.getUpdatedId());

        return  ratingDto;
    }
}
