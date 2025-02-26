package edu.school21.java_RESTful_API.mapper;

import edu.school21.java_RESTful_API.dto.AddressDto;
import edu.school21.java_RESTful_API.dto.ImagesDto;
import edu.school21.java_RESTful_API.model.Address;
import edu.school21.java_RESTful_API.model.Client;
import edu.school21.java_RESTful_API.model.Images;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressDto clientDto);

    AddressDto toDTO(Address client);

    List<AddressDto> toDTOList(List<Client> clients);

    @Component
    class ImagesMapperImpl implements ImagesMapper {

        @Override
        public Images toEntity(ImagesDto imagesDto) {
            if (imagesDto == null ) {
                return null;
            }
            Images images = new Images();
            images.setData(imagesDto.getData());

            return images;
        }

        @Override
        public ImagesDto toDTO(Images images) {
            if (images == null ) {
                return null;
            }
            ImagesDto imagesDto = new ImagesDto();
            imagesDto.setData(images.getData());

            return imagesDto;
        }

        @Override
        public List<ImagesDto> toDTOList(List<Images> images) {
            if ( images == null ) {
                return null;
            }

            List<ImagesDto> list = new ArrayList<ImagesDto>(images.size());
            for (Images image : images) {
                list.add(toDTO(image));
            }

            return list;
        }
    }
}
