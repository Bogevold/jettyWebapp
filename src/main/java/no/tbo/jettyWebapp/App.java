package no.tbo.jettyWebapp;

import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.server.WebSocketServerConnection;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Server srv = new Server();
        srv.setStopAtShutdown(true);
        ServerConnector sConn = new ServerConnector(srv);
        sConn.setPort(7219);
        srv.addConnector(sConn);
        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ctx.setContextPath("/");
        ctx.setResourceBase(System.getProperty("webapp.path"));
        ServletContextHandler wsCtx = new ServletContextHandler();
        wsCtx.setContextPath("/resst");

        ContextHandlerCollection ctxs = new ContextHandlerCollection();
        ctxs.setHandlers(new Handler[]{ctx, wsCtx});
        srv.setHandler(ctxs);
        ctx.addServlet(DefaultServlet.class, "/");

        // Initialize javax.websocket layer
        ServerContainer wsContainer = WebSocketServer
    }
}
