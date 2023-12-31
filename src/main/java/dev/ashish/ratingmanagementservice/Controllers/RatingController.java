package dev.ashish.ratingmanagementservice.Controllers;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.Services.RatingService;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings/")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService){
        this.ratingService=ratingService;
    }


    @GetMapping("{id}")
    public RatingDto getRatingById(@PathVariable("id") Long id) throws NotFoundException {
        return ratingService.getRatingById(id) ;
    }

    @GetMapping
    public List<RatingDto> getAllRatings(){

        return ratingService.getAllRatings() ;
    }

    @PostMapping
    public RatingDto createRating(@RequestBody RatingDto ratingDto){
            return ratingService.createRating(ratingDto);
//        return  ("Created rating for userid" +userid+ " and service: "+serviceid);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RatingDto> deleteRating(@PathVariable("id") Long id){
        //return "deleted Rating for "+id;

        return  new ResponseEntity<>(ratingService.deleteRating(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public  RatingDto updateRating(@PathVariable("id") Long id, @RequestBody RatingDto ratingDto) throws NotFoundException {
        return ratingService.updateRatingById(ratingDto,id);
    }

//    @PutMapping("{id}")
//    public  RatingDto softDeleteRating(@PathVariable("id") Long id, @RequestBody RatingDto ratingDto) throws NotFoundException {
//        return ratingService.updateRatingById(ratingDto,id);
//    }
}
