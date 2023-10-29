package dev.ashish.ratingmanagementservice.repositories;

public interface CustomQueries{
   // String FindRatingById="SELECT rating FROM reviewservice.rating r where r.id=:id";
    String FINDALLRATING="select rating from rating";
}
