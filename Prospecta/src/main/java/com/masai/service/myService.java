package com.masai.service;

import java.util.List;

import com.masai.entity.Datas;
import com.masai.entity.DatasDTO;
import com.masai.exception.ClientException;

public interface myService {

	public List<DatasDTO> entries(String category) throws ClientException ;
	
	public Datas save(Datas datas) throws ClientException;
}
