package com.adil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.entity.Artist;

public interface IArtistRepository extends JpaRepository<Artist, Integer>{

}
