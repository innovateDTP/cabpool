package com.carpooling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpooling.domain.ProviderDetail;
import com.carpooling.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	ProviderRepository providerRepository;
	
	@Override
	public List<ProviderDetail> findByRoute(String route, String date) {
		// TODO Auto-generated method stub
		return providerRepository.findUserByRouteAndDate(route, date);
	}

	@Override
	public ProviderDetail enterProviderDetail(ProviderDetail provider) {
		// TODO Auto-generated method stub
		return providerRepository.provide(provider);
	}

}
