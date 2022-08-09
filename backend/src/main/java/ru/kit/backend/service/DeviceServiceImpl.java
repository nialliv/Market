package ru.kit.backend.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kit.backend.exception.DeviceAlreadyExistException;
import ru.kit.backend.exception.DeviceNotFoundException;
import ru.kit.backend.model.Device;
import ru.kit.backend.repository.DeviceRepository;

import java.util.Collection;
import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public long addDevice(Device device) throws DeviceAlreadyExistException {
        if(deviceRepository.findByName(device.getName()) != null) {
            throw new DeviceAlreadyExistException("Error, this device has already been created");
        }
        return deviceRepository.save(device).getId();
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> getAllDeviceByTypeId(Long id) {
        return null;
    }

    @Override
    public List<Device> getAllDeviceByBrandId(Long id) {
        return null;
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).get();
    }

    @Override
    public long deleteDeviceById(Long id) throws DeviceNotFoundException {
        if (deviceRepository.findById(id).isEmpty()) {
            throw new DeviceNotFoundException("Error, this user was not found");
        }
        deviceRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Long> deleteListDeviceById(Collection<Long> id) {
        return null;
    }
}
