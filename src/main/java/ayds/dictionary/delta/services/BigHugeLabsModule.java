package ayds.dictionary.delta.services;

public class BigHugeLabsModule {
        private static BigHugeLabsModule instance;
        private BigHugeLabsService bigHugeLabsService;

        private BigHugeLabsModule() {
            ConversorHelper conversor = new ConversorHelperImp();
            
            bigHugeLabsService = new BigHugeLabsServiceImp(conversor);
        }

        public static BigHugeLabsModule getInstance() {
            if (instance == null)
                instance = new BigHugeLabsModule();
            return instance;
        }

        public BigHugeLabsService getBigHugeLabsService(){
            return bigHugeLabsService;
        }
}
