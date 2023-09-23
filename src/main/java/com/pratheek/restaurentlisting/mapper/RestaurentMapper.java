package com.pratheek.restaurentlisting.mapper;

import com.pratheek.restaurentlisting.dto.RestaurentDto;
import com.pratheek.restaurentlisting.entity.Restaurent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurentMapper {

    RestaurentMapper INSTANCE = Mappers.getMapper(RestaurentMapper.class);
    Restaurent mapRestaurentDtoToRestaurent(RestaurentDto restaurentDto);
    RestaurentDto mapRestaurentToRestaurentDto(Restaurent restaurent);

}
