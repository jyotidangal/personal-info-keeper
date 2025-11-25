package com.framework.java.datakeeper.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class FilesStoreUtils {
//    here i need to write logic to extract the file path into the base64 format
//    that is  in bytecode so let write here this logic

//    To get the path of multiple file list

    /**
     * this function takes te list of multipart files
     *  this then iterates the file list and on every iteration
     *   it calls a single file upload and collect path
     *   then finally the list of file path will be returned
     * @param fileList
     * @return
     */
    public List<String> uploadFileList(List<MultipartFile> fileList){
    List<String > filePathList = new ArrayList<>();
    for(MultipartFile file:fileList){
        filePathList.add(uploadFile(file));// function is called here
    }
return filePathList;
}
// to get path of a  single file at a time
public String uploadFile(MultipartFile file){
    try{
        // Set your target folder
        String directoryPath = "D:" + File.separator + "JavaCourse" + File.separator + "springboot" + File.separator + "Peoples_Images";
        File directoryFile = new File(directoryPath);

        // Create folder if it doesn't exist
        if(!directoryFile.exists()){
            boolean created = directoryFile.mkdirs();
            if(!created){
                throw new RuntimeException("Failed to create directory: " + directoryPath);
            }
        }

        // Generate unique file name
        // Clean filename (IMPORTANT)
        String originalName = file.getOriginalFilename();
        String cleanedName = originalName.replaceAll("\\s+", "_");

        // Unique filename
        String fileName = UUID.randomUUID() + "_" + cleanedName;
        String filePath = directoryPath + File.separator + fileName;

        // Save the file
        file.transferTo(new File(filePath));

        // Return the actual file path for mail attatchment
        return filePath;

    } catch(Exception e){
        e.printStackTrace();
        return ""; // return empty if upload failed
    }
}



}



