package com.c_d_o.proyecto_cdo.Repositories;

import com.c_d_o.proyecto_cdo.Entities.Blouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlouseRepository extends JpaRepository<Blouse, Long> {

}
