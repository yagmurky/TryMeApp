package com.yagmur.mapper;

import com.yagmur.dto.request.CustomerUpdateRequestDto;
import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.entity.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    LoginResponseDto fromUserToLoginResponseDto(final Customer customer);
    Customer fromRegisterRequestDtoToUser(final RegisterRequestDto dto);
    RegisterResponseDto fromUserToRegisterResponseDto(final Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(CustomerUpdateRequestDto dto, @MappingTarget Customer customer);
}
