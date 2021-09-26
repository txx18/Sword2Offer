package designpattern.singleton.hungry;

/**
 * @author ShaneTang
 * @create 2021-04-10 20:53
 */
public class SingletonStaticCodeBlock {

    private SingletonStaticCodeBlock(){}

    private static SingletonStaticCodeBlock instance;

    static {
        instance = new SingletonStaticCodeBlock();
    }

    public SingletonStaticCodeBlock getInstance() {
        return instance;
    }
}
