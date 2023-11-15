package consolelog.image.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AmazonS3Service implements ImageService {

    private static Long fileId = 1L;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3Client amazonS3Client;

    public AmazonS3Service(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public static void incrementFileId() {
        fileId++;
    }
    @Override
    public String upload(Long memberId, File file) {
        String fileName = String.join("/", memberId.toString(), fileId.toString());
        incrementFileId();

        return putImage(fileName, file);
    }

    private String putImage(String fileName, File file) {
        amazonS3Client.putObject(
            new PutObjectRequest(bucket, fileName, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead)
        );
        return amazonS3Client.getUrl(bucket,fileName).toString();
    }

}
