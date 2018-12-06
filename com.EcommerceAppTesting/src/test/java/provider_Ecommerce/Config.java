/**
 * 
 */
package provider_Ecommerce;

import factory_Ecommerce.Configuration;

/**
 * @author Lenovo
 *
 */
public class Config {

	public static Configuration getConfig(){
		
		Configuration config = new Configuration();
		
		return config;
		
	}
	
	public static ExcelProvider getExcel(){
		
		ExcelProvider excel = new ExcelProvider();
		
		return excel;
	}
	
}
