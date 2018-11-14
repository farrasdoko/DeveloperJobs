package com.idn.farras.developerjobs.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseJobs{

	@SerializedName("company_logo")
	private String companyLogo;

	@SerializedName("how_to_apply")
	private String howToApply;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("description")
	private String description;

	@SerializedName("location")
	private String location;

	@SerializedName("company")
	private String company;

	@SerializedName("company_url")
	private String companyUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	public void setCompanyLogo(String companyLogo){
		this.companyLogo = companyLogo;
	}

	public String getCompanyLogo(){
		return companyLogo;
	}

	public void setHowToApply(String howToApply){
		this.howToApply = howToApply;
	}

	public String getHowToApply(){
		return howToApply;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setCompanyUrl(String companyUrl){
		this.companyUrl = companyUrl;
	}

	public String getCompanyUrl(){
		return companyUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"ResponseJobs{" + 
			"company_logo = '" + companyLogo + '\'' + 
			",how_to_apply = '" + howToApply + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",description = '" + description + '\'' + 
			",location = '" + location + '\'' + 
			",company = '" + company + '\'' + 
			",company_url = '" + companyUrl + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",type = '" + type + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}