package dev.ashish.ratingmanagementservice.Controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ashish.ratingmanagementservice.Services.RatingService;
import dev.ashish.ratingmanagementservice.dtos.RatingDto;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RatingController.class})
@ExtendWith(SpringExtension.class)
class RatingControllerDiffblueTest {
    @Autowired
    private RatingController ratingController;

    @MockBean
    private RatingService ratingService;

    /**
     * Method under test: {@link RatingController#getRatingById(Long)}
     */
    @Test
    void testGetRatingById() throws Exception {
        Timestamp CreatedDate = mock(Timestamp.class);
        when(CreatedDate.getTime()).thenReturn(10L);
        Timestamp UpdatedDate = mock(Timestamp.class);
        when(UpdatedDate.getTime()).thenReturn(10L);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(CreatedDate);
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(UpdatedDate);
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        when(ratingService.getRatingById(Mockito.<Long>any())).thenReturn(ratingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/ratings/{id}", 1L);
        MockMvcBuilders.standaloneSetup(ratingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"service_id\":1,\"user_id\":1,\"userRating\":10.0,\"isDeleted\":true,\"comment\":\"Comment\",\"createdId\":1,"
                                        + "\"createdDate\":10,\"updatedDate\":10,\"updatedId\":1}"));
    }

    /**
     * Method under test: {@link RatingController#getAllRatings()}
     */
    @Test
    void testGetAllRatings() throws Exception {
        when(ratingService.getAllRatings()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/ratings/");
        MockMvcBuilders.standaloneSetup(ratingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RatingController#createRating(RatingDto)}
     */
    @Test
    void testCreateRating() throws Exception {
        when(ratingService.getAllRatings()).thenReturn(new ArrayList<>());
        Timestamp CreatedDate = mock(Timestamp.class);
        when(CreatedDate.getTime()).thenReturn(10L);
        Timestamp UpdatedDate = mock(Timestamp.class);
        when(UpdatedDate.getTime()).thenReturn(10L);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(CreatedDate);
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(UpdatedDate);
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        String content = (new ObjectMapper()).writeValueAsString(ratingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/ratings/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(ratingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RatingController#deleteRating(Long)}
     */
    @Test
    void testDeleteRating() throws Exception {
        Timestamp CreatedDate = mock(Timestamp.class);
        when(CreatedDate.getTime()).thenReturn(10L);
        Timestamp UpdatedDate = mock(Timestamp.class);
        when(UpdatedDate.getTime()).thenReturn(10L);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(CreatedDate);
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(UpdatedDate);
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        when(ratingService.deleteRating(Mockito.<Long>any())).thenReturn(ratingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/ratings/{id}", 1L);
        MockMvcBuilders.standaloneSetup(ratingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"service_id\":1,\"user_id\":1,\"userRating\":10.0,\"isDeleted\":true,\"comment\":\"Comment\",\"createdId\":1,"
                                        + "\"createdDate\":10,\"updatedDate\":10,\"updatedId\":1}"));
    }

    /**
     * Method under test: {@link RatingController#updateRating(Long, RatingDto)}
     */
    @Test
    void testUpdateRating() throws Exception {
        Timestamp CreatedDate = mock(Timestamp.class);
        when(CreatedDate.getTime()).thenReturn(10L);
        Timestamp UpdatedDate = mock(Timestamp.class);
        when(UpdatedDate.getTime()).thenReturn(10L);

        RatingDto ratingDto = new RatingDto();
        ratingDto.setComment("Comment");
        ratingDto.setCreatedDate(CreatedDate);
        ratingDto.setCreatedId(1L);
        ratingDto.setIsDeleted(true);
        ratingDto.setService_id(1L);
        ratingDto.setUpdatedDate(UpdatedDate);
        ratingDto.setUpdatedId(1L);
        ratingDto.setUserRating(10.0f);
        ratingDto.setUser_id(1L);
        when(ratingService.updateRatingById(Mockito.<RatingDto>any(), Mockito.<Long>any())).thenReturn(ratingDto);
        Timestamp CreatedDate2 = mock(Timestamp.class);
        when(CreatedDate2.getTime()).thenReturn(10L);
        Timestamp UpdatedDate2 = mock(Timestamp.class);
        when(UpdatedDate2.getTime()).thenReturn(10L);

        RatingDto ratingDto2 = new RatingDto();
        ratingDto2.setComment("Comment");
        ratingDto2.setCreatedDate(CreatedDate2);
        ratingDto2.setCreatedId(1L);
        ratingDto2.setIsDeleted(true);
        ratingDto2.setService_id(1L);
        ratingDto2.setUpdatedDate(UpdatedDate2);
        ratingDto2.setUpdatedId(1L);
        ratingDto2.setUserRating(10.0f);
        ratingDto2.setUser_id(1L);
        String content = (new ObjectMapper()).writeValueAsString(ratingDto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/ratings/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(ratingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"service_id\":1,\"user_id\":1,\"userRating\":10.0,\"isDeleted\":true,\"comment\":\"Comment\",\"createdId\":1,"
                                        + "\"createdDate\":10,\"updatedDate\":10,\"updatedId\":1}"));
    }
}

