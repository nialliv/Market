package ru.kit.backend.service;

import java.util.Collection;
import java.util.List;

import ru.kit.backend.exception.DeviceAlreadyExistException;
import ru.kit.backend.exception.DeviceNotFoundException;
import ru.kit.backend.model.Device;

public interface IDeviceService {
    long addDevice(Device device) throws DeviceAlreadyExistException;
    List<Device> getAllDevice();
    List<Device> getAllDeviceByTypeId(Long id);
    List<Device> getAllDeviceByBrandId(Long id);
    Device getDeviceById(Long id);
    long deleteDeviceById(Long id) throws DeviceNotFoundException;
    List<Long> deleteListDeviceById(Collection<Long> id);
}
