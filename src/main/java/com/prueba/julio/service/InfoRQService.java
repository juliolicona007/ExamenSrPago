package com.prueba.julio.service;

import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;
import com.prueba.julio.model.InfoRQ;

public interface InfoRQService {

	InfoRQ save(InfoRQ info) throws IOException, ParseException;
	
	List<InfoRQ> findAll();
	
}
