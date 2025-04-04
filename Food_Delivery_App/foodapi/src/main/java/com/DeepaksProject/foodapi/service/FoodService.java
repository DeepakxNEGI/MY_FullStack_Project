package com.DeepaksProject.foodapi.service;


import org.springframework.web.multipart.MultipartFile;

import com.DeepaksProject.foodapi.io.FoodRequest;
import com.DeepaksProject.foodapi.io.FoodResponse;

import java.util.List;

public interface FoodService {

  //

    FoodResponse addFood(FoodRequest request, MultipartFile file);

    List<FoodResponse> readFoods();

    FoodResponse readFood(String id);

    boolean deleteFile(String filename);

    void deleteFood(String id);
}
