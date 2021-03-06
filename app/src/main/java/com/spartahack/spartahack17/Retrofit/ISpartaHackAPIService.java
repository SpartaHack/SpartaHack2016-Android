package com.spartahack.spartahack17.Retrofit;

import com.spartahack.spartahack17.Model.AddInstillationRequest;
import com.spartahack.spartahack17.Model.AddInstillationResponse;
import com.spartahack.spartahack17.Model.Announcement;
import com.spartahack.spartahack17.Model.Category;
import com.spartahack.spartahack17.Model.CheckIn;
import com.spartahack.spartahack17.Model.Company;
import com.spartahack.spartahack17.Model.Event;
import com.spartahack.spartahack17.Model.Login;
import com.spartahack.spartahack17.Model.Prize;
import com.spartahack.spartahack17.Model.Session;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ryancasler on 9/19/16.
 * SpartaHack2016-Android
 */
public interface ISpartaHackAPIService {

    @POST("sessions")
    Observable<Session> login(@Body Login login);

    @DELETE("sessions/{token}")
    Observable<Response<Void>> logout(@Path("token") String token);

    @GET("schedule")
    Observable<ArrayList<Event>> getSchedule();

    @GET("prizes")
    Observable<ArrayList<Prize>> getPrizes();

    @GET("announcements")
    Observable<ArrayList<Announcement>> getAnnouncements();

    @GET("sponsors")
    Observable<ArrayList<Company>> getCompanies();

    @POST("installations")
    Observable<AddInstillationResponse> addInstillation(@Body AddInstillationRequest requestBody);

    @POST("checkin")
    Observable<CheckInResponse> checkInUser(@Header("X-WWW-USER-TOKEN") String userToken, @Body CheckIn checkIn);

    @GET("categories")
    Observable<ArrayList<Category>> getCategories();
}
