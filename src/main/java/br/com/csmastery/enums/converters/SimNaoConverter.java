package br.com.csmastery.enums.converters;

import br.com.csmastery.enums.SimNao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
@Converter(autoApply = true)
public class SimNaoConverter implements AttributeConverter<SimNao, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SimNao simNao) {
        if (simNao == null) {
            return 0;
        }

        return simNao.getValue();
    }

    @Override
    public SimNao convertToEntityAttribute(Integer value) {
        if (value < 0) {
            return null;
        }

        return Stream.of(SimNao.values())
                .filter(v -> v.getValue() == value)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
