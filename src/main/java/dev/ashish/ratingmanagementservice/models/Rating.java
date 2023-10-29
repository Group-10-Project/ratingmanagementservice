package dev.ashish.ratingmanagementservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends BaseModel {
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
