package com.springboot.controller;

import com.springboot.model.request.HeaderRequest;
import com.springboot.model.request.UpdateHeaderRequest;
import com.springboot.model.response.HeaderResponse;
import com.springboot.service.MapperService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mapper/")
public class MapperController {
    private final MapperService mapperService;

    public MapperController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @PostMapping
    public HeaderResponse createHeader(@RequestBody HeaderRequest request){
        return mapperService.createHeader(request);
    }

    @PutMapping
    public HeaderResponse updateHeader(@RequestBody UpdateHeaderRequest request){
        return mapperService.updateHeader(request);
    }

    @GetMapping
    public Page<HeaderResponse> getAllHeader(Pageable pageable){
        return  mapperService.getAllHeader(pageable);
    }

    @GetMapping("id/{id}")
    public HeaderResponse getHeaderById(@PathVariable String id){
       return mapperService.getHeaderById(id);
    }



}
