package com.adil.service;

import java.util.List;
import java.util.Optional;

import com.adil.entity.Artist;


public interface IArtistMangmtService {
	
	public String removeArtistByIdsInBatch(List<Integer> ids);
	
	public List<Artist> searchArtistByGivenData(String name,double fee);
	
	public Optional<Artist> searchArtistById(Integer id);
	
	public Artist loadArtistById(Integer id);

}
