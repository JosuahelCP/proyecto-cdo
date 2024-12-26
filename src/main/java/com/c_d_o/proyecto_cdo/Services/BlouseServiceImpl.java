package com.c_d_o.proyecto_cdo.Services;

import com.c_d_o.proyecto_cdo.Dto.BlouseDTO;
import com.c_d_o.proyecto_cdo.Entities.Blouse;
import com.c_d_o.proyecto_cdo.Repositories.IBlouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlouseServiceImpl implements IBlouseService{
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Autowired
    private IBlouseRepository blouseRepository;
    @Override
    public Blouse saveBlouse(BlouseDTO blouseDTO, MultipartFile[] files) throws IOException {
        List<String> uploadedFiles = new ArrayList<>();

        File directory = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }
        for (MultipartFile file: files){
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            Files.write(filePath, file.getBytes());
            uploadedFiles.add(filePath.toString());
        }

        Blouse blouse = Blouse.builder()
                .name(blouseDTO.getName())
                .price(blouseDTO.getPrice())
                .size(blouseDTO.getSize())
                .embroideryType(blouseDTO.getEmbroideryType())
                .fabricType(blouseDTO.getFabricType())
                .images(uploadedFiles)
                .build();

        return blouseRepository.save(blouse);
    }

    @Override
    public List<Blouse> getAllBlouses() {
        return blouseRepository.findAll();
    }

    @Override
    public Blouse getBlouse(Long id) {
        return blouseRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteBlouse(Long id) throws IOException {
        Optional<Blouse> blouseOptional = blouseRepository.findById(id);
        if (blouseOptional.isPresent()) {
            for (String file : blouseOptional.get().getImages()) {
                Files.delete(Paths.get(file));
            }
            blouseRepository.deleteById(id);
        }
    }
}
