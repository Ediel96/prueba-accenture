package com.developer.billing.controller;


import com.developer.billing.models.entity.Product;
import com.developer.billing.models.entity.ReceiptProduct;
import com.developer.billing.models.services.IProductServices;
import com.developer.billing.models.services.IReceiptProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReceiptProductRestController {

    @Autowired
    private IReceiptProductServices iReceiptProductServices;

    @Autowired
    private IProductServices iProductServices;

    @GetMapping("/receipt_product")
    public List<ReceiptProduct> index(){ return  iReceiptProductServices.findAll(); }

    @GetMapping("/receipt_product/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Map<String , Object > response  = new HashMap<>();

        ReceiptProduct receiptProduct = null;

        try {
            receiptProduct = iReceiptProductServices.findById(id);
        }catch (DataAccessException e ){
            response.put("mensaje" , "Error al realizar la  cconsulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(receiptProduct == null){
            response.put("mensaje" , "El resibo  id: " .concat(id.toString().concat("no existe")));
            return  new ResponseEntity<Map<String , Object>>( response, HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<ReceiptProduct>(receiptProduct , HttpStatus.OK);
    }

    @PostMapping("/receipt_product")
    public ResponseEntity<?> save(@Valid @RequestBody ReceiptProduct receiptProduct, BindingResult result){
        Map<String, Object> response = new HashMap<>();
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        ReceiptProduct receiptProductNew = null;
        Product productAct;
        Date date = ts;

        double porcentaje = 19;
        double iva = 0;
        double sendProduct = 5000;


        if(result.hasErrors()){
            List<String> erros = new ArrayList<>();

            for(FieldError err: result.getFieldErrors()){
                erros.add("El campo " + err.getField()+ "' " + err.getDefaultMessage());
            }
            response.put("errors", erros);
            return  new ResponseEntity<Map<String , Object>>(response , HttpStatus.BAD_REQUEST);
        }

            productAct = iProductServices.findById(receiptProduct.getProduct().getId());

        if(productAct == null){
            response.put("mensaje" , "El id del producto : " .concat(productAct.getId().toString().concat("no existe")));
            return  new ResponseEntity<Map<String , Object>>( response, HttpStatus.NOT_FOUND);
        }

        int num = productAct.getValue();

        if(num >=  70000){
            iva = ( porcentaje / 100) * productAct.getValue();
        }

        if(num >= 90000){
            sendProduct = 0;
        }

        try {
            receiptProduct.setCreateAt(date);
            receiptProduct.setIvaProduct(iva);
            receiptProduct.setSendValue(sendProduct);
            receiptProduct.setProductTotal(iva + sendProduct + productAct.getValue());
            receiptProductNew = iReceiptProductServices.save(receiptProduct);
        }catch (DataAccessException e){
            response.put("mensaje" , "Error al realizar la  consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido creado el insert en la base de datos");
        response.put("Producto", receiptProductNew);
        return new ResponseEntity<Map <String, Object> >(response, HttpStatus.CREATED);
    }

    @PutMapping("/receipt_product/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ReceiptProduct receiptProduct, BindingResult result, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        ReceiptProduct receiptProductAct = null;

        Timestamp ts = new Timestamp(System.currentTimeMillis());


        Date date = ts;
        ReceiptProduct receiptProductNew = null;
        Product productAct;


        double porcentaje = 19;
        double iva = 0;
        double sendProduct = 5000;

        receiptProductAct = iReceiptProductServices.findById(id);

        if(result.hasErrors()){
            List<String> erros = new ArrayList<>();

            for(FieldError err: result.getFieldErrors()){
                erros.add("El campo " + err.getField()+ "' " + err.getDefaultMessage());
            }
            response.put("errors", erros);
            return  new ResponseEntity<Map<String , Object>>(response , HttpStatus.BAD_REQUEST);
        }

        if(receiptProductAct == null){
            response.put("mensaje", "Error: no pudo editar, el ciente ID : " .concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
        }

        ReceiptProduct receiptProductUptade = null;


        Long time = date.getTime() - receiptProductAct.getCreateAt().getTime();
        int hours = (int) ((time / (1000 * 60 * 60)) % 24);

        if(hours >= 5){
            response.put("mensaje", "Error: El limite para poder editar el pedido tiene que se menos de 5 horas");
            response.put("time", hours);
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
        }

        if(receiptProductAct == null){
            response.put("mensaje", "Error: no pudo editar, el ciente ID : " .concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
        }


        productAct = iProductServices.findById(receiptProduct.getProduct().getId());
        int num = productAct.getValue();

        if(num >=  70000){
            iva = ( porcentaje / 100) * productAct.getValue();
        }

        if(num >= 90000){
            sendProduct = 0;
        }

        try {
            receiptProductAct.setCreateAt(date);
            receiptProductAct.setIvaProduct(iva);
            receiptProductAct.setSendValue(sendProduct);
            receiptProductAct.setProductTotal(iva + sendProduct + productAct.getValue());
            receiptProductAct.setProduct(receiptProduct.getProduct());
            receiptProductAct.setClient(receiptProduct.getClient());

            receiptProductUptade = iReceiptProductServices.save(receiptProductAct);

        }catch (DataAccessException e ){
            response.put("mensaje" , "Error al actualizar la base de datos");
            response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity <Map <String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido actualizado con exito");
        response.put("cliente", receiptProductUptade);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    



}
