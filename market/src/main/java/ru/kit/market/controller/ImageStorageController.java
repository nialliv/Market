package ru.kit.market.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import ru.kit.market.model.Image;
import ru.kit.market.model.UploadResponseMessage;
import ru.kit.market.service.ImageStorageService;

@RestController
@RequestMapping("images")
public class ImageStorageController {
    private final ImageStorageService imageStorageService;

    @Autowired
    public ImageStorageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @PostMapping
    public ResponseEntity<UploadResponseMessage> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            imageStorageService.save(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new UploadResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
        }
    }

    @GetMapping
    public ResponseEntity<List<Image>> getListImages() {
        List<Image> fileInfos = imageStorageService.loadAll()
                .stream()
                .map(this::pathToFileImage)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @DeleteMapping
    public void delete() {
        imageStorageService.deleteAll();
    }

    private Image pathToFileImage(Path path) {
        Image image = new Image();
        String filename = path.getFileName().toString();
        image.setFilename(filename);
        image.setUrl(MvcUriComponentsBuilder.fromMethodName(ImageStorageController.class, "getFile", filename)
                .build()
                .toString());
        
                try {
                    image.setSize(Files.size(path));
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Error: " + e.getMessage());
                }

        return image;
    }

    @GetMapping("{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = imageStorageService.load(filename);
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                             .body(file);
    }
}

