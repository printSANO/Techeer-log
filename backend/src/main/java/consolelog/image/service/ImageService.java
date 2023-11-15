package consolelog.image.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface ImageService {
    String upload(Long memberId, File file);
}
