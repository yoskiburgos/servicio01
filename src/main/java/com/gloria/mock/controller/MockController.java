package com.gloria.mock.controller;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import com.gloria.mock.dto.request.EnrolarRequest;
import com.gloria.mock.dto.request.NuevaConversacionRequest;
import com.gloria.mock.dto.request.SucursalRequest;
import com.gloria.mock.dto.request.ValidarClienteRequest;
import com.gloria.mock.dto.resoponse.BeneficioResponse;
import com.gloria.mock.dto.resoponse.EnrolarResponse;
import com.gloria.mock.dto.resoponse.NuevaConversacionResponse;
import com.gloria.mock.dto.resoponse.ResponseData;
import com.gloria.mock.dto.resoponse.ResponseStatus;
import com.gloria.mock.dto.resoponse.SegmentacionResponse;
import com.gloria.mock.dto.resoponse.ValidarClienteResponse;
import com.gloria.mock.dto.resoponse.SucursalResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("api/v1/cliente")
public class MockController {

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        String alive = "it is alive";
        return new ResponseEntity<String>(alive, HttpStatus.OK);
    }

    
    @PostMapping("/validar")
    public ResponseEntity<ValidarClienteResponse> validarCliente(@RequestBody ValidarClienteRequest request, @RequestHeader("idTransaccion") String idTransaccion, @RequestHeader("empresa") String empresa ) {
        
        ValidarClienteResponse validarClienteResponse = new ValidarClienteResponse();
        if(request.getTipo() == null || request.getTipo() > 2 || request.getTipo() < 1 ){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Tipo de documento inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getDocumento() == null || request.getDocumento().length() > 11 || request.getDocumento().length() < 8){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Documento inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getTelefono() == null || request.getTelefono().length() != 9){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Número de teléfono inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getDocumento().equals("11111111")){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF004").descripcionRespuesta("Número de Documento no existe.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getTelefono().equals("111111111")){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF005").descripcionRespuesta("Número de teléfono no corresponde al cliente.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getDocumento().equals("46473154")){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF006").descripcionRespuesta("Cliente existente con 1 sucursal.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            ResponseData responseData = new ResponseData();
            responseData.setIdCliente(1);
            responseData.setNombre("Ricardo");
            validarClienteResponse.setResponseData(responseData);
            SegmentacionResponse segmentacionResponse = new SegmentacionResponse();
            segmentacionResponse.setNombre("Oro");
            
            BeneficioResponse beneficioResponse = new BeneficioResponse();
            beneficioResponse.setDescuento(5.00);
            beneficioResponse.setInformacion("Una compra mínima de S/100.00. | Un mix de 5 categorias de productos diferentes.");
            List<BeneficioResponse> beneficios = new ArrayList<BeneficioResponse>();
            beneficios.add(beneficioResponse);
            segmentacionResponse.setBeneficios(beneficios);
            responseData.setSegmentacion(segmentacionResponse);
            SucursalResponse sucursalResponse =  new SucursalResponse();
            sucursalResponse.setIdSucursal(1);
            sucursalResponse.setCodigoCliente("1025");
            sucursalResponse.setNombre("Bodeja don juan");
            sucursalResponse.setDireccion("Jiron tacna Nro 1520");
            sucursalResponse.setDistrito("San juan de miraflores");
            List<SucursalResponse> sucursales = new ArrayList<SucursalResponse>();
            sucursales.add(sucursalResponse);
            responseData.setSucursales(sucursales);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        if(request.getDocumento().equals("46473155")){
            ResponseStatus responseStatusDto =  ResponseStatus.builder().codigoRespuesta("IDF007").descripcionRespuesta("Cliente existente con más de 1 sucursal.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            validarClienteResponse.setResponseStatus(responseStatusDto);
            ResponseData responseData = new ResponseData();
            responseData.setIdCliente(1);
            responseData.setNombre("Ricardo");
            validarClienteResponse.setResponseData(responseData);
            SegmentacionResponse segmentacionResponse = new SegmentacionResponse();
            segmentacionResponse.setNombre("Oro");
            
            BeneficioResponse beneficioResponse = new BeneficioResponse();
            beneficioResponse.setDescuento(5.00);
            beneficioResponse.setInformacion("Una compra mínima de S/100.00. | Un mix de 5 categorias de productos diferentes.");
            List<BeneficioResponse> beneficios = new ArrayList<BeneficioResponse>();
            beneficios.add(beneficioResponse);
            segmentacionResponse.setBeneficios(beneficios);
            responseData.setSegmentacion(segmentacionResponse);
            List<SucursalResponse> sucursales = new ArrayList<SucursalResponse>();
            SucursalResponse sucursalResponse =  new SucursalResponse();
            sucursalResponse.setIdSucursal(1);
            sucursalResponse.setCodigoCliente("1025");
            sucursalResponse.setNombre("Bodeja don juan");
            sucursalResponse.setDireccion("Jiron tacna Nro 1520");
            sucursalResponse.setDistrito("San juan de miraflores");
            sucursales.add(sucursalResponse);
            SucursalResponse sucursalResponseTest =  new SucursalResponse();
            sucursalResponseTest.setIdSucursal(1);
            sucursalResponseTest.setCodigoCliente("1026");
            sucursalResponseTest.setNombre("Bodeja don jose");
            sucursalResponseTest.setDireccion("Jiron arica Nro 1520");
            sucursalResponseTest.setDistrito("Miraflores");
            sucursales.add(sucursalResponseTest);
            responseData.setSucursales(sucursales);
            return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
        }

        return new ResponseEntity<ValidarClienteResponse>(validarClienteResponse, HttpStatus.OK);
    }

    @PostMapping("/enrolar")
    public ResponseEntity<EnrolarResponse> enrolar(@RequestBody EnrolarRequest request, @RequestHeader("idTransaccion") String idTransaccion, @RequestHeader("empresa") String empresa ) {
        
        EnrolarResponse enrolarResponse = new EnrolarResponse();
        if(request.getTelefono() == null || request.getTelefono().length() != 9 ){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Número de telefono inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            enrolarResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<EnrolarResponse>(enrolarResponse, HttpStatus.OK);
        }

        for(int i = 0; i < request.getSucursales().size(); i++){
            SucursalRequest sucursalRequest = request.getSucursales().get(i);
            if(sucursalRequest.getIdSucursal() == null || sucursalRequest.getIdSucursal() < 1){
                ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Listado de sucursales inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
                enrolarResponse.setResponseStatus(responseStatus);
                return new ResponseEntity<EnrolarResponse>(enrolarResponse, HttpStatus.OK);
            }
        }

        ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Sucursales enroladas correctamente.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
        enrolarResponse.setResponseStatus(responseStatus);
        return new ResponseEntity<EnrolarResponse>(enrolarResponse, HttpStatus.OK);
    }

    @PostMapping("/nueva-conversacion")
    public ResponseEntity<NuevaConversacionResponse> nuevaConversacion(@RequestBody NuevaConversacionRequest request, @RequestHeader("idTransaccion") String idTransaccion, @RequestHeader("empresa") String empresa ) {
        
        NuevaConversacionResponse nuevaConversacionResponse = new NuevaConversacionResponse();
        if(request.getTelefono() == null || request.getTelefono().length() != 9 ){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF001").descripcionRespuesta("Número de telefono inválido.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            nuevaConversacionResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<NuevaConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
        }

        if(request.getTelefono().equals("111111111") ){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF002").descripcionRespuesta("Número de teléfono no existe.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            nuevaConversacionResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<NuevaConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
        }

        if(request.getTelefono().equals("999999999") ){
            ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF003").descripcionRespuesta("Número de teléfono no esta enrolado.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
            nuevaConversacionResponse.setResponseStatus(responseStatus);
            return new ResponseEntity<NuevaConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
        }

        ResponseStatus responseStatus =  ResponseStatus.builder().codigoRespuesta("IDF004").descripcionRespuesta("Nueva conversación realizada con éxito.").status(0).idTransaccion(idTransaccion).fechaTermino(LocalDateTime.now().toString()).build();
        nuevaConversacionResponse.setResponseStatus(responseStatus);
        return new ResponseEntity<NuevaConversacionResponse>(nuevaConversacionResponse, HttpStatus.OK);
    }

    

}
