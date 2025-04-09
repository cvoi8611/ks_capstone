package com.StudyBuddy.calender.Converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        return attribute == null ? "" : String.join(",", attribute);
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        return dbData == null || dbData.isEmpty()
                ? new HashSet<>()
                : new HashSet<>(Arrays.asList(dbData.split(",")));
    }
}
