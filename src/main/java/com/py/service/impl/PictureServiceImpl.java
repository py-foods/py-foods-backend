package com.py.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.py.entity.Picture;
import com.py.service.PictureService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Slf4j
@Service
public class PictureServiceImpl implements PictureService {

	private Cloudinary cloudinary;

	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;

	@PostConstruct
	public void init() {
		cloudinary = new Cloudinary(
				ObjectUtils.asMap("cloud_name", cloudName, "api_key", apiKey, "api_secret", apiSecret));
		cloudinary.api();
	}

	@Override
	public Picture uploadPicture(MultipartFile file, String productName) {

		String name = productName + "-" + new Date().getTime();
		Map params = ObjectUtils.asMap("public_id", name);
		Picture picture = new Picture();
		try {
			Map result = cloudinary.uploader().upload(file.getBytes(), params);
			picture.setUrl((String) result.get("url"));
			picture.setName((String) result.get("public_id"));
		} catch (IOException e) {
			log.error("upload image got error: ", e);
		}
		return picture;
	}

	@Override
	public List<Picture> uploadMultiPictures(List<MultipartFile> multipartFiles, String name) {
		return multipartFiles.stream().map(file -> uploadPicture(file, name)).collect(Collectors.toList());
	}
}
