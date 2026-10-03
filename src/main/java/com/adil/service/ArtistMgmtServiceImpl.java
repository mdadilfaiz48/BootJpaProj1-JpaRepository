package com.adil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adil.entity.Artist;
import com.adil.repository.IArtistRepository;

@Service("artistService")
public class ArtistMgmtServiceImpl implements IArtistMangmtService {
	
	@Autowired
	private IArtistRepository artistRepo;

	@Override
	public String removeArtistByIdsInBatch(List<Integer> ids) {
		// load object by ids
		List<Artist> list = artistRepo.findAllById(ids);
		// delete ojects by ids in batch
		artistRepo.deleteAllByIdInBatch(ids);
		
		return list.size()+" no of records are deleted in batch";	
	}

	@Override
	public List<Artist> searchArtistByGivenData(String name, double fee) {
		
		Artist artist = new Artist();
		artist.setAname(name);
		artist.setFee(fee);
	
		// prepare Example object
		Example<Artist> example = Example.of(artist);
		List<Artist> list = artistRepo.findAll(example);
		
		return list;
	}

	@Override
	public Optional<Artist> searchArtistById(Integer id) {
	
		return artistRepo.findById(id);
	}

	@Override
	public Artist loadArtistById(Integer id) {
		
		return artistRepo.getReferenceById(id);
	}

}
