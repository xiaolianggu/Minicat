package server;

import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

import webresource.Context;
import webresource.Host;

public class RequestProcessor extends Thread {

    private Socket socket;
    private Map<String,HttpServlet> servletMap;
    private Map<String,Host> hostMap;
    
    public RequestProcessor(Socket socket, Map<String, HttpServlet> servletMap,Map<String,Host> hostMap) {
        this.socket = socket;
        this.servletMap = servletMap;
        this.hostMap = hostMap;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());

           /* // 静态资源处理
            if(servletMap.get(request.getUrl()) == null) {
                response.outputHtml(request.getUrl());
            }else{
                // 动态资源servlet请求
                HttpServlet httpServlet = servletMap.get(request.getUrl());
                httpServlet.service(request,response);
            }*/
            String url = request.getUrl();
            String[] urlSplited = url.substring(1).split("/");
            HttpServlet httpServlet = null;
            Host host = hostMap.get(request.getHost());
            if(host != null) {
            	Context context = host.getByAppName(urlSplited[0]);
            	if(context != null) {
            		httpServlet = context.getByUrlPattern("/"+urlSplited[1]);
            		if(httpServlet != null) {
            			httpServlet.service(request,response);
            		}
            	}
            }
            
            if(httpServlet == null) {
            	response.outputHtml(request.getUrl());
            }
            

            socket.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
