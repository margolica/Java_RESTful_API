package edu.school21.java_RESTful_API.mapper;

import edu.school21.java_RESTful_API.dto.ImagesDto;
import edu.school21.java_RESTful_API.model.Images;
import org.mapstruct.Mapper;

import java.util.List;


public interface ImagesMapper {

    Images toEntity(ImagesDto clientDto);

    ImagesDto toDTO(Images client);

    List<ImagesDto> toDTOList(List<Images> clients);
}
