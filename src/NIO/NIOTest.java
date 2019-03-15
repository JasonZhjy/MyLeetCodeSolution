package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {
    public static void main (String[] args) {

    }

    public static void copy (String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);

        FileChannel inputFileChannel = fis.getChannel();
        FileChannel outputChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            int length = inputFileChannel.read(buffer);
            if (length == -1) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }

        inputFileChannel.close();
        outputChannel.close();
    }
}
