package CompDecomp.comp_decomp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.zip.GZIPInputStream;

public class decompress {
    public static void method(File file) throws IOException{
//         Storing the directory of the selected file
        String fileDirectory = file.getParent();

//         file input stream to read data from the file in the form of bytes
        FileInputStream fis = new FileInputStream(file);
//         creates a new input stream with default buffer size
        GZIPInputStream gzip = new GZIPInputStream(fis);
//         output stream to write or store the data to the file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/decompressedFile.jpg");

//         using buffer array to write the decompressed file in bytes format in output stream
        byte[] buffer = new byte[1024];
        int len;

        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

//         Closing all streams and releasing any system resources associated with the streams
        gzip.close();
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
//         creating an object of File class to pass it to the method function for further operation
        File path = new File("");
        method(path);
    }
}
