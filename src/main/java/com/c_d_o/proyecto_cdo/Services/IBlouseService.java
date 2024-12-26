package com.c_d_o.proyecto_cdo.Services;

import com.c_d_o.proyecto_cdo.Dto.BlouseDTO;
import com.c_d_o.proyecto_cdo.Entities.Blouse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface IBlouseService {

    public Blouse saveBlouse(BlouseDTO blouse, MultipartFile[] files) throws IOException;
    public List<Blouse> getAllBlouses();
    public Blouse getBlouse(Long id);
    public void deleteBlouse(Long id) throws IOException;
}
