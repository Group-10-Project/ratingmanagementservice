package dev.ashish.ratingmanagementservice.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.ashish.ratingmanagementservice.Exceptions.NotFoundException;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;
import dev.ashish.ratingmanagementservice.models.Rating;
import dev.ashish.ratingmanagementservice.repositories.RatingRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RatingServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RatingServiceImplDiffblueTest {
    @MockBean
    private RatingRepository ratingRepository;

    @Autowired
    private RatingServiceImpl ratingServiceImpl;

    /**
     * Method under test: {@link RatingServiceImpl#getRatingById(Long)}
     */
    @Test
    void testGetRatingById() throws NotFoundException {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);
        when(ratingRepository.findRatingById(Mockito.<Long>any())).thenReturn(rating);
        RatingDto actualRatingById = ratingServiceImpl.getRatingById(1L);
        verify(ratingRepository).findRatingById(Mockito.<Long>any());
        assertEquals("Comment", actualRatingById.getComment());
        assertNull(actualRatingById.getCreatedId());
        assertEquals(10.0f, actualRatingById.getUserRating().floatValue());
        assertEquals(1L, actualRatingById.getService_id().longValue());
        assertEquals(1L, actualRatingById.getUpdatedId().longValue());
        assertEquals(1L, actualRatingById.getUser_id().longValue());
        assertTrue(actualRatingById.getIsDeleted());
    }

    /**
     * Method under test: {@link RatingServiceImpl#getAllRatings()}
     */
    @Test
    void testGetAllRatings() {
        when(ratingRepository.findAll()).thenReturn(new ArrayList<>());
        List<RatingDto> actualAllRatings = ratingServiceImpl.getAllRatings();
        verify(ratingRepository).findAll();
        assertTrue(actualAllRatings.isEmpty());
    }

    /**
     * Method under test: {@link RatingServiceImpl#getAllRatings()}
     */
    @Test
    void testGetAllRatings2() {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);

        ArrayList<Rating> ratingList = new ArrayList<>();
        ratingList.add(rating);
        when(ratingRepository.findAll()).thenReturn(ratingList);
        List<RatingDto> actualAllRatings = ratingServiceImpl.getAllRatings();
        verify(ratingRepository).findAll();
        assertEquals(1, actualAllRatings.size());
    }

    /**
     * Method under test: {@link RatingServiceImpl#getAllRatings()}
     */
    @Test
    void testGetAllRatings3() {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);

        Rating rating2 = new Rating();
        rating2.setComment("42");
        rating2.setCreatedDate(mock(Timestamp.class));
        rating2.setCreatedId(2L);
        rating2.setId(2L);
        rating2.setIsDeleted(false);
        rating2.setService_id(2L);
        rating2.setUpdatedDate(mock(Timestamp.class));
        rating2.setUpdatedId(2L);
        rating2.setUserRating(0.5f);
        rating2.setUser_id(2L);

        ArrayList<Rating> ratingList = new ArrayList<>();
        ratingList.add(rating2);
        ratingList.add(rating);
        when(ratingRepository.findAll()).thenReturn(ratingList);
        List<RatingDto> actualAllRatings = ratingServiceImpl.getAllRatings();
        verify(ratingRepository).findAll();
        assertEquals(2, actualAllRatings.size());
    }

    /**
     * Method under test: {@link RatingServiceImpl#createRating(RatingDto)}
     */
    @Test
    void testCreateRating() {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);
        when(ratingRepository.save(Mockito.<Rating>any())).thenReturn(rating);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(mock(Timestamp.class));
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(mock(Timestamp.class));
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        RatingDto actualCreateRatingResult = ratingServiceImpl.createRating(ratingDto);
        verify(ratingRepository).save(Mockito.<Rating>any());
        assertEquals("Comment", actualCreateRatingResult.getComment());
        assertNull(actualCreateRatingResult.getCreatedId());
        assertEquals(10.0f, actualCreateRatingResult.getUserRating().floatValue());
        assertEquals(1L, actualCreateRatingResult.getService_id().longValue());
        assertEquals(1L, actualCreateRatingResult.getUpdatedId().longValue());
        assertEquals(1L, actualCreateRatingResult.getUser_id().longValue());
        assertTrue(actualCreateRatingResult.getIsDeleted());
    }

    /**
     * Method under test: {@link RatingServiceImpl#deleteRating(Long)}
     */
    @Test
    void testDeleteRating() {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);
        doNothing().when(ratingRepository).delete(Mockito.<Rating>any());
        when(ratingRepository.findRatingById(Mockito.<Long>any())).thenReturn(rating);
        RatingDto actualDeleteRatingResult = ratingServiceImpl.deleteRating(1L);
        verify(ratingRepository).findRatingById(Mockito.<Long>any());
        verify(ratingRepository).delete(Mockito.<Rating>any());
        assertEquals("Comment", actualDeleteRatingResult.getComment());
        assertNull(actualDeleteRatingResult.getCreatedId());
        assertEquals(10.0f, actualDeleteRatingResult.getUserRating().floatValue());
        assertEquals(1L, actualDeleteRatingResult.getService_id().longValue());
        assertEquals(1L, actualDeleteRatingResult.getUpdatedId().longValue());
        assertEquals(1L, actualDeleteRatingResult.getUser_id().longValue());
        assertTrue(actualDeleteRatingResult.getIsDeleted());
    }

    /**
     * Method under test: {@link RatingServiceImpl#updateRatingById(RatingDto, Long)}
     */
    @Test
    void testUpdateRatingById() throws NotFoundException {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);

        Rating rating2 = new Rating();
        rating2.setComment("Comment");
        rating2.setCreatedDate(mock(Timestamp.class));
        rating2.setCreatedId(1L);
        rating2.setId(1L);
        rating2.setIsDeleted(true);
        rating2.setService_id(1L);
        rating2.setUpdatedDate(mock(Timestamp.class));
        rating2.setUpdatedId(1L);
        rating2.setUserRating(10.0f);
        rating2.setUser_id(1L);
        when(ratingRepository.save(Mockito.<Rating>any())).thenReturn(rating2);
        when(ratingRepository.findRatingById(Mockito.<Long>any())).thenReturn(rating);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(mock(Timestamp.class));
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(mock(Timestamp.class));
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        RatingDto actualUpdateRatingByIdResult = ratingServiceImpl.updateRatingById(ratingDto, 1L);
        verify(ratingRepository).findRatingById(Mockito.<Long>any());
        verify(ratingRepository).save(Mockito.<Rating>any());
        assertEquals("Comment", actualUpdateRatingByIdResult.getComment());
        assertNull(actualUpdateRatingByIdResult.getCreatedId());
        assertEquals(10.0f, actualUpdateRatingByIdResult.getUserRating().floatValue());
        assertEquals(1L, actualUpdateRatingByIdResult.getService_id().longValue());
        assertEquals(1L, actualUpdateRatingByIdResult.getUpdatedId().longValue());
        assertEquals(1L, actualUpdateRatingByIdResult.getUser_id().longValue());
        assertTrue(actualUpdateRatingByIdResult.getIsDeleted());
    }

    /**
     * Method under test: {@link RatingServiceImpl#softDeleteRating(RatingDto, Long)}
     */
    @Test
    void testSoftDeleteRating() throws NotFoundException {
        Rating rating = new Rating();
        rating.setComment("Comment");
        rating.setCreatedDate(mock(Timestamp.class));
        rating.setCreatedId(1L);
        rating.setId(1L);
        rating.setIsDeleted(true);
        rating.setService_id(1L);
        rating.setUpdatedDate(mock(Timestamp.class));
        rating.setUpdatedId(1L);
        rating.setUserRating(10.0f);
        rating.setUser_id(1L);

        Rating rating2 = new Rating();
        rating2.setComment("Comment");
        rating2.setCreatedDate(mock(Timestamp.class));
        rating2.setCreatedId(1L);
        rating2.setId(1L);
        rating2.setIsDeleted(true);
        rating2.setService_id(1L);
        rating2.setUpdatedDate(mock(Timestamp.class));
        rating2.setUpdatedId(1L);
        rating2.setUserRating(10.0f);
        rating2.setUser_id(1L);
        when(ratingRepository.save(Mockito.<Rating>any())).thenReturn(rating2);
        when(ratingRepository.findRatingById(Mockito.<Long>any())).thenReturn(rating);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(mock(Timestamp.class));
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(mock(Timestamp.class));
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        RatingDto actualSoftDeleteRatingResult = ratingServiceImpl.softDeleteRating(ratingDto, 1L);
        verify(ratingRepository).findRatingById(Mockito.<Long>any());
        verify(ratingRepository).save(Mockito.<Rating>any());
        assertEquals("Comment", actualSoftDeleteRatingResult.getComment());
        assertNull(actualSoftDeleteRatingResult.getCreatedId());
        assertEquals(10.0f, actualSoftDeleteRatingResult.getUserRating().floatValue());
        assertEquals(1L, actualSoftDeleteRatingResult.getService_id().longValue());
        assertEquals(1L, actualSoftDeleteRatingResult.getUpdatedId().longValue());
        assertEquals(1L, actualSoftDeleteRatingResult.getUser_id().longValue());
        assertTrue(actualSoftDeleteRatingResult.getIsDeleted());
    }
}

