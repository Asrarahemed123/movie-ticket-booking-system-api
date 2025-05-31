package com.example.mtb.service;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;

public interface TheaterService {
    TheaterResponse createTheater(TheaterRequest request, String email);

    TheaterResponse findtheaterById(String id);

    TheaterResponse updateTheaterById(TheaterRequest request, String id);
}
