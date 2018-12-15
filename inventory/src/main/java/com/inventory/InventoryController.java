package com.inventory;

import com.inventory.model.Item;
import com.inventory.model.Product;
import com.inventory.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/addProduct")
    public boolean addNewProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        //System.out.println("triggered");
        //speichert alle übergebenen Produkte in die DB
        for (int i = 0; i < addProductRequest.myList.size(); i++) {
            Product p1 = new Product();
            p1.setStoredAmount(addProductRequest.myList.get(i).getStoredAmount());
            p1.setProductID(addProductRequest.myList.get(i).getProductID());
            inventoryRepository.save(p1);
        }
        return true;
    }

    @PostMapping("/inventory")
    public boolean takeFromInventory(@Valid @RequestBody InventoryRequest inventoryRequest) {
        //Ist der vorhandenee Amount genug um die Bestellung auszuführen?
        if (checkForProduct(inventoryRequest)) {

            //Nimmt alle Items in der Request Liste entgegen und zieht die "verkauften" Amounts aus dem Inventar ab
            for (int i = 0; i < inventoryRequest.myList.size(); i++) {
                Product p1 = inventoryRepository.findByProductID(inventoryRequest.myList.get(i).getProductID());
                int int1 = inventoryRequest.myList.get(i).getAmount();
                p1.setStoredAmount(p1.getStoredAmount() - int1);
                inventoryRepository.save(p1);
            }
            //falls fuktioniert gibts true zurück, gibts hier etwas sinnvolleres?
            return true;
        }
        return false;
    }

    //Logik zur überprüfung ob genug Produkte vorhanden
    private boolean checkForProduct(InventoryRequest inventoryRequest) {
        boolean b1 = true;
        for (int i = 0; i < inventoryRequest.myList.size(); i++) {
            Product p1 = inventoryRepository.findByProductID(inventoryRequest.myList.get(i).getProductID());
            if(p1.getStoredAmount()<inventoryRequest.myList.get(i).getAmount()){
                b1 = false;
                System.out.println("Nicht genug Produkte von ProductID: "+inventoryRequest.myList.get(i).getProductID()+ " vorhanden.");
            }
        }
        return b1;
    }

}
