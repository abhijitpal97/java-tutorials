package com.example.profilesetup.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	static Map<String , List<String>> validextension = new HashMap<>();
	
	static
	{
		validextension.put("Image", Arrays.asList("JPEG","JPG","JPG", "PNG"));
		validextension.put("File", Arrays.asList("DOC","DOCX","PDF"));
		
	}

	public boolean validateFileType(String type, String extension) {
		if(validextension.get(type).contains(extension.toUpperCase())) return true;
		
		return false;
		
	}

}
