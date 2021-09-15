package usecase;


import java.io.File;
import java.io.IOException;

/**
 * @author ShaneTang
 * @create 2021-05-30 16:48
 */
public class CallbackDemo {

    @org.junit.Test
    public void test() {
        Client client = new Client();
        client.saveStr();
    }

    static class Client implements IFileIOCallback {

        public void saveStr() {
            FileIOCallback fileIOCallback = new FileIOCallback();
            fileIOCallback.saveStrToFile("callback.txt", "这是一个回调的例子", this);
        }

        @Override
        public void onResult(boolean isSave) {
            System.out.println(isSave ? "保存成功" : "保存失败");
        }
    }

    interface IFileIOCallback {
        void onResult(boolean isSave);
    }

    static class FileIOCallback {
        public void saveStrToFile(String fileName, String content, IFileIOCallback callback) {
            new Thread(() -> {
                try {
                    File file = getExistsFile(fileName);
                    writeStrToFile(content, file);
//                    int i = 1 / 0;
                    callback.onResult(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onResult(false);
                }
            }).start();
        }

        private void writeStrToFile(String content, File file) throws IOException {

        }

        private File getExistsFile(String fileName) throws IOException {
            return null;
        }
    }

    class FileIOThread {
        public void saveStrToFile(String fileName, String content) {
            new Thread(() -> {
                try {
                    File file = getExistsFile(fileName);
                    writeStrToFile(content, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        private void writeStrToFile(String content, File file) throws IOException {

        }

        private File getExistsFile(String fileName) throws IOException {
            return null;
        }
    }

    static class FileIO {
        public boolean saveStrToFile(String fileName, String content) {
            try {
                File file = getExistsFile(fileName);
                writeStrToFile(content, file);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        private void writeStrToFile(String content, File file) throws IOException {

        }

        private File getExistsFile(String fileName) throws IOException {
            return null;
        }
    }
}
