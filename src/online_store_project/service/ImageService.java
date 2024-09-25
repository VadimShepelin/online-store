package online_store_project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();
    private static final String PATH_TO_IMAGES="C:\\Users\\kocic\\IdeaProjects\\online_store\\images";

    @SneakyThrows
    public void saveProductImage(String imagePath, InputStream inputStream){
        String fullPathToImage=PATH_TO_IMAGES+imagePath;
        byte[] imageBytes = inputStream.readAllBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(fullPathToImage);
        fileOutputStream.write(imageBytes);

        fileOutputStream.close();
        inputStream.close();
    }

    @SneakyThrows
    public byte[] getImageBytes(String imagePath){
        String fullPathToImage=PATH_TO_IMAGES+imagePath;
        Path path = Path.of(fullPathToImage);

        return Files.readAllBytes(path);
    }



    public static ImageService getInstance() {
        return INSTANCE;
    }
}
