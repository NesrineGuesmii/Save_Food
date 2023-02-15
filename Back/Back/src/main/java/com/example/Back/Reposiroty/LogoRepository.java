package com.example.Back.Reposiroty;

import com.example.Back.Entities.Logo;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogoRepository extends JpaRepository<Logo, String> {
    Logo findLogoById(String id);
}
