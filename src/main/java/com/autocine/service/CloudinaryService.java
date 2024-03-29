package com.autocine.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
    @Autowired
    Cloudinary cloudinary;

    @Value("${cloudinary.folder}")
    private String cloudinaryFolder;

    public Map uploaad(String folderTabla, MultipartFile multipartFile) throws IOException {

        Map<String, Object> params = new HashMap<>();
        params.put("folder", cloudinaryFolder + "/" + folderTabla);
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, params);
        file.delete();
        return result;
    }

    public Map delete(String folderTabla, String id) throws IOException {
        String publicId = cloudinaryFolder + "/" + folderTabla + "/" + id;
        Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
