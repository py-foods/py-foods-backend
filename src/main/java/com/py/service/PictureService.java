package com.py.service;

import org.springframework.web.multipart.MultipartFile;

import com.py.entity.Picture;

import java.util.List;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public interface PictureService {

	Picture uploadPicture(MultipartFile file, String name);

	List<Picture> uploadMultiPictures(List<MultipartFile> multipartFiles, String name);
}
