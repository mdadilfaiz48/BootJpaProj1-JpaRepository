package com.adil.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.adil.entity.Artist;
import com.adil.service.IArtistMangmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IArtistMangmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("InMemory proxy obj class name :"+service.getClass());
		
		
	  /*	try {
			List<Integer> ids = Arrays.asList(7,8,20,null);
			String resultMsg = service.removeArtistByIdsInBatch(ids);
			System.out.println(resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Artist> list = service.searchArtistByGivenData(null, 980000);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			
		Optional<Artist> opt = service.searchArtistById(120);
		if(opt.isEmpty()) {
			
			System.out.println("Record not found");
		}else {
			Artist artist = opt.get();
			System.out.println(artist);	
		   }
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("---------------------------------------------------");
		try {
			
			Artist artist = service.loadArtistById(120);
			System.out.println("proxy class name : "+artist.getClass()+"super class name : "+artist.getClass().getSuperclass());
			System.out.println(artist);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
