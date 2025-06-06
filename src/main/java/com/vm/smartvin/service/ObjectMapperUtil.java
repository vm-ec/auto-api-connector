package com.vm.smartvin.service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperUtil {

    private final ModelMapper modelMapper;

    public ObjectMapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public <S, T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}

