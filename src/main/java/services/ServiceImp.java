package services;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ServiceImp implements Service {
    private WordsBighugelabsAPI wbhlAPI;
    private ConversorHelper conversor; 
    
    public ServiceImp(ConversorHelper conversor) {
        connect();
        this.conversor = conversor;
    }

    public void connect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://words.bighugelabs.com/api/2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        wbhlAPI = retrofit.create(WordsBighugelabsAPI.class);
    }

    public String getMeaning(String term) throws Exception {
        String meaning = null;
        Response<String> callResponse;
        callResponse = wbhlAPI.getTerm(term).execute();
        meaning = callResponse.body();
        meaning = conversor.convertString(meaning);
        return meaning;
    }

}
