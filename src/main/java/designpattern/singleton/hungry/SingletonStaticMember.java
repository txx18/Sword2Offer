package designpattern.singleton.hungry;

/**
 * @author ShaneTang
 * @create 2021-04-09 21:52
 */
public class SingletonStaticMember {

    private static SingletonStaticMember instance = new SingletonStaticMember();

    public static SingletonStaticMember getInstance() {
        return instance;
    }
}
