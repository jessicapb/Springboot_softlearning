package com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyData {
    protected int workers;
    protected String socialreason;
    protected String companyType;

    protected CompanyData(){
    }

    public static CompanyData getInstanceCompanyData(int workers, String socialreason)throws BuildException {
        String message = "";
        CompanyData co = new CompanyData();
        int error = 0;

        if((error = co.setWorkers(workers)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = co.setSocialreason(socialreason)) !=0){
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            co = null;
            throw new BuildException(message);
        }
        return co;
    }

    public int getWorkers() {
        return workers;
    }

    public int setWorkers(int workers) {
        if(Check.isNegative(workers) !=0){
            return -3;
        }

        if(workers > 250){
            this.companyType = "Big Company";
        }else if(workers <= 50){
            this.companyType = "Small Company";
        }else{
            this.companyType = "Medium Company";
        }
        this.workers = workers;
        return 0;
    }

    public String getSocialreason() {
        return socialreason;
    }

    public int setSocialreason(String socialreason) {
        if(Check.isNull(socialreason) == true){
            return -1;
        }
        if(Check.minLenght(socialreason, 2) !=0){
            return -2;
        }
        this.socialreason = socialreason;
        return 0;
    }

    public String getCompanyType() {
        return companyType;
    }
}
