package exercise.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarUpdateDTO;
import exercise.dto.CarDTO;
import exercise.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

// BEGIN
@Mapper(
        uses = {JsonNullableMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public class CarMapper extends JsonNullableMapper {
    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    public void update(CarUpdateDTO carUpdateDTO, @MappingTarget Car model) {
        if (carUpdateDTO == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(carUpdateDTO.getModel())) {
            model.setModel(jsonNullableMapper.unwrap(carUpdateDTO.getModel()));
        }
        if (jsonNullableMapper.isPresent(carUpdateDTO.getManufacturer())) {
            model.setManufacturer(jsonNullableMapper.unwrap(carUpdateDTO.getManufacturer()));
        }
        if (jsonNullableMapper.isPresent(carUpdateDTO.getEnginePower())) {
            model.setEnginePower(jsonNullableMapper.unwrap(carUpdateDTO.getEnginePower()));
        }
    }
    public Car map(CarCreateDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Car car = new Car();
            car.setModel(dto.getModel());
            car.setManufacturer(dto.getManufacturer());
            car.setEnginePower(dto.getEnginePower());
            return car;
        }
    }
    public CarDTO map(Car car) {
        if (car == null) {
            return null;
        } else {
            CarDTO dto = new CarDTO();
            dto.setModel(car.getModel());
            dto.setManufacturer(car.getManufacturer());
            dto.setEnginePower(car.getEnginePower());
            return dto;
        }
    }
}
// END
