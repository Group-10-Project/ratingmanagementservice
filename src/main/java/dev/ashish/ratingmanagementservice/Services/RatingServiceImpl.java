package dev.ashish.ratingmanagementservice.Services;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;
import dev.ashish.ratingmanagementservice.repositories.RatingRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    }

    @Override
    public List<RatingDto> getAllRatings(){
        List<Rating> ratingList=ratingRepository.findAll();

        return ratingList.stream().map(this::convertRatingToRatingDto).collect(Collectors.toList());
    }


    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = convertRatingDtoToRating(ratingDto);
        rating.setCreatedDate(Timestamp.valueOf(LocalDateTime.now())) ;
        //rating.setCreatedDate(null);
        ratingRepository.save(rating);

        return convertRatingToRatingDto(rating);
    }



    @Transactional
    public RatingDto deleteRating(@PathVariable("id") Long id){
        Rating rating=ratingRepository.findRatingById(id);

        if(rating!=null){
           ratingRepository.delete(rating);
           return convertRatingToRatingDto(rating);
        }
        return ratingRepository.deleteRatingById(id);
    }

    @Override
    @Transactional
    public  RatingDto updateRatingById(RatingDto ratingDto, Long id) throws NotFoundException {
        Rating rating=ratingRepository.findRatingById(id);
        if(rating!=null){

            rating.setService_id(ratingDto.getService_id());
            rating.setUser_id(ratingDto.getUser_id());
            rating.setUserRating(ratingDto.getUserRating());
            rating.setIsDeleted(ratingDto.getIsDeleted());
            rating.setComment(ratingDto.getComment());

            rating=ratingRepository.save(rating);
            return  convertRatingToRatingDto(rating) ;
        }
        else{
            throw new NotFoundException("Rating with id"+id+"Not found");
        }

    }

    @Override
    @Transactional
    public RatingDto softDeleteRating(RatingDto ratingDto,Long id) throws NotFoundException{
        Rating rating=ratingRepository.findRatingById(id);
        if(rating!=null){
            rating.setIsDeleted(ratingDto.getIsDeleted());
            rating=ratingRepository.save(rating);
            return convertRatingToRatingDto(rating);
        }
        else {
            throw new NotFoundException("Rating with id "+id+"Not found");
        }
    }

    private RatingDto convertRatingToRatingDto(Rating rating){
        RatingDto ratingDto=new RatingDto();
        ratingDto.setComment(rating.getComment());
        ratingDto.setCreatedId(ratingDto.getCreatedId());
        ratingDto.setCreatedDate(rating.getCreatedDate());
        ratingDto.setService_id(rating.getService_id());
        ratingDto.setIsDeleted(rating.getIsDeleted());
        ratingDto.setUser_id(rating.getUser_id());
        ratingDto.setUserRating(rating.getUserRating());
        ratingDto.setUpdatedDate(rating.getUpdatedDate());
        ratingDto.setUpdatedId(rating.getUpdatedId());

        return  ratingDto;
    }

    private Rating convertRatingDtoToRating(RatingDto ratingDto){
        Rating rating=new Rating();

        rating.setIsDeleted(ratingDto.getIsDeleted());
        rating.setUser_id(ratingDto.getUser_id());
        rating.setUserRating(ratingDto.getUserRating());
        rating.setUpdatedDate(ratingDto.getUpdatedDate());
        rating.setUpdatedId(ratingDto.getUpdatedId());
         rating.setComment(ratingDto.getComment());
         rating.setCreatedId(ratingDto.getCreatedId());
         rating.setCreatedDate(ratingDto.getCreatedDate());
         rating.setService_id(ratingDto.getService_id());

        return  rating;
    }
}
