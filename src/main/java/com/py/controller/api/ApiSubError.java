package com.py.controller.api;

//abstract class ApiSubError {
//}


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiSubError {
   private String field;
   private Object rejectedValue;
   private String message;
 
   public ApiSubError(String field, String message) {
       this.field = field;
       this.message = message;
   }
}