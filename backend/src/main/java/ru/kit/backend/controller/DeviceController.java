package ru.kit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kit.backend.exception.DeviceAlreadyExistException;
import ru.kit.backend.exception.DeviceNotFoundException;
import ru.kit.backend.model.Device;
import ru.kit.backend.service.IDeviceService;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addDevice(@RequestBody Device device) {
        try {
            deviceService.addDevice(device);
            return ResponseEntity.ok("Device added successfully");
        } catch (DeviceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<Device> getDeviceList() {
        return deviceService.getAllDevice();
    }

    @GetMapping("/{id}/get")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteDeviceById(@PathVariable Long id) {
        try {
            deviceService.deleteDeviceById(id);
            return ResponseEntity.ok("Device successfully deleted");
        } catch (DeviceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
