/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import md.ibanc.rm.entities.Devices;
import md.ibanc.rm.entities.Manufacturer;
import md.ibanc.rm.entities.NetworkOperator;
import md.ibanc.rm.entities.NetworkOperatorManufacturer;
import md.ibanc.rm.spring.dao.DevicesDAO;
import md.ibanc.rm.spring.dao.ManufacturerDAO;
import md.ibanc.rm.spring.dao.NetworkOperatorDAO;
import md.ibanc.rm.spring.dao.NetworkOperatorManufacturerDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zaițev.Victor
 */
@Service
public class DevicesServiceImpl implements DevicesService {

    private DevicesDAO devicesDAO;

    private ManufacturerDAO manufacturerDAO;
    private NetworkOperatorDAO networkOperatorDAO;
    private NetworkOperatorManufacturerDAO networkOperatorManufacturerDAO;

    public void setDevicesDAO(DevicesDAO devicesDAO) {
        this.devicesDAO = devicesDAO;
    }

    public void setManufacturerDAO(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    public void setNetworkOperatorDAO(NetworkOperatorDAO networkOperatorDAO) {
        this.networkOperatorDAO = networkOperatorDAO;
    }

    public void setNetworkOperatorManufacturerDAO(NetworkOperatorManufacturerDAO networkOperatorManufacturerDAO) {
        this.networkOperatorManufacturerDAO = networkOperatorManufacturerDAO;
    }

    @Override
    @Transactional
    public void save(Devices devices) {
        devicesDAO.save(devices);
    }

    @Override
    @Transactional
    public List findAll() {
        return devicesDAO.findAll();
    }

    @Override
    @Transactional
    public Devices findDevicesByIMIE(String imie) {
        return devicesDAO.findDevicesByIMIE(imie);
    }

    @Override
    @Transactional
    public Devices findDevicesByImieAndOperatorName(String imie, String name) {
        return devicesDAO.findDevicesByImieAndOperatorName(imie, name);
    }

    @Override
    @Transactional
    public Devices saveDevicesDetail(Map<String, String> devicesDetail) {

        Manufacturer manufacturer = manufacturerDAO.findManufacturerByBrandAndProductAndModel(devicesDetail.get("brand"), devicesDetail.get("product"), devicesDetail.get("model"));

        if (manufacturer == null) {

            manufacturer = new Manufacturer();
            manufacturer.setBrand(devicesDetail.get("brand"));
            manufacturer.setProduct(devicesDetail.get("product"));
            manufacturer.setModel(devicesDetail.get("model"));
            manufacturer.setCreateAt(new Date());
            manufacturerDAO.save(manufacturer);

        }

        NetworkOperator networkOperator = networkOperatorDAO.findNetworkOperatorByName(devicesDetail.get("networkOperatorName"));

        if (networkOperator == null) {
            networkOperator = new NetworkOperator();
            networkOperator.setNetworkOperatorCode(devicesDetail.get("networkOperator"));
            networkOperator.setNetworkOperatorName(devicesDetail.get("networkOperatorName"));
            networkOperator.setCreatedAt(new Date());
            networkOperatorDAO.save(networkOperator);

        }

        NetworkOperatorManufacturer networkOperatorManufacturer = networkOperatorManufacturerDAO.findNetworkOperatorByOperatorAndManufacturer(networkOperator.getId(), manufacturer.getId());

        if (networkOperatorManufacturer == null) {
            networkOperatorManufacturer = new NetworkOperatorManufacturer();
            networkOperatorManufacturer.setManufacturer(manufacturer);
            networkOperatorManufacturer.setNetworkOperator(networkOperator);
            networkOperatorManufacturerDAO.save(networkOperatorManufacturer);
        }

        Devices devices = devicesDAO.findDevicesByImieAndOperatorName(devicesDetail.get("IMIE"), devicesDetail.get("networkOperatorName"));

        if (devices == null) {
            devices = new Devices();
            devices.setImie(devicesDetail.get("IMIE"));
            devices.setImsi(devicesDetail.get("IMSI"));
            devices.setMacAdress(devicesDetail.get("macAddress"));
            devices.setNetworkOperatorManufacturer(networkOperatorManufacturer);
            devicesDAO.save(devices);
        }

        return devices;

    }

}
