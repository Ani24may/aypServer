package com.ayp.project.ayp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path fileStorageLocation;


    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored", ex);
        }
    }


    @Override
    public String storeFile(MultipartFile file,String regid) throws IOException {

        if (!(file.getOriginalFilename().endsWith(".png") || file.getOriginalFilename().endsWith(".jpeg") || file.getOriginalFilename().endsWith(".jpg")))
        throw new FileStorageException("Only PNG, JPEG and JPG images are allowed");

        if(file.getOriginalFilename().endsWith(".png"))
        {
            regid=regid+".png";
        }
        if(file.getOriginalFilename().endsWith(".jpg"))
        {
            regid=regid+".jpg";
        }
        if(file.getOriginalFilename().endsWith(".jpeg"))
        {
            regid=regid+".jpeg";
        }

        String newFileName=file.getOriginalFilename().replace(file.getOriginalFilename(),regid);
        File f = new File("C:\\Users\\anij\\Temp"+newFileName);

        f.createNewFile();
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(file.getBytes());
        fout.close();
        BufferedImage image = ImageIO.read(f);
        int height = image.getHeight();
        int width = image.getWidth();
//        if(width>300 || height>300) {
//            if(f.exists())
//                f.delete();
//            throw new FileStorageException("Invalid file dimensions. File dimension should note be more than 300 X 300");
//        }

        if(f.exists())
            f.delete();

//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = newFileName;
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence" + fileName);
            }



//            String newFileName = System.currentTimeMillis() + "_" + fileName;
//            newFileName=regid;
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException(String.format("Could not store file %s !! Please try again!", fileName), ex);
        }

    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }





}