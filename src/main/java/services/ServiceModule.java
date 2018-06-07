package services;

public class ServiceModule {
        private static ServiceModule instance;
        private Service service;

        private ServiceModule() {
            ConversorHelper conversor = new ConversorHelperImp();
            
            service = new ServiceImp(conversor);
        }

        public static ServiceModule getInstance() {
            if (instance == null)
                instance = new ServiceModule();
            return instance;
        }

        public Service getService(){
            return service;
        }
}
