package com.prospecta.service;

import java.util.List;

import com.prospecta.entity.Datas;
import com.prospecta.entity.DatasDTO;
import com.prospecta.exception.ClientException;

public interface myService {

	public List<DatasDTO> entries(String category) throws ClientException ;
	
	public Datas save(Datas datas) throws ClientException;
}
