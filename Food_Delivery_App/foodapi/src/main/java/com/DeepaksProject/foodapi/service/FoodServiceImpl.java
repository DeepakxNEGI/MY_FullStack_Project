package com.DeepaksProject.foodapi.service;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DeepaksProject.foodapi.entity.FoodEntity;
import com.DeepaksProject.foodapi.io.FoodRequest;
import com.DeepaksProject.foodapi.io.FoodResponse;
import com.DeepaksProject.foodapi.repository.FoodRepository;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public FoodResponse addFood(FoodRequest request, MultipartFile file) {
        FoodEntity newFoodEntity = convertToEntity(request);

        // Save the file locally
        String filePath = saveFileLocally(file);
        newFoodEntity.setImageUrl(filePath); // Save the file path in the database

        // Save the food entity to MongoDB
        newFoodEntity = foodRepository.save(newFoodEntity);
        return convertToResponse(newFoodEntity);
    }

    private String saveFileLocally(MultipartFile file) {
        try {
            // Get the absolute path to the static/uploads directory using the classpath
            String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            // Save the file to the constructed path
            String filePath = uploadDir + File.separator + file.getOriginalFilename();
            File destinationFile = new File(filePath);
            file.transferTo(destinationFile);

            // Return the relative path for the frontend
            return "http://localhost:8080/uploads/" + file.getOriginalFilename();
        } catch (Exception e) {
            throw new RuntimeException("Failed to save file locally", e);
        }
    }

    @Override
    public List<FoodResponse> readFoods() {
        List<FoodEntity> databaseEntries = foodRepository.findAll();
        return databaseEntries.stream().map(object -> convertToResponse(object)).collect(Collectors.toList());
    }

    @Override
    public FoodResponse readFood(String id) {
        FoodEntity existingFood = foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Food not found for the id:"+id));
        return convertToResponse(existingFood);
    }

    @Override
    public void deleteFood(String id) {
        FoodEntity food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        // Extract filename from imageUrl
        String imageUrl = food.getImageUrl(); // e.g. "uploads/image.jpg"
        String filename = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

        // Delete file from storage
        deleteFile(filename);

        // Delete from MongoDB
        foodRepository.deleteById(id);
    }

    private FoodEntity convertToEntity(FoodRequest request) {
        return FoodEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .price(request.getPrice())
                .build();

    }

    private FoodResponse convertToResponse(FoodEntity entity) {
        return FoodResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .build();
    }



    @Override
    public boolean deleteFile(String filename) {
        try {
            String uploadDir = new File("src/main/resources/static/uploads").getAbsolutePath();
            File fileToDelete = new File(uploadDir + File.separator + filename);
            return fileToDelete.exists() && fileToDelete.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
