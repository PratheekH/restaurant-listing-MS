package com.pratheek.restaurentlisting.service;

import com.pratheek.restaurentlisting.dto.RestaurentDto;
import com.pratheek.restaurentlisting.entity.Restaurent;
import com.pratheek.restaurentlisting.mapper.RestaurentMapper;
import com.pratheek.restaurentlisting.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurentService {

    @Autowired
    RestaurentRepository repository;

    public List<RestaurentDto> findAllRestaurents() {
        List<Restaurent> restaurents = repository.findAll();
        List<RestaurentDto> restaurentDtoList = restaurents.stream().map(res -> RestaurentMapper.INSTANCE.mapRestaurentToRestaurentDto(res))
                .collect(Collectors.toList());
        return restaurentDtoList;
    }

    public RestaurentDto addRestaurentInDB(RestaurentDto restaurentDto) {
        Restaurent savedRestaurent = repository.save(RestaurentMapper.INSTANCE.mapRestaurentDtoToRestaurent(restaurentDto));
        return RestaurentMapper.INSTANCE.mapRestaurentToRestaurentDto(savedRestaurent);

    }

    public ResponseEntity<RestaurentDto> fetchRestaurentById(Integer id) {
        Optional<Restaurent> restaurent = repository.findById(id);
        if(restaurent.isPresent()) {
            return new ResponseEntity<>(RestaurentMapper.INSTANCE.mapRestaurentToRestaurentDto(restaurent.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
