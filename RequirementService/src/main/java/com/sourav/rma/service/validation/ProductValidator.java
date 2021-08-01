/**
 * 
 */
package com.sourav.rma.service.validation;

import com.sourav.rma.entity.Product;
import com.sourav.rma.exception.NoProductOwnerException;

/**
 * @author dell
 *
 */
public class ProductValidator {
	
	public static boolean isValidProduct(Product product) throws NoProductOwnerException {
		boolean isValidProduct = true;
		if(product.getProductOwner().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		if(product.getBusinessProcessOwner().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		if(product.getBusinessAnalyst().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		if(product.getDeveloper().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		if(product.getQualityAnalyst().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		if(product.getDeliveryManager().isBlank()) {
			isValidProduct = false;
			throw new NoProductOwnerException();
		}
		return isValidProduct;
	}

}
