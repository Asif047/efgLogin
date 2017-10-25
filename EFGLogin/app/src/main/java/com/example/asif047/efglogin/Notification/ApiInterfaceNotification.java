package com.example.asif047.efglogin.Notification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 10/12/2017.
 */

public interface ApiInterfaceNotification {

    @GET("api/notifications")
    Call<List<Notification>> getNotifications();
}
