package dev.ashish.ratingmanagementservice.Services;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;

import java.util.List;

public interface RatingService {

    RatingDto getRatingById(Long id) throws NotFoundException;

   // List<RatingDto> getAllRatings();

}
