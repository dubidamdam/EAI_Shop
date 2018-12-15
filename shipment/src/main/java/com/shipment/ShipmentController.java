package com.shipment;

import com.shipment.model.Shipment;
import com.shipment.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @PostMapping("/shipment")
    public String getShipment(@Valid @RequestBody ShipmentRequest shipmentRequest) {
        Shipment shipment = new Shipment();
        shipment.setTrackingId(UUID.randomUUID().toString());
        shipment.setId(shipmentRequest.productID);
        shipmentRepository.save(shipment);

        return shipmentRepository.findAll().get(0).getTrackingId();
    }

}
