package com.headwire.bnp;

public class UrlRewriteBuilder {
	
	/**
	 * This class is a simple utility for building the URL Rewrite Regular expressions.
	 * I decided to generate them programmatically so that it is easier to modify it later,
	 * or add new ones if needed
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// this is the country and language capture group that will be used in the regex
		String countryLanguageCapture = "(\\w\\w)/(\\w\\w)";
		String clc = countryLanguageCapture; // short name for ease of typing
		
		String countryLanguageReplace = "$1/$2";
		String clr = countryLanguageReplace; // short name for ease of typing
		
		String[][] regexes = new String[][] {
			{ "www.invitrogen.com/site/us/en/home/product-selection-guides-and-tools",
				"www.lifetechnologies.com/us/en/home/selection-guides" },
				
		};
	}
	
	

}

/* invitrogen pages

www.invitrogen.com/site/us/en/home/product-selection-guides-and-tools*
www.invitrogen.com/site/us/en/home/Products-and-Services/Applications*
www.invitrogen.com/site/us/en/home/Products-and-Services*
www.invitrogen.com/site/us/en/home/References*
www.invitrogen.com/site/us/en/home/support/Cell-Lines-Browse*
www.invitrogen.com/site/us/en/home/support/Research-Tools/Image-Gallery/Image-Exhibit*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/Product-Spectra*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/Product-Structures*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/Citations-and-Bibliographic-References*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/Cell-Lines-Browse*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/Cell-Lines-Advanced-Search*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/media_formulation*
www.invitrogen.com/site/us/en/home/support/Product-Technical-Resources/media_formulation.256.html
www.invitrogen.com/site/us/en/home/support*
www.invitrogen.com/site/us/en/home/brands*
www.invitrogen.com/site/us/en/home/Global*
www.invitrogen.com/site/us/en/home/B2B-Storefronts*
www.invitrogen.com/site/us/en/home/b2b*
www.invitrogen.com/etc/medialib*
www.invitrogen.com/content/site*
www.invitrogen.com/site*
www.lifetechnologies.com/content/lifetech*
www.lifetechnologies.com/content*
www.invitrogen.com/site.gateway.html?type=spectra&fileId=*
www.invitrogen.com/site.gateway.html?type=structure&itemId=*
www.invitrogen.com/site.gateway.html?type=gallerydetail&fileId=*
www.invitrogen.com/site.gateway.html?type=mediaForm&productId=*
www.invitrogen.com/site.gateway.html?type=cellDetail&cellId=*
www.invitrogen.com/site.gateway.html?type=citations&code=*
www.invitrogen.com*

*/
