package com.c_d_o.proyecto_cdo.Controllers.Auth;

import com.c_d_o.proyecto_cdo.Dto.BlouseDTO;
import com.c_d_o.proyecto_cdo.Services.IBlouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/blouse")
public class BlouseController {
    @Autowired
    private IBlouseService blouseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(blouseService.getAllBlouses());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBlouse(@RequestPart("blouse")BlouseDTO blouseDTO,
                                        @RequestPart("images")MultipartFile[] files) throws IOException {
        return ResponseEntity.ok(blouseService.saveBlouse(blouseDTO, files));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlouse(@PathVariable Long id) throws IOException {
        blouseService.deleteBlouse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se ha elminado correctamente el registro");
    }
}
