/*
 * Java Unix Sockets Library
 *
 * Copyright (c) Matthew Johnson 2004
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * To Contact the author, please email src@matthew.ath.cx
 *
 */
package cx.ath.matthew.unix;

import java.io.IOException;

/**
 * Represents a listening UNIX Socket.
 */
public class UnixUdpSocket extends BaseUnixSocket
{
   static { System.loadLibrary("unix-java"); }
   private native int native_bind(String address, boolean abs) throws IOException;
   private native int native_connect(int sock, String address, boolean abs) throws IOException;
   private native int native_send(int sock, byte[] b, int off, int len) throws IOException;
   private native int native_recv(int sock, byte[] b, int off, int len) throws IOException;
   private UnixSocketAddress dstAddress = null;
   private boolean bound = false;
   private boolean connected = false;
   /**
    * Create an un-bound server socket.
    */
   public UnixUdpSocket()
   {
   }
   /**
    * Create an udp socket bound to the given address.
    * @param address Path to the socket.
    */
   public UnixUdpSocket(UnixSocketAddress srcAddress, UnixSocketAddress dstAddress) throws IOException
   {
      bindAndConnect(srcAddress, dstAddress);
   }
   /**
    * Create an udp socket bound to the given address.
    * @param address Path to the socket.
    */
   public UnixUdpSocket(String srcAddress, String dstAddress) throws IOException
   {
      this(new UnixSocketAddress(srcAddress), new UnixSocketAddress(dstAddress));
   }
   /**
    * Binds a server socket to the given address.
    * @param address Path to the socket.
    */
   private void bind(UnixSocketAddress address) throws IOException
   {
      if (bound) close();
      sock = native_bind(address.path, address.abs);
      bound = true;
      closed = false;
      connected = false;
      this.address = address;
      dstAddress = null;
   }
   /**
    * Connect the socket to this address.
    * @param address The Unix Socket address to connect to
    */
   private void connect(UnixSocketAddress address) throws IOException
   {
      sock = native_connect(sock, address.path, address.abs);
      dstAddress = address;
      connected = true;
   }
   /**
    * Bind and connect the socket to these addresses.
    * @param srcAddress The Unix Socket address to bind to
    * @param dstAddress The Unix Socket address to connect to
    */
   public void bindAndConnect(UnixSocketAddress srcAddress, UnixSocketAddress dstAddress) throws IOException
   {
      bind(srcAddress);
      connect(dstAddress);
   }
   /**
    * Bind and connect the socket to these addresses.
    * @param srcAddress The Unix Socket address to bind to
    * @param dstAddress The Unix Socket address to connect to
    */
   public void bindAndConnect(String srcAddress, String dstAddress) throws IOException
   {
      bindAndConnect(new UnixSocketAddress(srcAddress), new UnixSocketAddress(dstAddress));
   }
   /**
    * Send a message.
    * @param message The message to send
    */
   public int send(byte[] message, int off, int len) throws IOException
   {
      return native_send(sock, message, off, len);
   }
   /**
    * Send a message.
    * @param message The message to send
    */
   public int send(String message) throws IOException
   {
      return send(message.getBytes(), 0, message.length());
   }
   /**
    * Receive a message.
    */
   public int receive(byte[] b, int off, int len) throws IOException
   {
      if (closed) throw new NotConnectedException();
      int count = native_recv(sock, b, off, len);
      /* Yes, I really want to do this. Recv returns 0 for 'connection shut down'.
       * read() returns -1 for 'end of stream'.
       * Recv returns -1 for 'EAGAIN' (all other errors cause an exception to be raised)
       * whereas read() returns 0 for '0 bytes read', so yes, I really want to swap them here.
       */
      if (0 == count) return -1;
      else if (-1 == count) return 0;
      else return count;
   }
   /**
    * Return the address this socket is connected to.
    * @return The UnixSocketAddress if connected or null if unconnected.
    */
   public UnixSocketAddress getDestinationAddress()
   {
      return dstAddress;
   }
   /**
    * Check the status of the socket.
    * @return True if bound.
    */
   public boolean isBound()
   {
      return bound;
   }
   /**
    * Check the socket status.
    * @return true if connected.
    */
   public boolean isConnected()
   {
      return connected;
   }
}
