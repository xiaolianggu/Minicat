package server;

import java.io.IOException;
import java.io.InputStream;

/**
 * 把请求信息封装为Request对象（根据InputSteam输入流封装）
 */
public class Request {

    private String method; // 请求方式，比如GET/POST
    private String url;  // 例如 /,/index.html
    private String host;
    private int port;
    private InputStream inputStream;  // 输入流，其他属性从输入流中解析出来


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    
    public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Request() {
    }


    // 构造器，输入流传入
    public Request(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;

        // 从输入流中获取请求信息
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }

        byte[] bytes = new byte[count];
        inputStream.read(bytes);

        String inputStr = new String(bytes);
        // 获取第一行请求头信息
        String[] inputStrSplited = inputStr.split("\\n");  // GET / HTTP/1.1
        String[] strings = inputStrSplited[0].split(" ");

        String urlAddressLine = null;
        for(String str :inputStrSplited) {
        	if(str.startsWith("Host")) {
        		urlAddressLine = str;
        	}
        }
        String[] urlAddressLineSplited = urlAddressLine.split(" ");
        String[] urlAddressSplited = urlAddressLineSplited[1].split(":");
        this.method = strings[0];
        this.url = strings[1];
        this.host = urlAddressSplited[0];
        String portStr = urlAddressSplited[1].replace("\r", "");
        System.out.println("=====>>method:" + method);
        System.out.println("=====>>url:" + url);
        System.out.println("=====>>host:" + host);
        System.out.println("=====>>port:" + port);

    }
}
