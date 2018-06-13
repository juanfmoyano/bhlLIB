package ayds.dictionary.delta.services;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class BigHugeLabsServiceImp implements BigHugeLabsService {
    private WordsBighugelabsAPI wbhlAPI;
    private ConversorHelper conversor;
    private final String baseURL = "http://words.bighugelabs.com/api/2/";
    
    public BigHugeLabsServiceImp(ConversorHelper conversor) {
        connect();
        this.conversor = conversor;
    }

    private void connect() {
        Retrofit retrofit = createRetrofit();
        wbhlAPI = retrofit.create(WordsBighugelabsAPI.class);
    }

    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public String getMeaning(String term) throws Exception {
        Response<String> callResponse = callResponse(term);
        String meaning = callResponse.body();
        return finalConvertToString(meaning);
    }

    private Response<String> callResponse(String term) throws Exception{
        return wbhlAPI.getTerm(term).execute();
    }

    private String finalConvertToString(String meaning){
        return conversor.convertString(meaning);
    }
}
