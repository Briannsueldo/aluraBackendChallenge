package com.alura.api;

import java.util.Map;

import com.google.gson.Gson;

public class ApiConsultationObject extends ApiConsultation {
    
    protected String result;
    protected Map<String, Double> conversion_rates;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConvertionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public void executeRequest(String currency) {
        String jsonResponse = apiRequest(currency);

        if(jsonResponse != null) {
            Gson gson = new Gson();

            ApiConsultationObject responseObject = gson.fromJson(jsonResponse, ApiConsultationObject.class);

            this.result = responseObject.getResult();
            this.conversion_rates = responseObject.getConversionRates();
        }
    }

    public static ApiConsultationObject requestResult(String currency) {
        ApiConsultationObject consult = new ApiConsultationObject();

        consult.executeRequest(currency);

        return consult;

        /* System.out.println("Result " + consult.getResult());
        System.out.println("Convertion rates " + consult.getConversionRates()); */
    }
}
