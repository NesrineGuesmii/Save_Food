package com.example.Back.Services;

import com.example.Back.Entities.Logo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface LogoService {
    Logo getLogo(String id);

    Logo addLogo(MultipartFile logo) throws IOException;
}
