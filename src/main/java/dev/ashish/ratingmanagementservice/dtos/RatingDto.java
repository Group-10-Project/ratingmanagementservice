package dev.ashish.ratingmanagementservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RatingDto {
    Long service_id;

    Long user_id;
    Float userRating;
    String Comment;
    Timestamp CreatedDate ;
    Long CreatedId;
    Timestamp UpdatedDate;
    Long UpdatedId;
    Boolean isDeleted;
}
