package Date_13_08;

/*Dynamic web elements-values
 * keep changing and they have alphanumeric values
 * starts with
 * //input[@id='id_43546']	   
 * //input[@id='id_67769']
 * //input[@id='id_45545']
 * 
 * 
 * ends with
 * //input[@id='56566_name']
 * //input[@id='78999_name']
 * //input[@id='32344_name']
 * 
 * 
 * regular expressions to handle
 * dynamic web elements
 * 
 *  //input[starts-with(@id),'id_']
 *  //input[starts-with(text(),'id_')]
 *  //input[ends-with(@id),'_name']
 *  //a[contains(text(),'name')]
 *  //button[@name='login' and @type='submit']
 *  
 *  
 */