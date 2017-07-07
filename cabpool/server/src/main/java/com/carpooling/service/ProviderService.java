package com.carpooling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carpooling.domain.ProviderDetail;

@Service
public interface ProviderService {

	List<ProviderDetail> findByRoute(String route, String date);
	ProviderDetail enterProviderDetail(ProviderDetail provider);
	
}
