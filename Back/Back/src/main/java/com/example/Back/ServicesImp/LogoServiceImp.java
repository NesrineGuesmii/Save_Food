package com.example.Back.ServicesImp;

import com.example.Back.Entities.Logo;
import com.example.Back.Reposiroty.LogoRepository;
import com.example.Back.Services.LogoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class LogoServiceImp implements LogoService {

    private final LogoRepository logoRepository;

    @Override
    public Logo getLogo(String id) {
        return logoRepository.findLogoById(id);
    }

    @Override
    public Logo addLogo(MultipartFile logo) throws IOException {
        String fileName = StringUtils.cleanPath(logo.getOriginalFilename());
        String fileType = logo.getContentType();
        byte[] data = logo.getBytes();
        Logo logo1 = new Logo(null, fileName, fileType, data );
        return logoRepository.save(logo1);
    }
}
