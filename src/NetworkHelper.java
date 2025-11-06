import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class NetworkHelper {
    protected InetAddress address;
    public String hostName;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public NetworkHelper(){
        this.hostName = "www.google.com";
    }

    public void GetIpFromDomain(){
        try{
            address = InetAddress.getByName(this.getHostName());
            if (address.isReachable(5000)) {
                ShowMsg("IP :" + address.getHostName());
                ShowMsg("Ten mien :" + address.getHostAddress());
                ShowMsg("May chu ket noi on dinh");

            }
            else
                ShowMsg("May chu khong the ket noi");
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void GetSource(){
        try {
            URL url = new URL("https://" + this.getHostName());;
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = in.readLine()) != null){ // if đọc hết thì in toàn bộ file html ra
                ShowMsg(line);
            }
            in.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowMsg(String msg){
        System.out.println(msg);
    }
}
