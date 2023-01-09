package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.entity.Datas;
import com.masai.entity.DatasDTO;
import com.masai.entity.Entry;
import com.masai.exception.ClientException;
import com.masai.repo.DatasRepo;

@Service
public class myServiceImpl implements myService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DatasRepo dRepo;

	@Override
	public List<DatasDTO> entries(String category) throws ClientException {
		Entry entry = restTemplate.getForObject("https://api.publicapis.org/entries", Entry.class);
		// From API
		List<Datas> datasApi = entry.getEntries();

		// From LocalHost Database
		List<Datas> datasDatabase = dRepo.findByCategory(category);

		// For multiple words in category
		List<DatasDTO> lists = new ArrayList<>();

		for (Datas i : datasApi) {
			if (i.getCategory().split(" ")[0].equals(category)) {
				lists.add(new DatasDTO(i.getApi(), i.getDescription()));
			}
		}
		for (Datas i : datasDatabase) {
			if (i.getCategory().split(" ")[0].equals(category)) {
				lists.add(new DatasDTO(i.getApi(), i.getDescription()));
			}
		}
		if (lists.size() == 0)
			throw new ClientException("Not Found");

		else
			return lists;

	}

	@Override
	public Datas save(Datas datas) throws ClientException {

		Datas d = dRepo.save(datas);
		if (d == null)
			throw new ClientException("Cannot Add");
		else
			return d;
	}

}
