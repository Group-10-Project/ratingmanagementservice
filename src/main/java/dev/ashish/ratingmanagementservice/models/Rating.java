package dev.ashish.ratingmanagementservice.models;

import java.sql.Timestamp;

public class Rating extends BaseModel {
    Long service_id;

    Long user_id;
    Float rating;
    String Comment;
    Timestamp CreatedDate ;
    Long CreatedId;
    Timestamp UpdatedDate;
    Long UpdatedId;
    Boolean isDeleted;

}
