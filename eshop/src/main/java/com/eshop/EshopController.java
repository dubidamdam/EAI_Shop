package com.eshop;

import com.eshop.model.Item;
import com.eshop.model.Product;
import com.eshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EshopController {
    @Autowired
    private ProductRepository productRepository;
    private RestTemplate restTemplate = new RestTemplate();
    private List myList = new ArrayList();
    private List myAddList = new ArrayList();

    /* -> statischesOrdering
    //diese methode müsste produkt und anzahl aus cart übergeben bekommen
    public Item customerOrdersAnItem(){
        Item orderItem = new Item();
        orderItem.setProductID(productRepository.findAll().get(0).getID());
        orderItem.setAmount(1);
        return orderItem;
    }*/

/* Add Product ohne json,mit direkter produktübergabe aus Postman
    @PostMapping("/eshop/addproduct")
    public boolean addAProduct(@Valid @RequestBody Product addProduct) {

        //System.out.println(p1.getProductName().toString());
        productRepository.save(addProduct);

        //generiert AddProductRequest
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.myList.add(addProduct);
        System.out.println(restTemplate.postForObject("http://localhost:8083/addProduct", addProductRequest, Boolean.class));
        return true;
    }*/

    //Methode die den Intent prüft.
    @PostMapping("/eshop")
    public boolean whatIntent(@Valid @RequestBody Jsonconv json) {
        String intent = json.getQueryResult().getIntent().getDisplayName();
        if (intent.equals("add-product")) {
            this.addAProduct(json);
        } else if (intent.equals("get-order")) {
            this.handleCheckout(json);
        }
        return true;
    }

    //addproduct mit json
    private boolean addAProduct(Jsonconv json) {
        Long productID1 = json.getQueryResult().getParameters().getProductID();
        Long price1 = json.getQueryResult().getParameters().getPrice();
        String productName1 = json.getQueryResult().getParameters().getProductName();
        Long storedAmount1 = json.getQueryResult().getParameters().getStoredAmount();

        Integer storedAmount2 = storedAmount1.intValue();
        Integer price2 = price1.intValue();

        Product addProduct = new Product();
        addProduct.setProductID(productID1);
        addProduct.setPrice(price2);
        addProduct.setProductName(productName1);
        addProduct.setStoredAmount(storedAmount2);

        //System.out.println(p1.getProductName().toString());
        productRepository.save(addProduct);

        //generiert AddProductRequest
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.myList.add(addProduct);
        System.out.println(restTemplate.postForObject("http://localhost:8083/addProduct", addProductRequest, Boolean.class));
        return true;
    }


    //startet Business Logik von Checkout
    private boolean handleCheckout(Jsonconv json) {
        //handelt Dialogflow Jsonobjekt -> http://www.jsonschema2pojo.org/ genutzt um aus dem JSON Java Klassen generieren
        String productName = json.getQueryResult().getParameters().getProductName();
        Long productID1 = productRepository.findByProductName(productName).getProductID(); //product ID wird anhand des namens in DB geholt
        //System.out.println(productID1);
        //Long productID1 = json.getQueryResult().getParameters().getProductID(); -> product ID direkt aus dialogflow
        Long amount1 = json.getQueryResult().getParameters().getAmount();
        //Long productID2 = Long.parseLong(productID1);
        Integer amount2 = amount1.intValue();
        Item orderItem = new Item();
        orderItem.setProductID(productID1);
        orderItem.setAmount(amount2);

        /*Statisches Ordering
        // übernimmt Produkt aus "Order" Methode
        orderItem = this.customerOrdersAnItem();
        */
        //System.out.println(orderItem.toString());
        //System.out.println(orderItem.productID);
        //System.out.println(orderItem.amount);

        //generiert PaymentRequest und übernimmt Preis und ID von orderItem
        PaymentRequest paymentRequest = new PaymentRequest();
        Integer stckprice = productRepository.findByProductID(orderItem.getProductID()).getPrice();
        Long productID = productRepository.findByProductID(orderItem.getProductID()).getProductID();
        Integer amount = orderItem.getAmount();
        //preisberechnung aus amount*stückpreis
        Integer price = stckprice * amount;
        paymentRequest.price = price;
        paymentRequest.productID = productID;

        //generiert ShipmentRequest
        ShipmentRequest shipmentRequest = new ShipmentRequest();
        shipmentRequest.productID = productID;

        //generiert inventoryRequest
        // Fügt Item der AL in InventoryRequest und somit der DB hinzu
        InventoryRequest inventoryRequest = new InventoryRequest();
        inventoryRequest.myList.add(orderItem);

        //Übergibt die Requests per Rest/Post
        System.out.println(restTemplate.postForObject("http://localhost:8082/payment", paymentRequest, Boolean.class));
        System.out.println(restTemplate.postForObject("http://localhost:8083/inventory", inventoryRequest, Boolean.class));
        System.out.println(restTemplate.postForObject("http://localhost:8081/shipment", shipmentRequest, String.class));

        return true;
    }

}
