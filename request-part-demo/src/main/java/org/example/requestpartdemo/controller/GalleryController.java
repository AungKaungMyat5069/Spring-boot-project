package org.example.requestpartdemo.controller;

import org.example.requestpartdemo.storage.InMemoryStorage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@Controller
public class GalleryController {

    private final InMemoryStorage storage;

    public GalleryController(InMemoryStorage storage) {
        this.storage = storage;
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("imageNames", storage.getNames());
        return "gallery";
    }

    @ResponseBody
    @GetMapping(value = "/gallery/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] galleryImage(@PathVariable(name = "name") String name) {
        return storage.getByName(name);
    }

    @PostMapping("/gallery/file-upload")
    public String uploadFile(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        storage.store(multipartFile.getOriginalFilename(), multipartFile.getBytes());
        return "redirect:/gallery";
    }
}
