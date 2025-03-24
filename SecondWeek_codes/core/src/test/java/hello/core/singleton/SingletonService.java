package hello.core.singleton;

public class SingletonService {

    private static final SingletonService singletonInstance = new SingletonService();

    public static SingletonService getSingletonInstance() {
        return singletonInstance;
    }

    private SingletonService() {

    }

    public void singletonLogic() {

    }
}
