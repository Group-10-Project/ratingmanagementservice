package dev.ashish.ratingmanagementservice.Services;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;

import java.util.List;

public interface RatingService {

    RatingDto getRatingById(Long id) throws NotFoundException;

    List<RatingDto> getAllRatings();

    RatingDto createRating(RatingDto ratingDto);

    RatingDto deleteRating(Long id);

    RatingDto updateRatingById(RatingDto ratingDto,Long id) throws NotFoundException;

    RatingDto softDeleteRating(RatingDto ratingDto,Long id) throws NotFoundException;

}
