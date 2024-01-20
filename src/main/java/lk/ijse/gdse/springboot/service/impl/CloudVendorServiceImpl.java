package lk.ijse.gdse.springboot.service.impl;

import lk.ijse.gdse.springboot.exception.CloudVendorNotFoundException;
import lk.ijse.gdse.springboot.model.CloudVendor;
import lk.ijse.gdse.springboot.repository.CloudVendorRepository;
import lk.ijse.gdse.springboot.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //more business logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //more business logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //more business logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        //more business logic
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exists");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        //more business logic
        return cloudVendorRepository.findAll();
    }
}
