package com.springboot.service;

import com.springboot.mapper.MapperMap;
import com.springboot.model.Header;
import com.springboot.model.request.HeaderRequest;
import com.springboot.model.request.UpdateHeaderRequest;
import com.springboot.model.response.HeaderResponse;
import com.springboot.repository.MapperHeaderRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    private final MapperHeaderRepo mapperHeaderRepo;

    public MapperService(MapperHeaderRepo mapperHeaderRepo) {
        this.mapperHeaderRepo = mapperHeaderRepo;
    }

    public HeaderResponse createHeader(HeaderRequest request) {
        return MapperMap.mapHeaderToHeaderResponse(mapperHeaderRepo.save(MapperMap.mapHeaderRequestToHeader(request)));
    }

    public HeaderResponse updateHeader(UpdateHeaderRequest request) {
        Header header = mapperHeaderRepo.findById(request.getId()).orElseThrow(() -> new RuntimeException("Entity not found"));
        return MapperMap.mapHeaderToHeaderResponse(mapperHeaderRepo.save(MapperMap.mapUpdateHeaderRequestToHeader(request, header)));
    }

    public Page<HeaderResponse> getAllHeader(Pageable pageable) {
        return mapperHeaderRepo.findAll(pageable).map(t -> MapperMap.mapHeaderToHeaderResponse(t));
    }


    public HeaderResponse getHeaderById(String id) {
        Header header = mapperHeaderRepo.findById(id).orElseThrow(()-> new RuntimeException("Entity not Found"));
        return MapperMap.mapHeaderToHeaderResponse(header);
    }

}