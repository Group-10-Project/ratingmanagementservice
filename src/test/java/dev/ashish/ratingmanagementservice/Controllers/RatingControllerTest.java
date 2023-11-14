package dev.ashish.ratingmanagementservice.Controllers;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.Services.RatingService;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RatingControllerTest {

    @MockBean
    private RatingService ratingService;

    @Autowired
    private RatingController ratingController;

//    @Test
//    @DisplayName("1+1 equals 2")
//    void testOnePlusOneEqualsTrue(){
////        System.out.println("It is true");
//        assert (11==1+1);
//
//    }

    @Test
    void  testReturnsCorrectRating() throws NotFoundException {
        RatingDto ratingDto= new RatingDto();
        when(
            ratingService.getRatingById(any(Long.class))
        )
        .thenReturn(ratingDto);

        assertEquals(ratingDto.getUser_id(),ratingController.getRatingById(1L).getUser_id());
      //  assertThrows(NotFoundException.class,()->ratingController.getRatingById(1L));
    }

//    @Test
//    void  testGetRatingThrowsNotFoundException() throws NotFoundException{
//    assertThrows(NotFoundException.class,() -> ratingService.getRatingById(100L));
//    }
}